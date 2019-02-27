package com.example.miral.projecte;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.List;

@Database(entities = {Usuari.class}, version = 1,exportSchema = false)
public abstract class UsuariRoomDatabase extends RoomDatabase {

    public abstract UsuariDao usuariDao();

    private static UsuariRoomDatabase INSTANCE;

    public static UsuariRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (UsuariRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),UsuariRoomDatabase.class,"usuari_database")
                    .fallbackToDestructiveMigration()
                    .build();

                }
            }
        }
        return INSTANCE;
    }

}
