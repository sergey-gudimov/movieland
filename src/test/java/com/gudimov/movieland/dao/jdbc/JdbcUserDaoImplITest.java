package com.gudimov.movieland.dao.jdbc;

import com.gudimov.movieland.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/root-context.xml"})
public class JdbcUserDaoImplITest {

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
        List user = jdbcUserDao.getById(userId);
        assertNotEquals(user.size(), 0);
    }

}