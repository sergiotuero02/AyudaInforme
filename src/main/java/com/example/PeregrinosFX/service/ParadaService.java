package com.example.PeregrinosFX.service;

import com.example.PeregrinosFX.bean.Parada;
import com.example.PeregrinosFX.bean.Peregrino;
import com.example.PeregrinosFX.bean.User;
import com.example.PeregrinosFX.generic.GenericService;

import java.util.Optional;

public interface ParadaService extends GenericService<Parada> {
    public abstract Parada addParada(Parada parada);
    Parada findByIdParada(Long id);


}
