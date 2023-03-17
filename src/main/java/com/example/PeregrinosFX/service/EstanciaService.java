package com.example.PeregrinosFX.service;

import com.example.PeregrinosFX.bean.Estancia;
import com.example.PeregrinosFX.bean.Parada;
import com.example.PeregrinosFX.bean.Peregrino;
import com.example.PeregrinosFX.bean.User;
import com.example.PeregrinosFX.generic.GenericService;

import java.util.ArrayList;

public interface EstanciaService extends GenericService<Estancia> {
    public abstract Estancia addEstancia(Estancia estancia);

    ArrayList<Estancia> findByParada(Parada parada);
}
