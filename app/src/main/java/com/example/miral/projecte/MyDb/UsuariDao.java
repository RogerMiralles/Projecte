package com.example.miral.projecte.MyDb;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UsuariDao {

    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insert(Usuari usuari);

    @Query("DELETE FROM usuari_table")
    void deleteAll();

    @Query("SELECT * FROM usuari_table ORDER BY usu ASC")
    LiveData<List<Usuari>> getAllWords();

    @Query("DELETE FROM usuari_table")
    void deleteAllData();
}
