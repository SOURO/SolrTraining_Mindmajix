package com.souro.solrproject.services;

import com.souro.solrproject.model.Course;
import org.springframework.data.solr.core.query.result.HighlightPage;

import java.util.List;

public interface CourseService {
    String addAndIndexcourse(Course course);
    Course getCourseById(long id);
    List<Course> getCourseByName(String name);
    String deleteCourse(long id);
    List<Course> searchCourseBySearchTerm(String searchterm);
    int getMatchCounts(String searchterm);
    List<String> highlights(String searchterm);
}
