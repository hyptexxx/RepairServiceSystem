package com.repairService.repairService.repository;

import com.repairService.repairService.mapper.RepairRequestMapper;
import com.repairService.repairService.model.RepairRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            repairRequests = jdbcTemplate.query("select rr.id as id, user_id,\n" +
                    "       status_id,\n" +
                    "       date,\n" +
                    "       s.description as status_description,\n" +
                    "       rr.description as request_description,\n" +
                    "       u.login as user_login\n" +
                    "from repair_requests rr\n" +
                    "         inner join status s on rr.status_id = s.id\n" +
                    "         inner join users u on rr.user_id = u.id\n", new RepairRequestMapper());
            return repairRequests;
        } catch (EmptyResultDataAccessException e) {
            return new ArrayList<>();
        }
    }

    public RepairRequest setNewStatus(RepairRequest newRequest) {
        try {
            jdbcTemplate.update(
                    "UPDATE repair_requests " +
                            "SET status_id = ? " +
                            "WHERE id = ?;",
                    newRequest.getStatusId(), newRequest.getId()
            );
            return jdbcTemplate.queryForObject(
                    "select rr.id as id, user_id,\n" +
                            "       status_id,\n" +
                            "       date,\n" +
                            "       s.description as status_description,\n" +
                            "       rr.description as request_description,\n" +
                            "       u.login as user_login\n" +
                            "from repair_requests rr\n" +
                            "         inner join status s on rr.status_id = s.id\n" +
                            "         inner join users u on rr.user_id = u.id\n" +
                            "where rr.id = ?",
                    new Object[]{newRequest.getId()},
                    new RepairRequestMapper()
            );
        } catch (DataAccessException e) {
            return null;
        }
    }

    public RepairRequest setNewRequest(RepairRequest newRequest) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        try {
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection
                        .prepareStatement("INSERT INTO repair_requests (user_id, description, date, status_id) " +
                                "VALUES (?, ?, ?, ?);", PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, String.valueOf(newRequest.getUserId()));
                ps.setString(2, newRequest.getDescription());
                ps.setDate(3, new java.sql.Date(newRequest.getDate().getTime()));
                ps.setString(4, String.valueOf(newRequest.getStatusId()));
                return ps;
            }, keyHolder);
            return jdbcTemplate.queryForObject(
                    "select rr.id as id, user_id,\n" +
                            "       status_id,\n" +
                            "       date,\n" +
                            "       s.description as status_description,\n" +
                            "       rr.description as request_description,\n" +
                            "       u.login as user_login\n" +
                            "from repair_requests rr\n" +
                            "         inner join status s on rr.status_id = s.id\n" +
                            "         inner join users u on rr.user_id = u.id\n" +
                            "where rr.id = ?",
                    new Object[]{keyHolder.getKey()},
                    new RepairRequestMapper()
            );
        } catch (DataAccessException e) {
            return null;
        }
    }

    public List<RepairRequest> getAllComplete() {
        List<RepairRequest> repairRequests;
        try {
            repairRequests = jdbcTemplate.query("select rr.id as id, user_id,\n" +
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
            repairRequests = jdbcTemplate.query("select rr.id as id, user_id,\n" +
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
