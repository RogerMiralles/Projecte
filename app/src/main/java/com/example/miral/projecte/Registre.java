package com.example.miral.projecte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Registre extends AppCompatActivity {

    TextView usuario,email,pass1,pass2,nombre, apellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        usuario = findViewById(R.id.eTextUsuario);
        email = findViewById(R.id.etxtMail);
        pass1 = findViewById(R.id.etPass);
        pass2 = findViewById(R.id.etxtPass2);
        nombre = findViewById(R.id.etxtNombre);
        apellidos = findViewById(R.id.etxtApellidos);
    }
    public void onClick(View view){
        Boolean temp = true;
        String usuarioRegistro = (String) usuario.getText();
        



        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public boolean compruebanom(){
                /*
        for (int i = 0; i < usuarios; i++) {
            if(usuario ==usuario.getUsuari()){
                return true
                findViewById(R.id.txtErrorUsu).setVisibility(View.VISIBLE);
            }*/
                return false;
    }
}
