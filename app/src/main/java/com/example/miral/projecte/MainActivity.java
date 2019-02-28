package com.example.miral.projecte;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miral.projecte.MyDb.Usuari;
import com.example.miral.projecte.MyDb.UsuariViewModel;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Locale myLocale;
    private UsuariViewModel loginViewModel;
    private TextView lblEmail;
    private TextView lblPassword;
    public Usuari temp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        lblEmail = findViewById(R.id.etUsuari);
        lblPassword = findViewById(R.id.etPass);

        loginViewModel = ViewModelProviders.of(MainActivity.this).get(UsuariViewModel.class);
/*        loginViewModel.getAllWords().observe(this, new Observer<List<Usuari>>() {
            @Override
            public void onChanged(@Nullable List<Usuari> usuaris) {
                try{

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }); */
    }


    public void onClick(View view) {
        final String strEmail = lblEmail.getText().toString().trim();
        final String strPassword = lblPassword.getText().toString().trim();
        final boolean[] encontrado = {false};


        if(TextUtils.isEmpty(strEmail)){
            Toast.makeText(this,"Introduce un correo.",Toast.LENGTH_LONG).show();
        }else if(TextUtils.isEmpty(strPassword)){
            Toast.makeText(this,"Introduce una contraseña.",Toast.LENGTH_LONG).show();
        }else{
            loginViewModel.getAllWords().observe(this, new Observer<List<Usuari>>() {
                @Override
                public void onChanged(@Nullable List<Usuari> usuaris) {
                    for (int i = 0; i<usuaris.size();i++){
                        /*
                        if(usu.getCorreu()==strEmail){
                            if(usu.getContrasenya()==strPassword){
                                Toast.makeText(MainActivity.this, "Contraseña y correo correctos.", Toast.LENGTH_SHORT).show();
                                temp = usu;

                            }else{
                                Toast.makeText(MainActivity.this,"La contraseña no coincide",Toast.LENGTH_LONG).show();
                            }
                        }
                        */
                        Toast.makeText(MainActivity.this,(usuaris.get(i).getCorreu()+":"+usuaris.get(i).getContrasenya()+", "+strEmail+":"+strPassword), Toast.LENGTH_SHORT).show();
                        if(usuaris.get(i).getCorreu().equals(strEmail)){
                            encontrado[0] = true;
                            if(usuaris.get(i).getContrasenya().equals(strPassword)){
//                                Toast.makeText(MainActivity.this, "Contraseña y correo correctos.", Toast.LENGTH_SHORT).show();
                                temp = usuaris.get(i);

                            }else{
                                Toast.makeText(MainActivity.this,"La contraseña no coincide",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    if (temp==null && !encontrado[0]){
                        Toast.makeText(MainActivity.this,"correo no encontrado", Toast.LENGTH_LONG).show();
                    }else{

                        Intent listSong = new Intent(getApplicationContext(), navegacion.class);
                        startActivity(listSong);

                    }
                }
            });

        }
/*
        Intent listSong = new Intent(getApplicationContext(), navegacion.class);
        startActivity(listSong);*/
    }

    public void onClickIdioma(View view) {
        Intent listSong = new Intent(Settings.ACTION_LOCALE_SETTINGS);
        startActivity(listSong);

    }
    public void onClickRegistre(View view){
        Intent listSong = new Intent(getApplicationContext(),Registre.class);
        startActivity(listSong);
    }

    @Override
    public void onResume(){
        super.onResume();
        temp =null;
        loginViewModel = ViewModelProviders.of(MainActivity.this).get(UsuariViewModel.class);
    }
}