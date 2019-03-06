package com.example.miral.projecte;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miral.projecte.MyDb.Usuari;
import com.example.miral.projecte.MyDb.UsuariViewModel;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registre extends AppCompatActivity {

    TextView usuario,email,pass1,pass2,nombre, apellidos;
    TextView eusuario, eemail, epass1, enombre, eapellidos;
    private UsuariViewModel loginViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        usuario = findViewById(R.id.eTextUsuario);
        email = findViewById(R.id.etxtMail);
        pass1 = findViewById(R.id.etxtPass);
        pass2 = findViewById(R.id.etxtPass2);
        nombre = findViewById(R.id.etxtNombre);
        apellidos = findViewById(R.id.etxtApellidos);
        //errores
        eusuario = findViewById(R.id.txtErrorUsu);
        eemail = findViewById(R.id.txtCorreoNoValido);
        epass1 = findViewById(R.id.txtErrorContraseña);
        enombre = findViewById(R.id.TxtnombreError);
        eapellidos = findViewById(R.id.txtApellidosError);
        //model
        loginViewModel = ViewModelProviders.of(Registre.this).get(UsuariViewModel.class);
    }
    public void onClickLog(View view){
        this.finish();
    }
    public void onClick(View view){
        Boolean temp = false;
        eusuario.setText("");
        eemail.setText("");
        epass1.setText("");
        enombre.setText("");
        eapellidos.setText("");


        String usu = usuario.getText().toString();
        if(compruebaUsu(usu)) temp = true;

        String ema = email.getText().toString().trim();
 //       if(compruebaemail(ema)) temp = true;

        String pass = pass1.getText().toString().trim();
        String passw2 = pass2.getText().toString().trim();
        if(compruebaContra(pass,passw2)) temp = true;

        String nom = nombre.getText().toString().trim();
        if(compruebaNom(nom)){
            temp = true;
            enombre.setVisibility(View.VISIBLE);
            enombre.setText("Nombre no valido");
        }
        String ape = apellidos.getText().toString().trim();
        if(compruebaNom(ape)){
            temp = true;
            eapellidos.setVisibility(View.VISIBLE);
            eapellidos.setText("Apellido/s no valido/s");
        }
        if(!temp) {
            Usuari usuari = new Usuari(usu, nom, ape, pass, ema);
            loginViewModel.insert(usuari);
            Toast.makeText(this,"Añadido correctamente",Toast.LENGTH_LONG).show();
            this.finish();
        }

//        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//        startActivity(intent);
    }
    public boolean compruebaemail(final String email){
        final boolean[] t = {false};
        if(!email.contains("@")){
            t[0] = true;
            eemail.setVisibility(View.VISIBLE);
            eemail.setText("Correo invalido");
        }

        if(!t[0]) {
            loginViewModel.getAllWords().observe(this, new Observer<List<Usuari>>() {
                @Override
                public void onChanged(@Nullable List<Usuari> usuaris) {
                    for (int i = 0; i < usuaris.size(); i++) {
                        if (email.equals(usuaris.get(i).getCorreu())) {
                            t[0] = true;
                            findViewById(R.id.txtErrorUsu).setVisibility(View.VISIBLE);
                        }

                    }
                }

            });
            if(t[0]){


                eemail.setVisibility(View.VISIBLE);
            eemail.setText("Correo en uso");
        }}
            return t[0];
    }
    public boolean compruebaUsu(String usu){
        if(usu.length()>=4){ return false;}
        else{
            eusuario.setVisibility(View.VISIBLE);
            eusuario.setText("El usuario es demasiado corto");
            return true;
        }
    }
    public boolean compruebaContra(String pass1, String pass2){
        if(pass1.length()>=8){
            if(pass1.equals(pass2)){
                return false;
            }
            else{
                epass1.setVisibility(View.VISIBLE);
                epass1.setText("Las contraseñas no coinciden");
                return true;
            }
        }else{
            epass1.setVisibility(View.VISIBLE);
            epass1.setText("Las contraseña es demasiado corta(minimo 8 caracteres)");
            return true;
        }
    }
    public boolean compruebaNom(String nom){
        Pattern find = Pattern.compile("/^([^0-9]*)$/");
        Matcher m = find.matcher(nom);
        return m.matches();

    }
}



