package com.example.PeregrinosFX.controller;

import com.db4o.ObjectSet;
import com.example.PeregrinosFX.bean.Parada;
import com.example.PeregrinosFX.bean.Peregrino;
import com.example.PeregrinosFX.bean.Servicio;
import com.example.PeregrinosFX.config.StageManager;
import com.example.PeregrinosFX.service.CarnetService;
import com.example.PeregrinosFX.service.ParadaService;
import com.example.PeregrinosFX.service.PeregrinoService;
import com.example.PeregrinosFX.service.impl.EstanciaServiceImpl;
import com.example.PeregrinosFX.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.PeregrinosFX.bean.Servicio.db;
import static com.example.PeregrinosFX.controller.LoginController.rol;
import static com.example.PeregrinosFX.controller.LoginController.u;

@Controller
public class AlojarseController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;


    @Autowired
    private ParadaService paradaService;

    @Autowired
    private CarnetService carnetService;


    @Autowired
    private PeregrinoService peregrinoService;


    @Autowired
    private EstanciaServiceImpl estanciaServiceImpl;

    @FXML
    private Label paradaLBL;

    @FXML
    private Label peregrinoLBL;

    @FXML
    private Label estanciaLBL;

    @FXML
    private Label vipLBL;

    @FXML
    public Label servicioLBL;

    @FXML
    public Label pagosLBL;

    @FXML
    public TableView servicioTB;

    @FXML
    public TableColumn nombreTC;

    @FXML
    public TableColumn precioTC;

    @FXML
    public ComboBox serviciosCB;

    @FXML
    public Button addBTN;

    @FXML
    private CheckBox estanciaCheck;

    @FXML
    private ComboBox paradaCB;

    @FXML
    private ComboBox peregrinoCB;

    @FXML
    private ComboBox pagosCB;

    @FXML
    private CheckBox vipCB;

    @FXML
    private Button alojarseBTN;

    @FXML
    private Button cancelarBTN;

    @FXML
    private Label precioLBL;

    @FXML
    private Label totalLBL;

    @FXML
    private Label extraLBL;
    @FXML
    private TextField extraTF;


    public StageManager getStageManager() {
        return stageManager;
    }

    public void setStageManager(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    public Label getParadaLBL() {
        return paradaLBL;
    }


    public void setParadaLBL(Label paradaLBL) {
        this.paradaLBL = paradaLBL;
    }

    public Label getPeregrinoLBL() {
        return peregrinoLBL;
    }

    public void setPeregrinoLBL(Label peregrinoLBL) {
        this.peregrinoLBL = peregrinoLBL;
    }

    public Label getEstanciaLBL() {
        return estanciaLBL;
    }

    public void setEstanciaLBL(Label estanciaLBL) {
        this.estanciaLBL = estanciaLBL;
    }

    public Label getVipLBL() {
        return vipLBL;
    }

    public void setVipLBL(Label vipLBL) {
        this.vipLBL = vipLBL;
    }

    public CheckBox getEstanciaCheck() {
        return estanciaCheck;
    }

    public void setEstanciaCheck(CheckBox estanciaCheck) {
        this.estanciaCheck = estanciaCheck;
    }

    public ComboBox getParadaCB() {
        return paradaCB;
    }

    public void setParadaCB(ComboBox paradaCB) {
        this.paradaCB = paradaCB;
    }

    public ComboBox getPeregrinoCB() {
        return peregrinoCB;
    }

    public void setPeregrinoCB(ComboBox peregrinoCB) {
        this.peregrinoCB = peregrinoCB;
    }

    public Button getAlojarseBTN() {
        return alojarseBTN;
    }

    public void setAlojarseBTN(Button alojarseBTN) {
        this.alojarseBTN = alojarseBTN;
    }

    public Button getCancelarBTN() {
        return cancelarBTN;
    }

    public void setCancelarBTN(Button cancelarBTN) {
        this.cancelarBTN = cancelarBTN;
    }


    @FXML
    private void alojar(ActionEvent event) throws IOException {
        Peregrino peregrino = (Peregrino) peregrinoCB.getSelectionModel().getSelectedItem();
        Parada parada = (Parada) paradaCB.getSelectionModel().getSelectedItem();
        estanciaServiceImpl.alojar(peregrino, parada, estanciaCheck, vipCB, servicioTB, pagosCB, extraTF, totalLBL);
    }

    @FXML
    private void servicioSelected(ActionEvent event) throws IOException {
        serviciosCB.getItems().clear();
        servicioTB.getItems().clear();
        Servicio servicio = new Servicio();
        ObjectSet<Servicio> servicios = db.queryByExample(servicio);
        Parada parada = (Parada) paradaCB.getSelectionModel().getSelectedItem();
        for (Servicio s : servicios) {
            for (Long id : s.getIdParadas()) {
                if (id.equals(parada.getIdParada())) {
                    serviciosCB.getItems().add(s);
                    break;
                }
            }

        }
    }

    //Método que activa o desactiva el campo vip en función de si hay estancia o no
    @FXML
    private void estanciaClick(ActionEvent event) throws IOException {
        servicioTB.getItems().clear();
        totalLBL.setText("");
        ObjectSet<Servicio> servicios = null;
        if (estanciaCheck.isSelected()) {
            vipLBL.setTextFill(Paint.valueOf("45322e"));
            vipCB.setDisable(false);
            servicioLBL.setTextFill(Paint.valueOf("45322e"));
            serviciosCB.setDisable(false);
            pagosLBL.setTextFill(Paint.valueOf("45322e"));
            pagosCB.setDisable(false);
            precioLBL.setTextFill(Paint.valueOf("45322e"));
            totalLBL.setTextFill(Paint.valueOf("45322e"));
            extraTF.setDisable(false);
            extraLBL.setTextFill(Paint.valueOf("45322e"));

        } else {
            vipLBL.setTextFill(Paint.valueOf("45322e70"));
            vipCB.setDisable(true);
            servicioLBL.setTextFill(Paint.valueOf("45322e70"));
            serviciosCB.setDisable(true);
            pagosLBL.setTextFill(Paint.valueOf("45322e70"));
            pagosCB.setDisable(true);
            precioLBL.setTextFill(Paint.valueOf("45322e70"));
            totalLBL.setTextFill(Paint.valueOf("45322e70"));
            extraTF.setDisable(true);
            extraLBL.setTextFill(Paint.valueOf("45322e70"));

        }

    }

    @FXML
    private void addServicio(ActionEvent event) {
        Servicio servicio = (Servicio) serviciosCB.getSelectionModel().getSelectedItem();

        try {
            nombreTC.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            precioTC.setCellValueFactory(new PropertyValueFactory<>("precio"));

            boolean servicioSel = false;

            for (Object servicioAux : servicioTB.getItems()) {
                if (((Servicio) servicioAux).getNombre().equalsIgnoreCase(servicio.getNombre())) {
                    servicioSel = true;
                    break;
                }
            }

            if (servicio == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Introduzca la parada");
                alert.show();
            } else if (!servicioSel && servicio != null) {
                servicioTB.getItems().add(servicio);
                String precio = totalLBL.getText();
                if (precio.equals("")) {
                    totalLBL.setText(String.valueOf(servicio.getPrecio()));
                } else {
                    Double total = Double.parseDouble(precio) + servicio.getPrecio();
                    totalLBL.setText(String.valueOf(total));
                }
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("ERROR");
                alerta.setContentText("Servicio ya seleccionado");
                alerta.show();
            }

        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Introduzca todos los campos");
            alert.setContentText("Introduzca todos los campos");
            alert.show();


        }
    }

    @FXML
    private void cancelarAction(ActionEvent event) throws IOException {
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
        ArrayList<Peregrino> peregrinos = new ArrayList<>();
        pagosCB.setDisable(true);
        serviciosCB.setDisable(true);
        extraTF.setDisable(true);
        peregrinos = (ArrayList<Peregrino>) peregrinoService.findAll();
        pagosCB.getItems().add("B (Bizum)");
        pagosCB.getItems().add("T (VISA/MASTERCARD)");
        pagosCB.getItems().add("E (Efectivo)");
        for (Peregrino p1 : peregrinos) {
            peregrinoCB.getItems().add(p1);

        }
        if (rol == 2) {
            paradaCB.setValue(u.getParada());
            Servicio servicio = new Servicio();
            ObjectSet<Servicio> servicios = db.queryByExample(servicio);
            Parada parada = (Parada) paradaCB.getSelectionModel().getSelectedItem();
            for (Servicio s : servicios) {
                for (Long id : s.getIdParadas()) {
                    if (id.equals(parada.getIdParada())) {
                        serviciosCB.getItems().add(s);
                        break;
                    }
                }

            }
        } else {
            ArrayList<Parada> paradas = new ArrayList<>();
            paradas = (ArrayList<Parada>) paradaService.findAll();
            for (Parada p : paradas) {
                paradaCB.getItems().add(p);
            }
        }

    }
}
