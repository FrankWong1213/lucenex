package com.frankwong.lucenex.index;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;

import com.frankwong.lucenex.entity.IMyIndex;
import com.frankwong.lucenex.entity.impl.Blog;
import com.frankwong.lucenex.util.MyField;
import com.frankwong.lucenex.util.ObjectTransformUtil;

/**
 * @ClassName: IndexFiles.java
 * @Description: 索引的曾删改操作
 * @author frankwong
 * @version V1.0
 * @Date Feb 27, 2013 2:09:04 PM
 */
public class IndexFiles {

	/**  
	 * @Description:  增加索引
	 * @param:        @param indexWriter
	 * @param:        @param myIndex
	 * @param:        @throws IOException    
	 * @return:       void    
	 * @throws  
	 */
	public void addDoc(IndexWriter indexWriter, IMyIndex myIndex)
			throws IOException {
		Document doc = new Document();
		List<MyField> list = myIndex.GetFieldList();
		Iterator<MyField> it = list.iterator();
		while (it.hasNext()) {
			MyField myField = it.next();
			switch (myField.getFieldEnum()) {
			case StringType:
				StringField strField = new StringField(myField.getKey().toString(),
						myField.getValue().toString(), myField.getStore());
				doc.add(strField);
				break;
			case TextType:
				TextField textField = new TextField(myField.getKey().toString(),
						myField.getValue().toString(), myField.getStore());
				doc.add(textField);
				break;
			case LongType:
				LongField longField = new LongField(myField.getKey().toString(),
						ObjectTransformUtil.getLong(myField.getValue()), myField.getStore());
				doc.add(longField);
				break;
			default:
				break;
			}
		}
		StringField beanField = new StringField(myIndex.GetBeanEnum()
				.getKeyWordIndex(), myIndex.GetBeanEnum().toString(),
				Field.Store.YES);
		doc.add(beanField);
		indexWriter.addDocument(doc);
	}

	/**  
	 * @Description:  根据数据库ID进行索引更新
	 * @param:        @param indexWriter
	 * @param:        @param myIndex
	 * @param:        @param id
	 * @param:        @throws IOException    
	 * @return:       void    
	 * @throws  
	 */
	public void updateDoc(IndexWriter indexWriter,IMyIndex myIndex,long id) throws IOException {
		Document doc = new Document();
		List<MyField> list = myIndex.GetFieldList();
		Iterator<MyField> it = list.iterator();
		while (it.hasNext()) {
			MyField myField = it.next();
			switch (myField.getFieldEnum()) {
			case StringType:
				StringField strField = new StringField(myField.getKey().toString(),
						myField.getValue().toString(), myField.getStore());
				doc.add(strField);
				break;
			case TextType:
				TextField textField = new TextField(myField.getKey().toString(),
						myField.getValue().toString(), myField.getStore());
				doc.add(textField);
				break;
			case LongType:
				LongField longField = new LongField(myField.getKey().toString(),
						ObjectTransformUtil.getLong(myField.getValue()), myField.getStore());
				doc.add(longField);
				break;
			default:
				break;
			}
		}
		StringField beanField = new StringField(myIndex.GetBeanEnum()
				.getKeyWordIndex(), myIndex.GetBeanEnum().toString(),
				Field.Store.YES);
		doc.add(beanField);
		indexWriter.updateDocument(new Term("id",id+""), doc);
        indexWriter.close();
	}

	/**  
	 * @Description:  删除索引
	 * @param:        @param indexWriter
	 * @param:        @param term
	 * @param:        @throws IOException    
	 * @return:       void    
	 * @throws  
	 */
	public void deleteDoc(IndexWriter indexWriter, Term term) throws IOException {
		indexWriter.deleteDocuments(term);
		indexWriter.close();
	}

	/**  
	 * @Description:  删除索引
	 * @param:        @param indexWriter
	 * @param:        @param terms
	 * @param:        @throws IOException    
	 * @return:       void    
	 * @throws  
	 */
	public void deleteDoc(IndexWriter indexWriter, Term[] terms) throws IOException {
		indexWriter.deleteDocuments(terms);
		indexWriter.close();
	}


	/**  
	 * @Description:  删除索引
	 * @param:        @param indexWriter
	 * @param:        @param query
	 * @param:        @throws IOException    
	 * @return:       void    
	 * @throws  
	 */
	public void deleteDoc(IndexWriter indexWriter, Query query) throws IOException {
		indexWriter.deleteDocuments(query);
		indexWriter.close();
	}

	/**  
	 * @Description:  删除索引
	 * @param:        @param indexWriter
	 * @param:        @param queries
	 * @param:        @throws IOException    
	 * @return:       void    
	 * @throws  
	 */
	public void deleteDoc(IndexWriter indexWriter, Query[] queries) throws IOException {
		indexWriter.deleteDocuments(queries);
		indexWriter.close();
	}
	
	/**  
	 * @Description:  main method
	 * @param:        @param args
	 * @param:        @throws IOException    
	 * @return:       void    
	 * @throws  
	 */
	public static void main(String[] args) throws IOException {
		IndexFiles indexFiles = new IndexFiles();
		Blog blog = new Blog(null, null, null);
		indexFiles.addDoc(null, blog);
	}
}
