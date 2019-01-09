package com.daoshan.school.utils.md5;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * 用来处理密码加密处理
 * 
 * @author 张崇宝
 *
 */
public class Md5 {
    
    /**
     * 处理密码加密处理
     * @param param
     * @return md5str
     *       (加密后的字符串)
     */
    public static String getMd5ByParams(String param){
        
        String md5Digest = DigestUtils.md5Hex(param);
        return md5Digest;
    }
}
