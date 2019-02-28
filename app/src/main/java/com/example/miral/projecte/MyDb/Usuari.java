package com.example.miral.projecte.MyDb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "usuari_table")
public class Usuari {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "usu")
    private String usuari;

    @NonNull
    @ColumnInfo(name = "nom")
    private String nom;
    @NonNull
    @ColumnInfo(name = "cognoms")
    private String cognoms;
    @NonNull
    @ColumnInfo(name = "constrasenya")
    private String contrasenya;
    @NonNull
    @ColumnInfo(name = "correu")
    private String correu;
    public Usuari(String usuari,String nom,String cognoms,String contrasenya,String correu){
        this.usuari = usuari;
        this.nom = nom;
        this.cognoms = cognoms;
        this.contrasenya = contrasenya;
        this.correu = correu;
    }
    public Usuari(){}





    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }


}
