package com.snaik.dao;

import com.snaik.dao.model.AtsWismoHdr;
import com.snaik.dao.model.AtsWismoHdrMapper;
import com.snaik.service.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class QueryExecutor {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private KafkaSender kafkaSender;

    private String query = "select * from ats_wismo_hdr where 1=1 and rownum between 1 and 10";

    public void executeQuery(){
        System.out.println("executing query: "+query);

        List<AtsWismoHdr> rows = jdbcTemplate.query(query, new AtsWismoHdrMapper());
        for (AtsWismoHdr row:rows) {
            System.out.println("records: "+row.toString());
            kafkaSender.send(row.toString());
        }
    }
}
