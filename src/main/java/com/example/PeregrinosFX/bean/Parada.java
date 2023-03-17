package com.example.PeregrinosFX.bean;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "paradas")
public class Parada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long idParada;

    private String nombre;


    private char region;

    @ManyToMany(mappedBy = "paradas", fetch = FetchType.EAGER)
    private List<Peregrino> peregrinos;
    public Parada() {

    }

    public Long getIdParada() {
        return idParada;
    }

    public void setIdParada(long idParada) {
        this.idParada = idParada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getRegion() {
        return region;
    }

    public void setRegion(char region) {
        this.region = region;
    }

    public List<Peregrino> getPeregrinos() {
        return peregrinos;
    }

    public void setPeregrinos(List<Peregrino> peregrinos) {
        this.peregrinos = peregrinos;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
