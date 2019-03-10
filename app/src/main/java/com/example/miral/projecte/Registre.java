package com.example.miral.projecte;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miral.projecte.MyDb.Usuari;
import com.example.miral.projecte.MyDb.UsuariViewModel;
import com.example.miral.projecte.MyDb.Usuarios;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registre extends AppCompatActivity {

    TextView usuario,email,pass1,pass2,nombre, apellidos;
    TextView eusuario, eemail, epass1, enombre, eapellidos;
   // private UsuariViewModel loginViewModel;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();
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
        progressBar = findViewById(R.id.pb);
        //model
        //loginViewModel = ViewModelProviders.of(Registre.this).get(UsuariViewModel.class);
         db = FirebaseFirestore.getInstance();
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
        progressBar.setVisibility(View.VISIBLE);

        final String usu = usuario.getText().toString();
        if(compruebaUsu(usu)) temp = true;

        final String ema = email.getText().toString().trim();
        if(compruebaemail(ema)) temp = true;

        String pass = pass1.getText().toString().trim();
        String passw2 = pass2.getText().toString().trim();
        if(compruebaContra(pass,passw2)) temp = true;

        final String nom = nombre.getText().toString().trim();
        if(compruebaNom(nom)){
            temp = true;
            enombre.setVisibility(View.VISIBLE);
            enombre.setText(getString(R.string.NnoValido));
        }
        final String ape = apellidos.getText().toString().trim();
        if(compruebaNom(ape)){
            temp = true;
            eapellidos.setVisibility(View.VISIBLE);
            eapellidos.setText(getString(R.string.errorApellidos));
        }
        if(!temp) {

            firebaseAuth.createUserWithEmailAndPassword(ema,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    progressBar.setVisibility(View.INVISIBLE);
                    if(task.isSuccessful()){
                        CollectionReference dbUsers = db.collection("Users");

                        Usuarios usuario = new Usuarios(ema,usu,nom,ape);
                        dbUsers.add(usuario).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(Registre.this,getString(R.string.Success),Toast.LENGTH_LONG).show();
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                            Toast.makeText(Registre.this,"Error.",Toast.LENGTH_LONG).show();
                            }
                        });
                        /*mDatabase.child("users").setValue(usuario).
                        addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {

                                if(task.isSuccessful()){
                                    Toast.makeText(Registre.this,getString(R.string.Success),Toast.LENGTH_LONG).show();
                                    finish();
                                }else{
                                    Toast.makeText(Registre.this, "Error.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });*/

                    }else {
                        try{
                          throw task.getException();
                        }catch (FirebaseAuthUserCollisionException e){
                            Toast.makeText(Registre.this,e.getMessage(),Toast.LENGTH_LONG).show();
                        }catch (FirebaseAuthWeakPasswordException e){
                            Toast.makeText(Registre.this,getString(R.string.econtra),Toast.LENGTH_LONG).show();
                        }catch (Exception e){
                            Toast.makeText(Registre.this, "Error.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });



            /*
            Usuari usuari = new Usuari(usu, nom, ape, pass, ema);
            loginViewModel.insert(usuari);

            this.finish();
            */
        }
        else{
            progressBar.setVisibility(View.INVISIBLE);
        }

//        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//        startActivity(intent);
    }
    public boolean compruebaemail(final String email){
        final boolean[] t = {false};
        if(!email.contains("@")){
            t[0] = true;
            eemail.setVisibility(View.VISIBLE);
            eemail.setText(getString(R.string.ErrorCorreo));
        }

        if(!t[0]) {
            /*
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

            });*/
            if(t[0]){


                eemail.setVisibility(View.VISIBLE);
            eemail.setText(getString(R.string.CorreuUsado));
        }}
            return t[0];
    }
    public boolean compruebaUsu(String usu){
        if(usu.length()>=4){ return false;}
        else{
            eusuario.setVisibility(View.VISIBLE);
            eusuario.setText(getString(R.string.ErrorUsuaRegistro));
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
                epass1.setText(getString(R.string.ContrasenyasDistintas));
                return true;
            }
        }else{
            epass1.setVisibility(View.VISIBLE);
            epass1.setText(getString(R.string.ContrasenyaCorta));
            return true;
        }
    }
    public boolean compruebaNom(String nom){
        Pattern find = Pattern.compile("/^([^0-9]*)$/");
        Matcher m = find.matcher(nom);
        return m.matches();

    }
}



