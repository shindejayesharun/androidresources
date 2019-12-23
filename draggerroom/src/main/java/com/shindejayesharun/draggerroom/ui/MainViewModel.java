package com.shindejayesharun.draggerroom.ui;

import androidx.lifecycle.ViewModel;

import com.shindejayesharun.draggerroom.local.UserEntity;
import com.shindejayesharun.draggerroom.repository.LocalRepository;
import com.shindejayesharun.draggerroom.repository.LocalRepositoryImpl;

import java.util.List;

public class MainViewModel extends ViewModel {
    private LocalRepository localReposiroty;

    public MainViewModel(LocalRepository localReposiroty) {
        this.localReposiroty = localReposiroty;
    }


    public List<UserEntity> getAllUsers(){
        return localReposiroty.getAllUsers();
    }

    public void insertUser(UserEntity userEntity){
        localReposiroty.insertUser(userEntity);
    }

}
