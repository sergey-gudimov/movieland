package com.gudimov.movieland.service;

import com.gudimov.movieland.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUserById(int userId);
}
