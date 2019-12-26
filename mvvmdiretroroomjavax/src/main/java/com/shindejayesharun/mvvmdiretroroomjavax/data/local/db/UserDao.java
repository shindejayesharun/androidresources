package com.shindejayesharun.mvvmdiretroroomjavax.data.local.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {
    @Insert(onConflict = REPLACE)
    void insert(User user);

    @Query("Select * from user")
    List<User> usersList();


    @Delete
    void deleteUser(User user);

}
