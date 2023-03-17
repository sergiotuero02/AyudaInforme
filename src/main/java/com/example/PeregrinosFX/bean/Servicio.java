package com.example.PeregrinosFX.bean;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Servicio{
    public static ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "peregrinos.db4o");
    private String nombre;
    private double precio;
    private ArrayList<Long> idParadas;

    public Servicio(){

    }

    public ArrayList<Long> getIdParadas() {
        return idParadas;
    }

    public void setIdParadas(ArrayList<Long> idParadas) {
        this.idParadas = idParadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return
               nombre + " " + precio +
                "€ ";
    }
}
