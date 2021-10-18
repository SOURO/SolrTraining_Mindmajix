package com.souro.solrproject.repository;

import com.souro.solrproject.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.SimpleStringCriteria;

import javax.annotation.Resource;
import java.util.List;

public class CourseCustomRepositoryImpl implements CourseCustomRepository {
    @Resource
    private SolrTemplate solrTemplate;

    @Override
    public List<Course> findCourseByCustomSearch(String searchTerm, Pageable page) {
        SimpleQuery search = new SimpleQuery(new SimpleStringCriteria("name:" + searchTerm));

        search.addSort(Sort.by(Sort.Direction.DESC, "id"));
        search.setPageRequest(page);

        Page<Course> results = solrTemplate.queryForPage("souro_core", search, Course.class);
        return results.getContent();
    }
}
