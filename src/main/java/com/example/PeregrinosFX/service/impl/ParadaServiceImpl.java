package com.example.PeregrinosFX.service.impl;

import com.example.PeregrinosFX.bean.Estancia;
import com.example.PeregrinosFX.bean.Parada;
import com.example.PeregrinosFX.bean.User;
import com.example.PeregrinosFX.repository.ParadaRepository;
import com.example.PeregrinosFX.service.EstanciaService;
import com.example.PeregrinosFX.service.ParadaService;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;

@Service
public class ParadaServiceImpl implements ParadaService {
    @Autowired
    private ParadaRepository paradaRepository;

    @Autowired
    private EstanciaService estanciaService;

    public static void cargarCB(ComboBox paradaCB, ParadaServiceImpl paradaServiceImpl){
        ArrayList<Parada> paradas = new ArrayList<Parada>();
        paradas = (ArrayList<Parada>) paradaServiceImpl.findAll();
        for (Parada p : paradas) {
            paradaCB.getItems().add(p);
        }
    }

    public static void addParadaTabla(TableView paradaTB, TableColumn idParadaTC, TableColumn nombreParadaTC, Parada p){
        try {

            idParadaTC.setCellValueFactory(new PropertyValueFactory<>("idParada"));
            nombreParadaTC.setCellValueFactory(new PropertyValueFactory<>("nombre"));

            boolean paradaSel = false;

            for (Object pAux : paradaTB.getItems()) {
                if (((Parada) pAux).getIdParada().equals(p.getIdParada())) {
                    paradaSel = true;
                    break;
                }
            }

            if (p == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Introduzca la parada");
                alert.show();
            } else if (!paradaSel && p != null) {
                paradaTB.getItems().add(p);
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("ERROR");
                alerta.setContentText("Parada ya seleccionada");
                alerta.show();
            }

        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Introduzca todos los campos");
            alert.setContentText("Introduzca todos los campos");
            alert.show();


        }
    }

    public static void delParadaTabla(TableView paradaTB, Parada p){

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Introduzca la parada");
            alert.show();
        } else {
            try {
                boolean pExclud = false;
                for (Object o : paradaTB.getItems()) {
                    if (((Parada) o).getIdParada().equals(p.getIdParada())) {
                        paradaTB.getItems().remove(o);
                        pExclud = false;
                        break;
                    }else{
                        pExclud = true;
                    }
                }
                if(pExclud){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setContentText("La parada seleccionada ya está excluida");
                    alert.show();
                }
            } catch (ConcurrentModificationException e) {

            }
        }
    }

    /*
     * Método que recibe como parámetros dos fechas y una parada y devuelve una lista de estancias
     * @return una List de estancias
     * */
    public List<Estancia> datosParada(LocalDate fechaInicial, LocalDate fechaFinal, Parada paradaCB) {

//Creamos la lista de estancias que después cargaremos
        List<Estancia> estanciasBD = null;

        //Comprobamos que las fechas sean válidas
        if (fechaInicial.isEqual(fechaFinal)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fechas incorrectas");
            alert.setHeaderText(null);
            alert.setContentText("Las fechas son iguales.");
            alert.showAndWait();
        }

        if (fechaInicial.isAfter(fechaFinal)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Fechas incorrectas");
            alert.setHeaderText(null);
            alert.setContentText("La fecha final es antes que la inicial.");
            alert.showAndWait();

        }

        //Si las fechas son correctas llamamos al método previamente creado que busca todas las estancias para una parada concreta
        if (fechaInicial.isBefore(fechaFinal)) {
            estanciasBD = estanciaService.findByParada(paradaCB);

        }
        return estanciasBD;

    }



    @Override
    public Parada save(Parada entity) {
        return null;
    }

    @Override
    public Parada update(Parada entity) {
        return null;
    }

    @Override
    public void delete(Parada entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteInBatch(List<Parada> entities) {

    }

    @Override
    public Parada find(Long id) {
        return null;
    }

    @Override
    public Parada findByIdParada(Long id) {
        return paradaRepository.findByIdParada(id);
    }

    @Override
    public List<Parada> findAll() {
        return paradaRepository.findAll();
    }

    @Override
    public Parada addParada(Parada parada) {
        return null;
    }

}
