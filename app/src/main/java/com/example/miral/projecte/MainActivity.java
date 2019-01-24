package com.example.miral.projecte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button button = (Button) findViewById(R.id.btnLogin);
    }


    public void onClick(View view) {
        Intent listSong = new Intent(getApplicationContext(),rvi_lista_ejers.class);
        startActivity(listSong);
    }
}