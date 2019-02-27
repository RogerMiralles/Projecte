package com.example.miral.projecte;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class UsuariViewModel extends AndroidViewModel {
    private UsuariRepository mRepository;

    private LiveData<List<Usuari>> mAllWords;

    public UsuariViewModel (Application application){
        super(application);
        mRepository = new UsuariRepository(application);
        mAllWords = mRepository.getAllUsuari();
    }

    LiveData<List<Usuari>> getAllWords(){ return mAllWords;}

    public void Insert(Usuari usuari) {mRepository.insert(usuari);}
}
