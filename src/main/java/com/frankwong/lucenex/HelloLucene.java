package com.frankwong.lucenex;

/**
 * @ClassName:     HelloLucene.java
 * @Description:   Lucene Demo
 * @author         frankwong
 * @version        V1.0  
 * @Date           Feb 22, 2013 9:35:34 AM 
 */
import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.frankwong.lucenex.util.GenerateUuid;

public class HelloLucene {

	public static void main(String[] args) throws IOException, ParseException {
		// 0. Specify the analyzer for tokenizing text.
		// The same analyzer should be used for indexing and searching
		Analyzer analyzer = new IKAnalyzer(true);
		String indexPath = "E:\\lucene\\StoreIndex";
		// 1. create the index
		Directory dir = FSDirectory.open(new File(indexPath));

		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40,
				analyzer);
		// config.setOpenMode(OpenMode.CREATE);
		IndexWriter w = new IndexWriter(dir, config);
		addDoc(w, "网经科技有限公司", "193398817");
		addDoc(w, "网易科技", "55320055Z");
		w.commit();
		addDoc(w, "百度科技公司 Gigabytes", "55063554A");
		addDoc(w, "The Art of Computer Science", "9900333X");
		w.close();

		// 2. query
		String querystr = "科技";

		// the "title" arg specifies the default field to use
		// when no field is explicitly specified in the query.
		Query q = new QueryParser(Version.LUCENE_40, "title", analyzer)
				.parse(querystr);

		// 3. search
		int hitsPerPage = 10;
		IndexReader reader = DirectoryReader.open(dir);
		IndexSearcher searcher = new IndexSearcher(reader);
		TopScoreDocCollector collector = TopScoreDocCollector.create(
				hitsPerPage, true);
		searcher.search(q, collector);
		System.out.println(collector.getTotalHits());
		ScoreDoc[] hits = collector.topDocs().scoreDocs;
		
		TopScoreDocCollector results = TopScoreDocCollector.create(collector.getTotalHits(), false);
		searcher.search(q, results);
		
		ScoreDoc[] topdocs= results.topDocs(0, 7).scoreDocs;

		System.out.println(topdocs.length);
		// 4. display results
		System.out.println("Found " + hits.length + " hits.");
		for (int i = 0; i < hits.length; ++i) {
			int docId = hits[i].doc;
			Document d = searcher.doc(docId);
			System.out.println((i + 1) + ". " + d.get("isbn") + "\t"
					+ d.get("title") + "\t" + d.get("id"));
		}

		// reader can only be closed when there
		// is no need to access the documents any more.
		reader.close();
	}

	private static void addDoc(IndexWriter w, String title, String isbn)
			throws IOException {
		Document doc = new Document();
		doc.add(new TextField("title", title, Field.Store.YES));
		doc.add(new StringField("id", GenerateUuid.generateUuid(),
				Field.Store.YES));
		// use a string field for isbn because we don't want it tokenized
		doc.add(new StringField("isbn", isbn, Field.Store.NO));
		w.addDocument(doc);
	}
}
