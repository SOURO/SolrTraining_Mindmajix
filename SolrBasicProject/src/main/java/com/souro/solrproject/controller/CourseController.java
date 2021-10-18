package com.souro.solrproject.controller;

import com.souro.solrproject.model.Course;
import com.souro.solrproject.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("/addandindex")
    public String addCourse(@RequestBody Course course) {
        String message = courseService.addAndIndexcourse(course);
        return message;
    }

    @PutMapping("/updateindex")
    public String updateCourse(@RequestBody Course course) {
        String message = courseService.addAndIndexcourse(course);
        return message;
    }

    @GetMapping("/getbyid/{id}")
    public Course getCourseById(@PathVariable long id) {
        Course course =  courseService.getCourseById(id);
        return course;
    }

    @GetMapping("/getbyname/{name}")
    public List<Course> getCourseByName(@PathVariable String name) {
        List<Course> courses =  courseService.getCourseByName(name);
        return courses;
    }

    @GetMapping("/search/{searchterm}")
    public List<Course> searchCourseBySearchTerm(@PathVariable String searchterm){
        List<Course> courses = courseService.searchCourseBySearchTerm(searchterm);
        return courses;
    }

    @GetMapping("/facet/{searchterm}")
    public int getFacet(@PathVariable String searchterm){
        int count = courseService.getMatchCounts(searchterm);
        return count;
    }

    @GetMapping("/highlights/{searchterm}")
    public List<String> highlightsSearch(@PathVariable String searchterm){
        List<String> snippets = courseService.highlights(searchterm);
        return snippets;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCourseById(@PathVariable long id) {
        String message =  courseService.deleteCourse(id);
        return message;
    }
}
