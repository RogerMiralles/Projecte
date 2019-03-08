package com.example.miral.projecte.MyDb;

public class Usuarios {
    private String user,nombre,Apellidos;

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String cognom) {
        this.Apellidos = cognom;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String usuari) {
        this.user = usuari;
    }
    public Usuarios(String usuari, String nom, String cognom){
        this.user=usuari;
        this.nombre=nom;
        this.Apellidos=cognom;
    }
}
