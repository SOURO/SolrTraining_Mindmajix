package com.souro.springboot.service.impl;

import com.souro.springboot.model.Course;
import com.souro.springboot.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl  implements CourseService {
    @Override
    public Course getCourse() {
        Course course = new Course(5,"Apache Solr");
        return course;
    }
}
