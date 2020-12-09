package com.repairService.repairService.mapper;

import com.repairService.repairService.model.Status;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusMapper implements RowMapper<Status> {
    @Override
    public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
        Status status = new Status();
        status.setDescription(rs.getString("description"));
        status.setId(rs.getInt("id"));
        return status;
    }
}
