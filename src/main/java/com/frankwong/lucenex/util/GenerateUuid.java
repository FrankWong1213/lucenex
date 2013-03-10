package com.frankwong.lucenex.util;

import java.util.UUID;

/**
 * @ClassName: GenerateUuid.java
 * @Description: 生成UUID
 * @author FrankWong
 * @version V1.0
 * @Date 2013-2-23 下午8:15:07
 */
public class GenerateUuid {
	public static String generateUuid() {
		String uuidStr = UUID.randomUUID().toString();
		return uuidStr.substring(0, 8) + uuidStr.substring(9, 13)
				+ uuidStr.substring(14, 18) + uuidStr.substring(19, 23)
				+ uuidStr.substring(24);
	}
}
