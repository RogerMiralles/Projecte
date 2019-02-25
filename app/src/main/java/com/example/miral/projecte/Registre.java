package com.example.miral.projecte;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Registre extends AppCompatActivity {

    TextView usuario,email,pass1,pass2,nombre, apellidos;
    TextView eusuario, eemail, epass1, enombre, eapellidos;

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
        //errores
        eusuario = findViewById(R.id.txtErrorUsu);
        eemail = findViewById(R.id.txtCorreoNoValido);
        epass1 = findViewById(R.id.txtErrorContraseña);
        enombre = findViewById(R.id.TxtnombreError);
        eapellidos = findViewById(R.id.txtApellidosError);

    }
    public void onClickLog(View view){
        this.finish();
    }
    public void onClick(View view){
        Boolean temp = true;
        String usuarioRegistro;

        eusuario.setVisibility(View.VISIBLE);
        eusuario.setText("Nombre ya en uso.");
        eemail.setVisibility(View.VISIBLE);
        eemail.setText("Correo en uso");
        epass1.setVisibility(View.VISIBLE);
        epass1.setText("Las contraseñas no coinciden");
        enombre.setVisibility(View.VISIBLE);
        enombre.setText("El nombre no puede contener numeros");
        eapellidos.setVisibility(View.VISIBLE);
        eapellidos.setText("los apellidos no pueden contener numeros");



//        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//        startActivity(intent);
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
