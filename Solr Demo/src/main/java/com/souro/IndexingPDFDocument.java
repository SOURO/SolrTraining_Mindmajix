package com.souro;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class IndexingPDFDocument {
    public static void main(String args[]) throws Exception {
        String urlString = "http://localhost:8983/solr/souro_core2";
        SolrClient Solr = new HttpSolrClient.Builder(urlString).build();

        ContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        InputStream inputstream = new FileInputStream(new File("/home/souro/Desktop/MindMajix/solr-8.9.0/example/exampledocs/solr-word.pdf"));
        ParseContext pcontext = new ParseContext();

        PDFParser pdfparser = new PDFParser();
        pdfparser.parse(inputstream, handler, metadata,pcontext);

        SolrInputDocument doc = new SolrInputDocument();

        doc.addField("id", "souro_pdf_doc2");
        String author = metadata.get("Author");
        if (author != null) {
            doc.addField("author", author);
        }
        doc.addField("text", handler.toString());
        Solr.add(doc);

        Solr.commit();
        System.out.println("Documents added");
    }
}
