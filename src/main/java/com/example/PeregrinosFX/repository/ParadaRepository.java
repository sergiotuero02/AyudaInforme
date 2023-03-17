package com.example.PeregrinosFX.repository;

import com.example.PeregrinosFX.bean.Parada;
import com.example.PeregrinosFX.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParadaRepository extends JpaRepository<Parada, Long> {
    Parada findByIdParada(Long parada);
}
