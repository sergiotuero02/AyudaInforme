package com.example.PeregrinosFX.repository;

import com.example.PeregrinosFX.bean.Carnet;
import com.example.PeregrinosFX.bean.CarnetBackup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMongo extends MongoRepository<CarnetBackup, String> {
}
