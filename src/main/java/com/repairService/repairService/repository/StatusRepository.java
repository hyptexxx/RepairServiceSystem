package com.repairService.repairService.repository;

import com.repairService.repairService.mapper.StatusMapper;
import com.repairService.repairService.model.Status;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatusRepository {
    private final JdbcTemplate jdbcTemplate;

    public StatusRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Status> getAllStatuses() {
        return jdbcTemplate.query("select * from status", new StatusMapper());
    }
}
