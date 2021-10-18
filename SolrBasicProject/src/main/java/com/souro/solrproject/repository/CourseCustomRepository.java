package com.souro.solrproject.repository;

import com.souro.solrproject.model.Course;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseCustomRepository {
    public List<Course> findCourseByCustomSearch(String searchTerm, Pageable page);
}
