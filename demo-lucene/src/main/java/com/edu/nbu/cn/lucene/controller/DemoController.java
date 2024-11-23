package com.edu.nbu.cn.lucene.controller;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wltea.analyzer.lucene.IKAnalyzer;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author laoshi . hua
 * @version 1.0 2023/7/25-4:57 PM
 * @since 1.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

//    @Resource
//    private BasicHealthInfoPOService basicHealthInfoPOService;
//
//    @GetMapping("/getAll")
//    public String getAll(){
//        return basicHealthInfoPOService.getAll().toString();
//    }
//
//    @GetMapping("/createIndex")
//    public String createIndex(){
//        File dir = new File("/Users/fanwenhao/my-projects/DEMO-ALL/demo-lucene/src/test/");
//        Directory directory = null;
//        try {
//            directory = FSDirectory.open(dir.toPath());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        Analyzer analyzer = new IKAnalyzer();
//        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
//        IndexWriter indexWriter = null;
//        try {
//            indexWriter = new IndexWriter(directory,indexWriterConfig);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            indexWriter.deleteAll();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        List<BasicHealthInfoPO> basicData = basicHealthInfoPOService.getAll();
//        for (BasicHealthInfoPO po : basicData){
//            Document doc = new Document();
//            doc.add(new LongField("id", po.getId(), Field.Store.YES));
//            doc.add(new StringField("gmt_created", po.getGmtCreated().toString(), Field.Store.YES));
//            doc.add(new StringField("gmt_modified", po.getGmtModified().toString(), Field.Store.YES));
//            doc.add(new LongField("people_id", po.getPeopleId(), Field.Store.YES));
//            doc.add(new StringField("name", po.getName(), Field.Store.YES));
//            doc.add(new StringField("phone_number", po.getPhoneNumber() == null ? "无号码" : po.getPhoneNumber(), Field.Store.YES));
//            doc.add(new StringField("date_of_birth", po.getDateOfBirth() == null ? "无数据" : po.getDateOfBirth(), Field.Store.YES));
//            doc.add(new StringField("id_card_no", po.getIdCardNo() == null ? "无数据" : po.getIdCardNo(), Field.Store.YES));
//            try {
//                indexWriter.addDocument(doc);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        try {
//            indexWriter.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//       return "create index successfully!";
//    }

    @GetMapping("/query")
    public String query(){
        StringBuilder sb = new StringBuilder();
        File dir = new File("/Users/fanwenhao/my-projects/DEMO-ALL/demo-lucene/src/test/");
        Directory directory = null;
        try {
            directory = FSDirectory.open(dir.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        IndexReader indexReader = null;
        try {
            indexReader = DirectoryReader.open(directory);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        IndexSearcher searcher = new IndexSearcher(indexReader);

        Query query = new TermQuery(new Term("name","付莹"));
        TopDocs topDocs = null;
        try {
            topDocs = searcher.search(query,100);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int totalHits = topDocs.totalHits;
        System.out.println("符合条件的文档数：" + totalHits);

        ScoreDoc[] scores = topDocs.scoreDocs;
        for(ScoreDoc scoreDoc : scores){
            //文档id
            int docId = scoreDoc.doc;
            //通过文档id获取文档对象
            Document doc = null;
            try {
                doc = searcher.doc(docId);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sb.append("id-->" + doc.get("id") + ";");
            sb.append("gmt_created-->" + doc.get("gmt_created") + ";");
            sb.append("gmt_modified-->" + doc.get("gmt_modified") + ";");
            sb.append("people_id-->" + doc.get("people_id") + ";");
            sb.append("name-->" + doc.get("name") + ";");
            sb.append("phone_number-->" + doc.get("phone_number") + ";");
            sb.append("date_of_birth-->" + doc.get("date_of_birth") + ";");
            sb.append("id_card_no-->" + doc.get("id_card_no") + ";");
            sb.append("****************************" + "\n");
        }
        try {
            indexReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }
}
