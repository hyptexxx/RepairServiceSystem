package com.repairService.repairService.repository;

import com.repairService.repairService.mapper.RepairRequestMapper;
import com.repairService.repairService.model.RepairRequest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepairRequestRepository {
    private final JdbcTemplate jdbcTemplate;

    public RepairRequestRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<RepairRequest> getAllRepairRequests() {

        List<RepairRequest> repairRequests;
        try {
            repairRequests = jdbcTemplate.query("select user_id,\n" +
                    "       status_id,\n" +
                    "       date,\n" +
                    "       s.description as status_description,\n" +
                    "       rr.description as request_description,\n" +
                    "       u.login as user_login\n" +
                    "from repair_requests rr\n" +
                    "         inner join status s on rr.status_id = s.id\n" +
                    "         inner join users u on rr.user_id = u.id\n" +
                    "where status_id = 1", new RepairRequestMapper());
            return repairRequests;
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }


    }

    public List<RepairRequest> getAllComplete() {
        List<RepairRequest> repairRequests;
        try {
            repairRequests = jdbcTemplate.query("select user_id,\n" +
                    "       status_id,\n" +
                    "       date,\n" +
                    "       s.description as status_description,\n" +
                    "       rr.description as request_description,\n" +
                    "       u.login as user_login\n" +
                    "from repair_requests rr\n" +
                    "         inner join status s on rr.status_id = s.id\n" +
                    "         inner join users u on rr.user_id = u.id\n" +
                    "where status_id = 3", new RepairRequestMapper());
            return repairRequests;
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }


    }

    public List<RepairRequest> getAllInWork() {
        List<RepairRequest> repairRequests;
        try {
            repairRequests = jdbcTemplate.query("select user_id,\n" +
                    "       status_id,\n" +
                    "       date,\n" +
                    "       s.description as status_description,\n" +
                    "       rr.description as request_description,\n" +
                    "       u.login as user_login\n" +
                    "from repair_requests rr\n" +
                    "         inner join status s on rr.status_id = s.id\n" +
                    "         inner join users u on rr.user_id = u.id\n" +
                    "where status_id = 2", new RepairRequestMapper());
            return repairRequests;
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }


    }
}
