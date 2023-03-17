package com.example.PeregrinosFX.controller;

import com.example.PeregrinosFX.bean.Parada;
import com.example.PeregrinosFX.config.StageManager;
import com.example.PeregrinosFX.service.impl.EnvioServiceImpl;
import com.example.PeregrinosFX.service.impl.ParadaServiceImpl;
import com.example.PeregrinosFX.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.PeregrinosFX.controller.LoginController.rol;
import static com.example.PeregrinosFX.controller.LoginController.u;

@Controller
public class VerEnviosController implements Initializable {
    @Lazy
    @Autowired
    private StageManager stageManager;
    @Lazy
    @Autowired
    private ParadaServiceImpl paradaServiceImpl;

    @Lazy
    @Autowired
    private EnvioServiceImpl envioServiceImpl;
    @FXML
    private Label paradaLBL;
    @FXML
    private ComboBox paradaCB;
    @FXML
    private Label envioLBL;
    @FXML
    private ListView enviosTA;
    @FXML
    private Button buscarBTN;
    @FXML
    private Button inicioBTN;

    @FXML
    private void volverAlMenu(ActionEvent event) throws IOException {
        if (rol == 2) {
            stageManager.switchScene(FxmlView.MENUADMINPARADA);
        }
        if (rol == 3) {
            stageManager.switchScene(FxmlView.MENUADMINGENERAL);
        }
    }

    @FXML
    private void verEnvio(ActionEvent event) {
        Parada parada = (Parada) paradaCB.getSelectionModel().getSelectedItem();
        envioServiceImpl.verEnvios(enviosTA, parada);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

    public StageManager getStageManager() {
        return stageManager;
    }

    public void setStageManager(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    public ParadaServiceImpl getParadaServiceImpl() {
        return paradaServiceImpl;
    }

    public void setParadaServiceImpl(ParadaServiceImpl paradaServiceImpl) {
        this.paradaServiceImpl = paradaServiceImpl;
    }

    public Label getParadaLBL() {
        return paradaLBL;
    }

    public void setParadaLBL(Label paradaLBL) {
        this.paradaLBL = paradaLBL;
    }

    public ComboBox getParadaCB() {
        return paradaCB;
    }

    public void setParadaCB(ComboBox paradaCB) {
        this.paradaCB = paradaCB;
    }

    public Label getEnvioLBL() {
        return envioLBL;
    }

    public void setEnvioLBL(Label envioLBL) {
        this.envioLBL = envioLBL;
    }

    public Button getBuscarBTN() {
        return buscarBTN;
    }

    public void setBuscarBTN(Button buscarBTN) {
        this.buscarBTN = buscarBTN;
    }

    public Button getInicioBTN() {
        return inicioBTN;
    }

    public void setInicioBTN(Button inicioBTN) {
        this.inicioBTN = inicioBTN;
    }
}
