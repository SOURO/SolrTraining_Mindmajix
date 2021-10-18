package com.souro.springboot.controller;

import com.souro.springboot.model.Course;
import com.souro.springboot.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/hello")
    public String getMessage()
    {
        return "Hello Souro";
    }

    @RequestMapping("/getCourse")
    public Course getCourse()
    {
        Course course = courseService.getCourse();
        return course;

    }
}
