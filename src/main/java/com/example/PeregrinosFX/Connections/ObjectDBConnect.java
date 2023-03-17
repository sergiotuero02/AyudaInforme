package com.example.PeregrinosFX.Connections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObjectDBConnect {
        public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("peregrinos.odb");
        public static EntityManager em = emf.createEntityManager();

}
