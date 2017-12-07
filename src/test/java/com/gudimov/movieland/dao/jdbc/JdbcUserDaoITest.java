package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.dao.UserDao;
import com.gudimov.movieland.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-root-context.xml"})
public class JdbcUserDaoITest {

    @Autowired
    private UserDao jdbcUserDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private String getUserMaxIdSQL;

    @Autowired
    private String getUserByIdSQL;

    @Test
    public void getById() throws Exception {
        int userId = jdbcTemplate.queryForObject(getUserMaxIdSQL, Integer.class);
        User user = jdbcUserDao.getById(userId);
        assertNotNull(user);
    }

}