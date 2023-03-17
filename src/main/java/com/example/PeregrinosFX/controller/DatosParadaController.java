package com.example.PeregrinosFX.controller;

import com.example.PeregrinosFX.bean.Estancia;
import com.example.PeregrinosFX.bean.Parada;
import com.example.PeregrinosFX.config.StageManager;
import com.example.PeregrinosFX.service.EstanciaService;
import com.example.PeregrinosFX.service.impl.ParadaServiceImpl;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.PeregrinosFX.controller.LoginController.rol;
import static com.example.PeregrinosFX.controller.LoginController.u;

@Controller
public class DatosParadaController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @Lazy
    @Autowired
    private EstanciaService estanciaService;

    @Lazy
    @Autowired
    private ParadaServiceImpl paradaServiceImpl;

    @FXML
    private TableView estanciasTABLE;

    @FXML
    private TableColumn idColmn;

    @FXML
    private TableColumn fechaColmn;

    @FXML
    private TableColumn vipColmn;

    @FXML
    private TableColumn peregrinoColmn;

    @FXML
    private Label paradaLBL;

    @FXML
    private Label fechainicialLBL;

    @FXML
    private Label fechafinalLBL;

    @FXML
    private Label estanciasLBL;

    @FXML
    private DatePicker fechainicialDATE;

    @FXML
    private DatePicker fechafinalDATE;

    @FXML
    private Button inicioBTN;

    @FXML
    private ComboBox paradaCB;


    /*
    *Método que añade todas las estancias para una parada concreta en un rango de fechas específico
    **/
    @FXML
    private void datosParada(ActionEvent event) throws IOException {

        try {

            LocalDate fechaInicial, fechaFinal;
            fechaInicial = fechainicialDATE.getValue();
            fechaFinal = fechafinalDATE.getValue();

            idColmn.setCellValueFactory(new PropertyValueFactory<>("idEstancia"));
            fechaColmn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            vipColmn.setCellValueFactory(new PropertyValueFactory<>("vip"));
            peregrinoColmn.setCellValueFactory(new PropertyValueFactory<>("peregrino"));

            //Llamamos al método datosParada que nos devuelve una colección de estancias, después las añadimos a la tabla aplicando el filtro de fechas
            ArrayList<Estancia> estanciasBD = (ArrayList<Estancia>) paradaServiceImpl.datosParada(fechaInicial, fechaFinal, (Parada) paradaCB.getSelectionModel().getSelectedItem());
            for (Estancia e : estanciasBD) {
                if (e.getFecha().equals(fechaFinal) || e.getFecha().equals(fechaFinal) || e.getFecha().isAfter(fechaInicial) && e.getFecha().isBefore(fechaFinal)) {
                    estanciasTABLE.getItems().add(e);
                }

            }

        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Introduzca todos los campos");
            alert.setHeaderText(null);
            alert.setContentText("Introduzca todos los campos");
            alert.showAndWait();
        }
    }

    @FXML
    private void volverAlMenu(ActionEvent event) throws IOException {
        if (rol == 2) {
            stageManager.switchScene(FxmlView.MENUADMINPARADA);
        }
        if (rol == 3) {
            stageManager.switchScene(FxmlView.MENUADMINGENERAL);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Cargamos los combo box, si el perfil/ rol es peregrino o parada solo cargaremos el valor correspondiente
        //a ese peregrino o parada, pero si es un admin general los cargaremos todos
        if (rol == 2) {
            paradaCB.setValue(u.getParada());
        } else {
            ArrayList<Parada> paradas = new ArrayList<>();
            paradas = (ArrayList<Parada>) paradaServiceImpl.findAll();
            for (Parada p : paradas) {
                paradaCB.getItems().add(p);
            }
        }
    }
}
