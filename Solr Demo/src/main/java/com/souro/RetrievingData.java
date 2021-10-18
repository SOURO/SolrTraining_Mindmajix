package com.souro;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public class RetrievingData {
    public static void main(String args[]) throws SolrServerException, IOException  {
        String urlString = "http://localhost:8983/solr/souro_core2";
        SolrClient Solr = new HttpSolrClient.Builder(urlString).build();

        SolrQuery query = new SolrQuery();
        query.setQuery("*:*");

        query.addField("*");

        QueryResponse queryResponse = Solr.query(query);

        SolrDocumentList docs = queryResponse.getResults();
        System.out.println(docs);
        System.out.println(docs.get(0));
        System.out.println(docs.get(1));
        System.out.println(docs.get(2));

        Solr.commit();
    }
}
