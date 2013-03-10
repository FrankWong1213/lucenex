package com.frankwong.lucenex.util;

/**
 * @ClassName: BeansEnum.java
 * @Description: 系统需要索引的bean的大类
 * @author frankwong
 * @version V1.0
 * @Date Feb 27, 2013 2:24:40 PM
 */
public enum BeanEnum {

	Blog("blog"), New("new");// 枚举元素列表

	private String name;

	private BeanEnum(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
	
	public String getKeyWordIndex(){
		return "beanName";
	}
}
