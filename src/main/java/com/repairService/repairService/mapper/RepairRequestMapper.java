package com.repairService.repairService.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.repairService.repairService.model.RepairRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class RepairRequestMapper implements RowMapper<RepairRequest> {
    @Override
    public RepairRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
        RepairRequest repairRequest =  new RepairRequest();
        repairRequest.setDescription(rs.getString("request_description"));
        repairRequest.setId(rs.getInt("id"));
        repairRequest.setDate(rs.getDate("date"));
        repairRequest.setUserId(rs.getInt("user_id"));
        repairRequest.setStatusId(rs.getInt("status_id"));
        repairRequest.setStatusDescription(rs.getString("status_description"));
        repairRequest.setUserLogin(rs.getString("user_login"));
        return repairRequest;
    }

    public static RepairRequest mapJSON(String employeeJSON) {
        final Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, (JsonDeserializer<Date>) (jsonElement, type, context)
                        -> new Date(jsonElement.getAsJsonPrimitive().getAsLong()))
                .create();
        return gson.fromJson(employeeJSON, RepairRequest.class);
    }
}
