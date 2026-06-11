package com.ismail.springbootDB.learn_jpa_and_hibernate.course.jdbc;

import com.ismail.springbootDB.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository courseJdbcRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepository.insert(new Course(1, "Learn AWS", "Ismail"));
        courseJdbcRepository.insert(new Course(2, "Learn AZURE", "Ismail"));
        courseJdbcRepository.insert(new Course(3, "Learn DevOps", "Ismail"));
        courseJdbcRepository.delete(2);
        System.out.println(courseJdbcRepository.selectById(1));
    }
}
