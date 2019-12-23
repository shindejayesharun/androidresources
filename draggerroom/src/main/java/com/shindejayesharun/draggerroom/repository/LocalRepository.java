package com.shindejayesharun.draggerroom.repository;

import com.shindejayesharun.draggerroom.local.UserEntity;

import java.util.List;

public interface LocalRepository {
    List<UserEntity> getAllUsers();
    void insertUser(UserEntity userEntity);
}
