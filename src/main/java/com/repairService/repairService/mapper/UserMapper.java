package com.repairService.repairService.mapper;

import com.repairService.repairService.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setLogin(rs.getString("login"));
        user.setRoleDescription(rs.getString("role_name"));
        return user;
    }
}
