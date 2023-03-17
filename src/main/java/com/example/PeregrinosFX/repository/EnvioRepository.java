package com.example.PeregrinosFX.repository;

import com.example.PeregrinosFX.Connections.ObjectDBConnect;
import com.example.PeregrinosFX.bean.EnvioACasa;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

import static com.example.PeregrinosFX.Connections.ObjectDBConnect.em;

@Repository
public class EnvioRepository {
    public List<EnvioACasa> verEnvios(){
        TypedQuery<EnvioACasa> query = em.createQuery("SELECT p FROM EnvioACasa p", EnvioACasa.class);
        List<EnvioACasa> envios = query.getResultList();
        return envios;
    }

    public void addEnvio(EnvioACasa envio){
        ObjectDBConnect.em.getTransaction().begin();
        ObjectDBConnect.em.persist(envio);
        ObjectDBConnect.em.getTransaction().commit();
    }
}
