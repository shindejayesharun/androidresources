package com.shindejayesharun.draggerroom.repository;

import com.shindejayesharun.draggerroom.local.UserDao;
import com.shindejayesharun.draggerroom.local.UserEntity;

import java.util.List;

import javax.inject.Inject;

public class LocalRepositoryImpl implements LocalRepository {

    @Inject
    UserDao userDao;

    public LocalRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userDao.getUserList();
    }

    @Override
    public void insertUser(UserEntity userEntity) {
        userDao.insertUser(userEntity);
    }
}
