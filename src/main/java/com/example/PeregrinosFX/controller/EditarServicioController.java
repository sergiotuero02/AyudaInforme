package com.example.PeregrinosFX.controller;

import com.example.PeregrinosFX.bean.Parada;
import com.example.PeregrinosFX.bean.Servicio;
import com.example.PeregrinosFX.config.StageManager;
import com.example.PeregrinosFX.service.impl.ParadaServiceImpl;
import com.example.PeregrinosFX.service.impl.ServicioServiceImpl;
import com.example.PeregrinosFX.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

@Controller
public class EditarServicioController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @Lazy
    @Autowired
    private ParadaServiceImpl paradaServiceImpl;

    @FXML
    private Label nombreLBL;

    @FXML
    private Label servicioBL;

    @FXML
    private Label precioLBL;

    @FXML
    private TextField nombreTF;

    @FXML
    private TextField precioTF;

    @FXML
    private Button confirmarBTN;

    @FXML
    private Button cancelarBTN;

    @FXML
    private TableView paradaTB;

    @FXML
    private TableColumn idParadaTC;

    @FXML
    private TableColumn nombreParadaTC;

    @FXML
    private ComboBox paradasCB;

    @FXML
    private ComboBox serviciosCB;

    @FXML
    private ComboBox paradasdelCB;

    @FXML
    private Button addBTN;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ServicioServiceImpl.cargarServicios(serviciosCB);
        paradaServiceImpl.cargarCB(paradasCB, paradaServiceImpl);
        paradaServiceImpl.cargarCB(paradasdelCB, paradaServiceImpl);

    }

    @FXML
    private void cargarTabla(ActionEvent event) {
        Servicio servicio = (Servicio) serviciosCB.getSelectionModel().getSelectedItem();
        ArrayList<Parada> paradaSer = new ArrayList<Parada>();
        for (Long id : servicio.getIdParadas()){
                Parada p = paradaServiceImpl.findByIdParada(id);
                paradaSer.add(p);
        }
        ArrayList<Parada> paradas = paradaSer;
        paradaTB.getItems().clear();

        idParadaTC.setCellValueFactory(new PropertyValueFactory<>("idParada"));
        nombreParadaTC.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        for (Parada p : paradas) {
            paradaTB.getItems().add(p);
        }

        nombreTF.setText(servicio.getNombre());
        precioTF.setText(String.valueOf(servicio.getPrecio()));
    }

    @FXML
    public void editar(ActionEvent event) {
        Servicio servicio = (Servicio) serviciosCB.getSelectionModel().getSelectedItem();
        ServicioServiceImpl.editarServicio(nombreTF, precioTF, paradaTB, servicio);
    }

    @FXML
    private void addTabla(ActionEvent event) {
        Parada p = (Parada) paradasCB.getSelectionModel().getSelectedItem();
        ParadaServiceImpl.addParadaTabla(paradaTB, idParadaTC, nombreParadaTC, p);
    }

    @FXML
    private void borrarTabla(ActionEvent event) {
        Parada p = (Parada) paradasdelCB.getSelectionModel().getSelectedItem();
        ParadaServiceImpl.delParadaTabla(paradaTB, p);
    }

    @FXML
    private void volverAlMenu(ActionEvent event) throws IOException {
        stageManager.switchScene(FxmlView.MENUSERVICIOS);
    }

    public Label getNombreLBL() {
        return nombreLBL;
    }

    public void setNombreLBL(Label nombreLBL) {
        this.nombreLBL = nombreLBL;
    }

    public Label getPrecioLBL() {
        return precioLBL;
    }

    public void setPrecioLBL(Label precioLBL) {
        this.precioLBL = precioLBL;
    }

    public TextField getNombreTF() {
        return nombreTF;
    }

    public void setNombreTF(TextField nombreTF) {
        this.nombreTF = nombreTF;
    }

    public TextField getPrecioTF() {
        return precioTF;
    }

    public void setPrecioTF(TextField precioTF) {
        this.precioTF = precioTF;
    }

    public Button getConfirmarBTN() {
        return confirmarBTN;
    }

    public void setConfirmarBTN(Button confirmarBTN) {
        this.confirmarBTN = confirmarBTN;
    }

    public Button getCancelarBTN() {
        return cancelarBTN;
    }

    public void setCancelarBTN(Button cancelarBTN) {
        this.cancelarBTN = cancelarBTN;
    }

    public TableView getParadaTB() {
        return paradaTB;
    }

    public void setParadaTB(TableView paradaTB) {
        this.paradaTB = paradaTB;
    }

    public TableColumn getIdParadaTC() {
        return idParadaTC;
    }

    public void setIdParadaTC(TableColumn idParadaTC) {
        this.idParadaTC = idParadaTC;
    }

    public TableColumn getNombreParadaTC() {
        return nombreParadaTC;
    }

    public void setNombreParadaTC(TableColumn nombreParadaTC) {
        this.nombreParadaTC = nombreParadaTC;
    }

    public ComboBox getParadasCB() {
        return paradasCB;
    }

    public void setParadasCB(ComboBox paradasCB) {
        this.paradasCB = paradasCB;
    }

    public Button getAddBTN() {
        return addBTN;
    }

    public void setAddBTN(Button addBTN) {
        this.addBTN = addBTN;
    }
}
