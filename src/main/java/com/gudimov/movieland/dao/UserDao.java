package com.gudimov.movieland.dao;

import com.gudimov.movieland.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> getById(int userId);
}
