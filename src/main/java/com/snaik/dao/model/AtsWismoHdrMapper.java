package com.snaik.dao.model;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AtsWismoHdrMapper implements RowMapper<AtsWismoHdr> {
    public AtsWismoHdr mapRow(ResultSet rs, int rowNum) throws SQLException {
        AtsWismoHdr atsWismoHdr = new AtsWismoHdr();
        atsWismoHdr.setAID(rs.getString("AID"));
       return atsWismoHdr;
    }
}
