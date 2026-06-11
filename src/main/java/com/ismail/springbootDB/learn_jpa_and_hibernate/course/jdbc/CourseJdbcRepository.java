package com.ismail.springbootDB.learn_jpa_and_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private String sqlQuery =
        """
            insert into course(id, name, author)
            values (1, 'learn AWS', 'Ismail');
        """;

    public void insert(){
        springJdbcTemplate.update(sqlQuery);
    }
}
