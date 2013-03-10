package com.frankwong.lucenex.entity;

import java.io.Serializable;
import java.util.List;

import com.frankwong.lucenex.util.BeanEnum;
import com.frankwong.lucenex.util.MyField;

/**
 * @ClassName: IMyIndex.java
 * @Description: 支持搜索功能的Bean类必须实现该接口
 * @author frankwong
 * @version V1.0
 * @Date Feb 27, 2013 10:54:48 AM
 */
public interface IMyIndex extends Serializable {

	public long getId();

	/** 
	 * 返回搜索对象需要存储的字段名
	 * return
	 */
	public String[] GetStoreFields();
	
	/**
	 * 返回搜索对象的索引字段
	 * return
	 */
	public String[] GetIndexFields();

	/**
	 * 返回文档权重
	 */
	public float GetBoost();

	/**
	 * 返回要存储的所有字段和内容
	 */
	public List<MyField> GetFieldList();

	/**
	 * 返回索引对象的大类，如 New(新闻)，Blog(博客)
	 */
	public BeanEnum GetBeanEnum();
}
