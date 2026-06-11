package com.ismail.springbootDB.learn_jpa_and_hibernate.course.jdbc;

import com.ismail.springbootDB.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private String INSERT_QUERY =
        """
            insert into course(id, name, author)
            values (?, ?, ?);
        """;

    private static String DELETE_QUERY =
            """
                delete from course where id = ?
            """;

    private static String SELECT_BY_ID_QUERY =
            """
                select * from course where id = ?
            """;

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void delete(long id){
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course selectById(long id){
        return springJdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

}
