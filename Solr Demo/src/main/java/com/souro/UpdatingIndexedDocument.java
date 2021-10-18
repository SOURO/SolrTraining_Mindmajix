package com.souro;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

public class UpdatingIndexedDocument {
    public static void main(String args[]) throws SolrServerException, IOException {
        String urlString = "http://localhost:8983/solr/souro_core2";
        SolrClient Solr = new HttpSolrClient.Builder(urlString).build();

        SolrInputDocument doc = new SolrInputDocument();

        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.setAction( UpdateRequest.ACTION.COMMIT, false, false);
        SolrInputDocument myDocumentInstantlycommited = new SolrInputDocument();

        myDocumentInstantlycommited.addField("id", "004");
        myDocumentInstantlycommited.addField("first_name", "Souro41");
        myDocumentInstantlycommited.addField("last_name","Mukherjee41");
        myDocumentInstantlycommited.addField("phone_number","9123456741");
        myDocumentInstantlycommited.addField("location","India41");

        updateRequest.add( myDocumentInstantlycommited);
        UpdateResponse rsp = updateRequest.process(Solr);
        System.out.println("Documents Updated");
    }
}
