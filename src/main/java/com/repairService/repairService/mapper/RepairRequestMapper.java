package com.repairService.repairService.mapper;

import com.repairService.repairService.model.RepairRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairRequestMapper implements RowMapper<RepairRequest> {
    @Override
    public RepairRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
        RepairRequest repairRequest =  new RepairRequest();
        repairRequest.setDescription(rs.getString("request_description"));
        repairRequest.setDate(rs.getDate("date"));
        repairRequest.setUserId(rs.getInt("user_id"));
        repairRequest.setStatusId(rs.getInt("status_id"));
        repairRequest.setStatusDescription(rs.getString("status_description"));
        repairRequest.setUserLogin(rs.getString("user_login"));
        return repairRequest;
    }
}
