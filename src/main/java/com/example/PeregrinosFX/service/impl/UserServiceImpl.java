package com.example.PeregrinosFX.service.impl;

import com.example.PeregrinosFX.Connections.ConnectExistDB;
import com.example.PeregrinosFX.bean.*;
import com.example.PeregrinosFX.repository.UserRespository;
import com.example.PeregrinosFX.service.CarnetService;
import com.example.PeregrinosFX.service.ParadaService;
import com.example.PeregrinosFX.service.PeregrinoService;
import com.example.PeregrinosFX.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRespository userRespository;

    @Lazy
    @Autowired
    private UserService userService;

    @Lazy
    @Autowired
    private ParadaService paradaService;

    @Lazy
    @Autowired
    private PeregrinoService peregrinoService;

    @Lazy
    @Autowired
    private CarnetService carnetService;


    /*Método que registra un nuevo usuario de tipo peregrino
    recibe por parámetro todos los campos necesarios para la creación de u nuevo usuario,
    peregrino y carnet y los registra en la base de datos
    @return un objeto de tipo user con el usuario creado
     */
    public User registro(Parada paradaCB, String nombreTF, String usuarioTF, String contrasenaTF, String nacionalidad) {

        //Se crean las variables necesarias para el registro
        User user = new User();
        Peregrino peregrino = new Peregrino();
        Carnet carnet = new Carnet();
        Perfil perfil = new Perfil();

        //Asignamos el perfil 1 (peregrino) y todos los campos necesarios para el usuario
        perfil.setIdPerfil(1L);
        user.setContrasenia(contrasenaTF);
        user.setUsuario(usuarioTF);
        user.setPerfil(perfil);

        //Se asignan al carnet los valores por defecto (distancia 0 y numVips 0) además de la parada
        carnet.setDistancia(0.0);
        carnet.setFechaExp(LocalDate.now());
        carnet.setNumVips(0);
        carnet.setParadaInicial(paradaCB);

        //Asignamos todos los campos necesarios al peregrino
        peregrino.setNombre(nombreTF);
        peregrino.setNacionalidad((String) nacionalidad);
        peregrino.setCarnet(carnet);

        //Le añadimos la parada inicial a la lista de paradas del peregrino para que se nos guarde en la tabla peregrino/parada
        List<Parada> paradas = new ArrayList<Parada>();
        paradas.add(paradaCB);
        peregrino.setParadas(paradas);

        //Al usuario le asignamos el peregrino que acabamos de crear
        user.setPeregrino(peregrino);

        //Almacenamos el carnet, el peregrino y el usuario en la bd
        carnetService.addCarnet(carnet);
        peregrinoService.addPeregrino(peregrino);
        userService.addUser(user);
        ConnectExistDB connectExistDB = new ConnectExistDB();
        connectExistDB.almacenarCarnet(CarnetServiceImpl.exportarCarnet(peregrino), paradaCB);


        return user;
    }

    @Override
    public boolean login(String usuario, String contrasenia) {
        //Buscamos el usuario en la bd y comprobamos que el usuario exista, en caso de que exista comprobamos que la contraseña coincida
        User user = findByUsuario(usuario);
        if (user == null) {
            return false;
        } else {
            if ((contrasenia.equals(user.getContrasenia()))) {
                return true;
            }
        }

        return false;
    }

    @Override
    public User findByUsuario(String username) {
        return userRespository.findByUsuario(username);
    }



    @Override
    public boolean userDisponible(String usuario) {
        //Comprobamos la disponibilidad de un nombre de usuario para efectuar un registro
        User u = findByUsuario(usuario);
        if (u == null) {
            return false;
        } else return true;
    }

    @Override
    public User addUser(User user) {
        return userRespository.save(user);
    }


    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteInBatch(List<User> entities) {

    }

    @Override
    public User find(Long id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }


}
