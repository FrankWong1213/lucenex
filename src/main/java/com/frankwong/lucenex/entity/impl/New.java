package com.frankwong.lucenex.entity.impl;

import java.util.List;

import com.frankwong.lucenex.entity.IMyIndex;
import com.frankwong.lucenex.util.BeanEnum;
import com.frankwong.lucenex.util.MyField;

/**
 * @ClassName:     New.java
 * @Description:   TODO
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
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetStoreFields()
	 */
	@Override
	public String[] GetStoreFields() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetIndexFields()
	 */
	@Override
	public String[] GetIndexFields() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetBoost()
	 */
	@Override
	public float GetBoost() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetFieldList()
	 */
	@Override
	public List<MyField> GetFieldList() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetBeanEnum()
	 */
	@Override
	public BeanEnum GetBeanEnum() {
		// TODO Auto-generated method stub
		return null;
	}

}
