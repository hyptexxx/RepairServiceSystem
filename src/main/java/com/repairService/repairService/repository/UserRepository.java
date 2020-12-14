package com.repairService.repairService.repository;

import com.repairService.repairService.mapper.UserMapper;
import com.repairService.repairService.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findUser(String login, String password) {
        User user;
        try {
            user = jdbcTemplate.queryForObject("select login, role_name, users.id as id\n" +
                    "from users\n" +
                    "         inner join roles on users.role_id = roles.id\n" +
                    "where login like ?\n" +
                    "  and password like ?", new Object[]{login, password}, new UserMapper());
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
