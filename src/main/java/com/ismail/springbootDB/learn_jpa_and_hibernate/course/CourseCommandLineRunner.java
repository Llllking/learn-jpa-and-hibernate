package com.ismail.springbootDB.learn_jpa_and_hibernate.course;

import com.ismail.springbootDB.learn_jpa_and_hibernate.course.Course;
import com.ismail.springbootDB.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.ismail.springbootDB.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    //@Autowired
    //private CourseJdbcRepository courseJdbcRepository;

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {
        courseJpaRepository.insert(new Course(1, "Learn AWS", "Ismail"));
        courseJpaRepository.insert(new Course(2, "Learn AZURE", "Ismail"));
        courseJpaRepository.insert(new Course(3, "Learn DevOps", "Ismail"));
        courseJpaRepository.deleteById(2);
        System.out.println(courseJpaRepository.findById(1));
    }
}
