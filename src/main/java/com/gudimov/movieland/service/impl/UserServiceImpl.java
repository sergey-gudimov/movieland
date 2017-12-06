package com.gudimov.movieland.service.impl;

import com.gudimov.movieland.dao.UserDao;
import com.gudimov.movieland.entity.User;
import com.gudimov.movieland.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(int userId) {
        return userDao.getById(userId);
    }
}
