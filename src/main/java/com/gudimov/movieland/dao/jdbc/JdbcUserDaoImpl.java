package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.dao.UserDao;
import com.gudimov.movieland.dao.jdbc.mapper.UserRowMapper;
import com.gudimov.movieland.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcUserDaoImpl implements UserDao {
    private final static UserRowMapper USER_ROW_MAPPER = new UserRowMapper();
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getUserByIdSQL;

    @Override
    public List<User> getById(int userId) {
        return jdbcTemplate.query(getUserByIdSQL, USER_ROW_MAPPER, userId);
    }
}
