package com.example.miral.projecte.MyDb;

public class Usuarios {
    private String user,nombre,Apellidos,correo;

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
    public Usuarios(String correo,String usuari, String nom, String cognom){
        this.correo = correo;
        this.user=usuari;
        this.nombre=nom;
        this.Apellidos=cognom;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
