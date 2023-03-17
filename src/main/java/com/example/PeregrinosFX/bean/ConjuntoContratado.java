package com.example.PeregrinosFX.bean;

import java.util.ArrayList;

public class ConjuntoContratado {

    private double precioTotal;
    private char modoPago;
    private String extra = null;
    private ArrayList<Servicio> servicios;
    private Estancia estancia;

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Estancia getEstancia() {
        return estancia;
    }

    public void setEstancia(Estancia estancia) {
        this.estancia = estancia;
    }

    public double getPrecio() {
        return precioTotal;
    }

    public void setPrecio(double precio) {
        this.precioTotal = precio;
    }

    public char getModoPago() {
        return modoPago;
    }

    public void setModoPago(char modoPago) {
        this.modoPago = modoPago;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return servicios.toString() + "\n" + "Extras: " + extra + "\n" + "Modo de pago: " + modoPago + "\n" + "Total: " + precioTotal + "€";
    }
}
