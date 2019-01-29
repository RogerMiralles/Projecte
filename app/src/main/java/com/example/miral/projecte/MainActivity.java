package com.example.miral.projecte;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }


    public void onClick(View view) {
        Intent listSong = new Intent(getApplicationContext(), rvi_lista_ejers.class);
        startActivity(listSong);
    }

    public void onClickIdioma(View view) {
        Intent listSong = new Intent(Settings.ACTION_LOCALE_SETTINGS);
        startActivity(listSong);

    }
    public void onClickRegistre(View view){
        Intent listSong = new Intent(getApplicationContext(),Registre.class);
        startActivity(listSong);
    }
}