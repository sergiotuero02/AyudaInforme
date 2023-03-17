package com.example.PeregrinosFX.bean;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class EnvioACasa {
    @Id
    @GeneratedValue
    public long idEnvio;

    public double peso;

    public double[] volumen;

    public boolean urgente = false;
    @OneToOne(cascade = CascadeType.PERSIST)
    public Direccion direccion;

    public long idParada;

    public long getIdParada() {
        return idParada;
    }

    public void setIdParada(long idParada) {
        this.idParada = idParada;
    }

    public long getId() {
        return idEnvio;
    }

    public void setId(long idEnvio) {
        this.idEnvio = idEnvio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double[] getVolumen() {
        return volumen;
    }

    public void setVolumen(double[] volumen) {
        this.volumen = volumen;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    @Override
    public String toString() {
        return "EnvioACasa{" +
                "id=" + idEnvio +
                ", peso=" + peso +
                ", volumen=" + Arrays.toString(volumen) +
                ", urgente=" + urgente +
                ", direccion=" + direccion +
                '}';
    }
}
