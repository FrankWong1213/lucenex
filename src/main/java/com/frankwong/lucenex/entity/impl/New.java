package com.frankwong.lucenex.entity.impl;

import java.util.List;

import com.frankwong.lucenex.entity.IMyIndex;
import com.frankwong.lucenex.util.BeanEnum;
import com.frankwong.lucenex.util.MyField;

/**
 * @ClassName:     New.java
 * @Description:   新闻实体类
 * @author         frankwong
 * @version        V1.0  
 * @Date           Feb 27, 2013 2:32:22 PM 
 */
public class New implements IMyIndex {


	private static final long serialVersionUID = 7141737381681552326L;

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#getId()
	 */
	@Override
	public long getId() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetStoreFields()
	 */
	@Override
	public String[] GetStoreFields() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetIndexFields()
	 */
	@Override
	public String[] GetIndexFields() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetBoost()
	 */
	@Override
	public float GetBoost() {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetFieldList()
	 */
	@Override
	public List<MyField> GetFieldList() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetBeanEnum()
	 */
	@Override
	public BeanEnum GetBeanEnum() {
		return null;
	}

}
