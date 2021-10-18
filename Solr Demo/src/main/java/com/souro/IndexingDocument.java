package com.souro;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

public class IndexingDocument {
    public static void main(String args[]) throws Exception {
        String urlString = "http://localhost:8983/solr/souro_core2";
        SolrClient Solr = new HttpSolrClient.Builder(urlString).build();

        SolrInputDocument doc = new SolrInputDocument();

        doc.addField("id", "004");
        doc.addField("first_name", "Souro4");
        doc.addField("last_name","Mukherjee4");
        doc.addField("phone_number","7123456894");
        doc.addField("location","India4");

        Solr.add(doc);

        Solr.commit();
        System.out.println("Documents added");
    }
}
