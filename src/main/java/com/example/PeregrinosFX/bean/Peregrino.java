package com.example.PeregrinosFX.bean;



import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "peregrinos")
public class Peregrino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)

    private long idPeregrino;


    private String nombre;


    private String nacionalidad;


    @OneToOne
    @JoinColumn
    private Carnet carnet;


    @OneToMany(mappedBy = "peregrino", fetch = FetchType.EAGER)
    private List<Estancia> estancias;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name ="paradas")
    private List<Parada> paradas;
    public Peregrino() {

    }

    public long getIdPeregrino() {
        return idPeregrino;
    }

    public void setIdPeregrino(long idPeregrino) {
        this.idPeregrino = idPeregrino;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }


    public List<Estancia> getEstancias() {
        return estancias;
    }

    public void setEstancias(List<Estancia> estancias) {
        this.estancias = estancias;
    }

    public List<Parada> getParadas() {
        return paradas;
    }

    public void setParadas(List<Parada> paradas) {
        this.paradas = paradas;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
