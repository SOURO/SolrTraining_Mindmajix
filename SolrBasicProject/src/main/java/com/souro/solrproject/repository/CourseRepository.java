package com.souro.solrproject.repository;

import com.souro.solrproject.model.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.*;

import java.util.List;

public interface CourseRepository extends SolrCrudRepository<Course, String> {
    public Course findById(long id);
    public List<Course> findByName(String name);

    @Query("id:*?0* OR name:*?0*")
    public Page<Course> findByCustomQuery(@Boost(2) String searchTerm, Pageable pageable);

    @Query("name:?0")
    @Facet(fields = { "name" }, limit = 5)
    FacetPage<Course> findByNameAndFacetOnCategories(String name, Pageable page);

    @Highlight(prefix = "<highlight>", postfix = "</highlight>")
    HighlightPage<Course> findByName(String name, Pageable pageable);
}
