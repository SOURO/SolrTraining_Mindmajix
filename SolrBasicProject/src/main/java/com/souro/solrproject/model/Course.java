package com.souro.solrproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.Score;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "souro_core")
public class Course {
    @Id
    @Indexed(name="id", type="string")
    private String id;

    @Indexed(name="name", type="string")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Score
    private float score;
}
