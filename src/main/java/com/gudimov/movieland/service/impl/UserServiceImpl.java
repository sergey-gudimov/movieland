package com.gudimov.movieland.service.impl;

import com.gudimov.movieland.dao.UserDao;
import com.gudimov.movieland.entity.User;
import com.gudimov.movieland.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getUserById(int userId) {
        return null;
    }
}
