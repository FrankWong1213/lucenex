package com.frankwong.lucenex.entity.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.lucene.document.Field;

import com.frankwong.lucenex.entity.IMyIndex;
import com.frankwong.lucenex.util.BeanEnum;
import com.frankwong.lucenex.util.MyField;
import com.frankwong.lucenex.util.MyFieldEnum;

/**
 * @ClassName:     Blog.java
 * @Description:   TODO
 * @author         frankwong
 * @version        V1.0  
 * @Date           Feb 27, 2013 10:58:06 AM 
 */
public class Blog implements IMyIndex {

	private static final long serialVersionUID = 6297506907999570597L;

	private long id;
	private String title;//标题
	private String content;//正文
	private Date createTime;//创建时间
	private String author;//作者
	
	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#getId()
	 */
	public Blog(String title,String content,String author){
		this.title = title;
		this.content = content;
		this.author = author;
		this.id = 0;
	}
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetStoreFields()
	 */
	@Override
	public String[] GetStoreFields() {
		return new String[]{"id","title","content","createTime","author"};
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetIndexFields()
	 */
	@Override
	public String[] GetIndexFields() {
		// TODO Auto-generated method stub
		return new String[]{"id","title","content","author"};
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
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
		List<MyField> fieldList = new ArrayList<MyField>();
		MyField myfield = new MyField("title",title,Field.Store.YES,MyFieldEnum.TextType);
		fieldList.add(myfield);
		myfield = new MyField("content",content,Field.Store.YES,MyFieldEnum.TextType);
		fieldList.add(myfield);
		myfield = new MyField("author",author,Field.Store.YES,MyFieldEnum.StringType);
		fieldList.add(myfield);
		myfield = new MyField("id",id,Field.Store.YES,MyFieldEnum.StringType);
		fieldList.add(myfield);
		return fieldList;
	}

	/* (non-Javadoc)
	 * @see com.frankwong.lucenex.entity.IMyIndex#GetBeanEnum()
	 */
	@Override
	public BeanEnum GetBeanEnum() {
		return BeanEnum.Blog;
	}
}
