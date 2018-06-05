package com.daoshan.school.aop.AspectControl;

import com.cohen.redis.assembly.cache.Cache;
import com.cohen.redis.assembly.cache.RedisCache;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantReadWriteLock;

//@Aspect
//@Component
public class RedisCacheHandle {
    private static final Logger LOG = LoggerFactory.getLogger(com.cohen.redis.assembly.RedisCacheHandler.class);
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Cache redisCache;

    private RedisCacheHandle() {
    }

    public RedisCacheHandle(RedisCache redisCache) {
        this.redisCache = redisCache;
    }

    @Around("@annotation(com.cohen.redis.annotation.RedisCached)")
    public Object cached(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        Signature signature = joinPoint.getSignature();
        String className = signature.getDeclaringTypeName();
        StringBuffer sb = new StringBuffer();
        sb.append(signature.getName());
        Object[] args = joinPoint.getArgs();
        Object[] var7 = args;
        int var8 = args.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            Object arg = var7[var9];
            sb.append(":").append(arg.toString());
        }

        String key = sb.toString();
        this.lock.readLock().lock();
        if (this.redisCache.contains(className, key)) {
            try {
                result = this.redisCache.queryFromCache(className, key);
            } finally {
                this.lock.readLock().unlock();
            }
        } else {
            this.lock.readLock().unlock();
            this.lock.writeLock().lock();
            if (!this.redisCache.contains(className, key)) {
                try {
                    result = joinPoint.proceed(args);
                    this.redisCache.updateToCache(className, key, result);
                } finally {
                    this.lock.writeLock().unlock();
                }
            } else {
                this.lock.writeLock().unlock();
                this.lock.readLock().lock();

                try {
                    result = this.redisCache.queryFromCache(className, key);
                } finally {
                    this.lock.readLock().unlock();
                }
            }
        }

        return result;
    }

    @After("@annotation(com.cohen.redis.annotation.RedisCleared)")
    public void clear(JoinPoint joinPoint) throws Exception {
        Signature signature = joinPoint.getSignature();
        String className = signature.getDeclaringTypeName();
        if (this.redisCache.containsNamespace(className)) {
            this.redisCache.clearCache(className);
        }

    }
}