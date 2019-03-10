package com.example.miral.projecte;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miral.projecte.MyDb.Usuari;
import com.example.miral.projecte.MyDb.UsuariViewModel;
import com.example.miral.projecte.fragments.idioma;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    Locale myLocale;
    private UsuariViewModel loginViewModel;
    private TextView lblEmail;
    private TextView lblPassword;
    public Usuari tempUsu = null;
    private AnimationDrawable anim;
    private List<Usuari> temp;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mAuth=FirebaseAuth.getInstance();
        lblEmail = findViewById(R.id.etUsuari);
        lblPassword = findViewById(R.id.etPass);
        progressBar = findViewById(R.id.pb);
        Animation();

      /*  loginViewModel = ViewModelProviders.of(MainActivity.this).get(UsuariViewModel.class);
        loginViewModel.getAllWords().observe(this, new Observer<List<Usuari>>() {
            @Override
            public void onChanged(@Nullable List<Usuari> tempUsu) {
                try{
                    temp = tempUsu;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }); */
    }


    public void onClick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        final String strEmail = lblEmail.getText().toString().trim();
        final String strPassword = lblPassword.getText().toString().trim();
        final boolean[] encontrado = {false};


        if(TextUtils.isEmpty(strEmail)){
            Toast.makeText(this,getString(R.string.eCorreo),Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.INVISIBLE);
        }else if(TextUtils.isEmpty(strPassword)){
            Toast.makeText(this,getString(R.string.econtra),Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.INVISIBLE);
        }else{

            mAuth.signInWithEmailAndPassword(strEmail,strPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressBar.setVisibility(View.INVISIBLE);
                    if(task.isSuccessful()){
                        Intent listSong = new Intent(getApplicationContext(), navegacion.class);
                        startActivity(listSong);
                    }else{
                        Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
            /*
            temp = loginViewModel.getAllWords().getValue();
                    for (int i = 0; i<temp.size();i++){

                        if(usu.getCorreu()==strEmail){
                            if(usu.getContrasenya()==strPassword){
                                Toast.makeText(MainActivity.this, "Contraseña y correo correctos.", Toast.LENGTH_SHORT).show();
                                tempUsu = usu;

                            }else{
                                Toast.makeText(MainActivity.this,"La contraseña no coincide",Toast.LENGTH_LONG).show();
                            }
                        }

                        Toast.makeText(MainActivity.this,(temp.get(i).getCorreu()+":"+temp.get(i).getContrasenya()+", "+strEmail+":"+strPassword), Toast.LENGTH_SHORT).show();
                        if(temp.get(i).getCorreu().equals(strEmail)){
                            encontrado[0] = true;
                            if(temp.get(i).getContrasenya().equals(strPassword)){
                              Toast.makeText(MainActivity.this, "Contraseña y correo correctos.", Toast.LENGTH_SHORT).show();
                                tempUsu = temp.get(i);

                            }else{
                                Toast.makeText(MainActivity.this,getString(R.string.noCoincide),Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    if (tempUsu==null && !encontrado[0]){
                        Toast.makeText(MainActivity.this,getString(R.string.errorCorreo), Toast.LENGTH_LONG).show();
                    }else{

                        Intent listSong = new Intent(getApplicationContext(), navegacion.class);
                        startActivity(listSong);

                    }*/
                }


        }
/*
        Intent listSong = new Intent(getApplicationContext(), navegacion.class);
        startActivity(listSong);*/


    public void onClickIdioma(View view) {
        Intent listSong = new Intent(getApplicationContext(), idiomaLog.class);
        startActivity(listSong);

    }
    public void onClickRegistre(View view){
        Intent listSong = new Intent(getApplicationContext(),Registre.class);
        startActivity(listSong);
    }

    @Override
    public void onResume(){
        super.onResume();
        tempUsu =null;
        loginViewModel = ViewModelProviders.of(MainActivity.this).get(UsuariViewModel.class);

    }

    private void Animation() {
        ImageView img = (ImageView)findViewById(R.id.simple_anim);
        anim = (AnimationDrawable)img.getDrawable();
        img.post(run);
    }
    Runnable run = new Runnable() {
        @Override
        public void run() {
            anim.start();
        }
    };
}