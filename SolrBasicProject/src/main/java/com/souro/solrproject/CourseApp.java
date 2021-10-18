package com.souro.solrproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class CourseApp {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CourseApp.class, args);
    }
}
