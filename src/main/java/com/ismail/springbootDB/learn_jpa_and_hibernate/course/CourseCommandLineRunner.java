package com.ismail.springbootDB.learn_jpa_and_hibernate.course;

import com.ismail.springbootDB.learn_jpa_and_hibernate.course.Course;
import com.ismail.springbootDB.learn_jpa_and_hibernate.course.jdbc.CourseJdbcRepository;
import com.ismail.springbootDB.learn_jpa_and_hibernate.course.jpa.CourseJpaRepository;
import com.ismail.springbootDB.learn_jpa_and_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    //@Autowired
    //private CourseJdbcRepository courseJdbcRepository;

    //@Autowired
    //private CourseJpaRepository courseJpaRepository;

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1, "Learn AWS", "Ismail"));
        repository.save(new Course(2, "Learn AZURE", "Ismail"));
        repository.save(new Course(3, "Learn DevOps", "Ismail"));
        repository.deleteById(2L);
        System.out.println(repository.findById(1L));
        System.out.println(repository.findByName("Learn AZURE"));
    }
}
