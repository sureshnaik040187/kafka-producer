package com.snaik.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QueryExecutor {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String query = "select * from dummy";

    public void executeQuery(String query){
        jdbcTemplate.execute(query);
    }
}
