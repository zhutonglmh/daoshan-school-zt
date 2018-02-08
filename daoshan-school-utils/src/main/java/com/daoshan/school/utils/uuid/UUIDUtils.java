package com.daoshan.school.utils.uuid;

import java.util.Objects;
import java.util.UUID;

/**
 * uuid工具类
 * 
 * @author ydl
 *
 */
public class UUIDUtils {
	/**
	 * object转uuid
	 * @param object
	 * @return
	 */
	public static String object2UUID(Object object) {
		if(object==null)
			return "";
		return String.valueOf(object);
	}

	/**
	 * 获取随机的UUID
	 * @return
	 */
	public static String getUUID() {
		return String.valueOf(UUID.randomUUID());
	}

	/**
	 * 字符串转UUID
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String string2UUID(String str) throws Exception {
		try {
			return str;
		} catch (Exception e) {
			throw new Exception("String to UUID error,String content is " + str);
		}
	}
	
	/**
	 * 获取随机UUID串
	 * @return
	 */
	public static String getUUIDStr(){
		return Objects.toString(getUUID());
	}
}
