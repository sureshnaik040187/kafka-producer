package com.snaik.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class QueryExecutor {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String query = "select * from ats_wismo_hdr where 1=1 and rownum between 1 and 10";

    public void executeQuery(){
        System.out.println("executing query: "+query);

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
        for (Map row:rows) {
            System.out.println("records: "+row.toString());
        }
    }
}
