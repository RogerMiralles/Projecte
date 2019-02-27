package com.example.miral.projecte;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class UsuariRepository {

    private UsuariDao mUsuariDao;
    private LiveData<List<Usuari>> mAllUsuari;

    UsuariRepository(Application application){
        UsuariRoomDatabase db = UsuariRoomDatabase.getDatabase(application);
        mUsuariDao = db.usuariDao();
        mAllUsuari = mUsuariDao.getAllWords();
    }
    LiveData<List<Usuari>> getAllUsuari(){
        return mAllUsuari;
    }

    public void insert (Usuari usuari){
        new insertAsyncTask(mUsuariDao).execute(usuari);
    }

    private static class insertAsyncTask extends AsyncTask<Usuari,Void,Void>{
        private UsuariDao mAsyncTaskDao;

        insertAsyncTask(UsuariDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Usuari... params){
            mAsyncTaskDao.insert(params[0]);
            return null;
        }

    }

}
