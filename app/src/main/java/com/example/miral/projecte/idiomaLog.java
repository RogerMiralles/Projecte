package com.example.miral.projecte;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.miral.projecte.fragments.idioma;

public class idiomaLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idioma_log);
        CargarFragmente(new idioma());
    }
    private void CargarFragmente(Fragment fragment){
        FragmentManager manager=getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.contendedorFragmentoI,fragment).commit();
    }
}
