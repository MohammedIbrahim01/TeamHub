package com.abdelazim.x.teamhub.repository.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface LocalAccountDao {

    @Insert
    void insertLocalAccount(LocalAccount localAccount);

    @Query("SELECT * FROM `local-accounts`")
    List<LocalAccount> getAllLocalAccounts();

    @Query("SELECT * FROM `local-accounts` WHERE id = :id")
    LocalAccount getLocalAccountById(int id);

    @Delete
    void deleteLocalAccount(LocalAccount localAccount);

    @Query("SELECT * FROM `local-accounts` WHERE login = :accountName")
    LocalAccount getLocalAccountByAccountName(String accountName);

    @Query("DELETE FROM `local-accounts`")
    void deleteAll();
}
