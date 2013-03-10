package com.frankwong.lucenex.util;

import org.apache.lucene.document.Field;


/**
 * @ClassName:     MyField.java
 * @Description:   自已再封装一层Field
 * @author         frankwong
 * @version        V1.0  
 * @Date           Feb 27, 2013 11:18:24 AM 
 */
public class MyField {

	private String key;//要索引的关键字
	private Object value;//要索引的内容
	private Field.Store store;//是否哦存储
	private MyFieldEnum fieldEnum;//全文匹配还是词法匹配
	/**
	 * @return the keyStr
	 */
	public MyField(String key,Object value){
		this.key = key;
		this.value = value;
		store = Field.Store.YES;
		fieldEnum = MyFieldEnum.TextType;
	}
	
	public MyField(String key,Object value,Field.Store store,MyFieldEnum fieldEnum){
		this.key = key;
		this.value = value;
		this.store = store;
		this.fieldEnum = fieldEnum;
	}
	public Object getKey() {
		return key;
	}
	/**
	 * @param keyStr the keyStr to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the store
	 */
	public Field.Store getStore() {
		if(store == null){
			store = Field.Store.NO;
		}
		return store;
	}
	/**
	 * @param store the store to set
	 */
	public void setStore(Field.Store store) {
		this.store = store;
	}
	/**
	 * @return the indexEnum
	 */
	public MyFieldEnum getFieldEnum() {
		if(fieldEnum == null){
			fieldEnum = MyFieldEnum.StringType;
		}
		return fieldEnum;
	}
	/**
	 * @param indexEnum the indexEnum to set
	 */
	public void setIndexEnum(MyFieldEnum indexEnum) {
		this.fieldEnum = indexEnum;
	}

	/**
	 * @return the valueStr
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * @param valueStr the valueStr to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
