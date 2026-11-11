package com.app.logica;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Gato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String nombre;

    private int edad;
    private String raza;
    private String sexo;
    private double peso;

    @ManyToOne
    private Adoptante adoptante;

    public Gato() {
    }

    public Gato(String nombre, int edad, String raza, String sexo, double peso, Adoptante adoptante) {
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.sexo = sexo;
        this.peso = peso;
        this.adoptante = adoptante;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Adoptante getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Adoptante adoptante) {
        this.adoptante = adoptante;
    }
    @Override
    public String toString() {
        return "GATO: \n" +
                "ID: " + getId() +
                "\nNombre: " + getNombre() +
                "\nEdad: " + getEdad() +
                "\nRaza: " + getRaza() +
                "\nSexo: " + getSexo() +
                "\nPeso: " + getPeso() + " kg";
    }
}