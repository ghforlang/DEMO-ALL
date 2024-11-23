package com.edu.nbu.cn.lucene;

import com.edu.nbu.cn.lucene.domain.BasicHealthInfoPO;
import com.edu.nbu.cn.lucene.service.BasicHealthInfoPOService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/25-3:06 PM
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LuceneDemoApplication.class)
@MapperScan("com.edu.nbu.cn.lucene.mapper")
public class LuceneDemoApplicationTest {
    @Autowired
    private BasicHealthInfoPOService basicHealthInfoPOService;

    @Test
    public void testCreateIndex() throws IOException {
        File dir = new File("/Users/fanwenhao/my-projects/DEMO-ALL/demo-lucene/src/test/");
        Directory directory = FSDirectory.open(dir.toPath());

        Analyzer analyzer = new IKAnalyzer();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
        indexWriter.deleteAll();

        List<BasicHealthInfoPO> basicData = basicHealthInfoPOService.getAll();
        for (BasicHealthInfoPO po : basicData){
            Document doc = new Document();
            doc.add(new LongField("id", po.getId(), Field.Store.YES));
            doc.add(new StringField("gmt_created", po.getGmtCreated().toString(), Field.Store.YES));
            doc.add(new StringField("gmt_modified", po.getGmtModified().toString(), Field.Store.YES));
            doc.add(new LongField("people_id", po.getPeopleId(), Field.Store.YES));
            doc.add(new StringField("name", po.getName(), Field.Store.YES));
            doc.add(new StringField("phone_number", po.getPhoneNumber(), Field.Store.YES));
            doc.add(new StringField("date_of_birth", po.getDateOfBirth(), Field.Store.YES));
            doc.add(new StringField("id_card_no", po.getIdCardNo(), Field.Store.YES));
            indexWriter.addDocument(doc);
        }
        indexWriter.close();
        System.out.println("create index successfully!");

    }

    @Test
    public void testQuery() throws Exception {
        File dir = new File("/Users/fanwenhao/my-projects/DEMO-ALL/demo-lucene/src/test/");
        Directory directory = FSDirectory.open(dir.toPath());
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(indexReader);

        Query query = new TermQuery(new Term("name","付莹"));
        TopDocs topDocs = searcher.search(query,100);
        int totalHits = topDocs.totalHits;
        System.out.println("符合条件的文档数：" + totalHits);

        ScoreDoc[] scores = topDocs.scoreDocs;
        for(ScoreDoc scoreDoc : scores){
            //文档id
            int docId = scoreDoc.doc;
            //通过文档id获取文档对象
            Document doc = searcher.doc(docId);
            System.out.println("id-->" + doc.get("id"));
            System.out.println("gmt_created-->" + doc.get("gmt_created"));
            System.out.println("gmt_modified-->" + doc.get("gmt_modified"));
            System.out.println("people_id-->" + doc.get("people_id"));
            System.out.println("name-->" + doc.get("name"));
            System.out.println("phone_number-->" + doc.get("phone_number"));
            System.out.println("date_of_birth-->" + doc.get("date_of_birth"));
            System.out.println("id_card_no-->" + doc.get("id_card_no"));
            System.out.println("****************************");
        }
        indexReader.close();
    }
}
