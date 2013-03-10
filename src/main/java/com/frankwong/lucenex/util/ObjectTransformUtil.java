package com.frankwong.lucenex.util;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * @ClassName: ObjectTransformUtil.java
 * @Description: 基本数据类型之间的相互转化
 * @author frankwong
 * @version V1.0
 * @Date Feb 28, 2013 2:42:17 PM
 */
public class ObjectTransformUtil {

	public static Long getLong(Object obj) {
		if (obj == null || false == NumberUtils.isNumber(obj + ""))
			return 0L;
		return Long.valueOf(obj + "");
	}
}
