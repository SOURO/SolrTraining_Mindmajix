package com.souro.solrproject.services.impl;

import com.souro.solrproject.model.Course;
import com.souro.solrproject.repository.CourseRepository;
import com.souro.solrproject.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.solr.core.query.result.FacetPage;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Override
    public String addAndIndexcourse(Course course) {
        if(course == null) {
            course = new Course();
            course.setId("3");
            course.setName("Apache Solr");
        }
        courseRepository.save(course);
        return "Course Added and Indexed";
    }

    @Override
    public Course getCourseById(long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> getCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    @Override
    public List<Course> searchCourseBySearchTerm(String searchterm){
        return courseRepository.findByCustomQuery(searchterm, PageRequest.of(0, 10)).getContent();
    }

    @Override
    public int getMatchCounts(String searchterm){
        FacetPage<Course> courseFacet = courseRepository.findByNameAndFacetOnCategories(searchterm, PageRequest.of(0, 10));
        return courseFacet.getNumberOfElements();
    }

    @Override
    public List<String> highlights(String searchterm){
        List<String> snippets = new ArrayList<String>();
        HighlightPage<Course> courseHighlightPage = courseRepository.findByName(searchterm, PageRequest.of(0, 10));
        courseHighlightPage.getContent();
        for (HighlightEntry<Course> highl : courseHighlightPage.getHighlighted()) {
            for (HighlightEntry.Highlight highlight : highl.getHighlights()){
                for (String snippet : highlight.getSnipplets()){
                    snippets.add(snippet);
                }
            }

        }
        return snippets;
    }

    @Override
    public String deleteCourse(long id) {
        courseRepository.delete(courseRepository.findById(id));
        return "Course Deleted";
    }
}
