package com.example.PeregrinosFX.service;

import com.example.PeregrinosFX.bean.User;
import com.example.PeregrinosFX.generic.GenericService;


public interface UserService extends GenericService <User> {

    boolean login(String usuario, String contrasenia);

    User findByUsuario(String usuario);

    boolean userDisponible (String usuario);

    public abstract User addUser(User user);
}
