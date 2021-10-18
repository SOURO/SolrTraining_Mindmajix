package com.souro;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.common.SolrInputDocument;

public class DeleteDocuments {
    public static void main(String args[]) throws SolrServerException, IOException {
        String urlString = "http://localhost:8983/solr/souro_core2";
        SolrClient Solr = new HttpSolrClient.Builder(urlString).build();

        SolrInputDocument doc = new SolrInputDocument();

        Solr.deleteByQuery("*");

        Solr.commit();
        System.out.println("Documents deleted");
    }
}
