package com.gudimov.movieland.dao.jdbc.mapper;

import com.gudimov.movieland.entity.User;
import org.junit.Test;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserRowMapperTest {
    @Test
    public void mapRow() throws Exception {
        ResultSet resultSet = mock(ResultSet.class);

        User user1 = new User();
        user1.setId(1);
        user1.setNickName("Petya");

        User user2 = new User();
        user2.setId(2);
        user2.setNickName("Ivan");

        List<User> userList = Arrays.asList(user1, user2);

        when(resultSet.getInt("id")).thenReturn(user1.getId()).thenReturn(user2.getId());
        when(resultSet.getString("nickname")).thenReturn(user1.getNickName()).thenReturn(user2.getNickName());

        UserRowMapper userRowMapper = new UserRowMapper();
        for (int i = 0; i < 2; i++) {
            User actualUser = userRowMapper.mapRow(resultSet, i);
            User expectedUser = userList.get(i);
            assertEquals(expectedUser.getId(), actualUser.getId());
            assertEquals(expectedUser.getNickName(), actualUser.getNickName());
        }

    }

}