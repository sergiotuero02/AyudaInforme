package com.example.PeregrinosFX.controller;

import com.example.PeregrinosFX.config.StageManager;
import com.example.PeregrinosFX.service.impl.CarnetServiceImpl;
import com.example.PeregrinosFX.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class MenuAdminGeneralController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @Autowired
    private CarnetServiceImpl carnetServiceImpl;



    @FXML
    private Button informeparadaBTN;

    @FXML
    private Button exportarcarnetBTN;

    @FXML
    private Button alojarseBTN;

    @FXML
    private Button serviciosBTN;

    @FXML
    private Button envioBTN;

    @FXML
    private Button carnetsBTN;

    @FXML
    private Button cerrarsesionBTN;

    @FXML
    private Button backupBTN;

    @FXML
    private void abrirAlojarse(ActionEvent event) throws IOException {
        stageManager.switchScene(FxmlView.ALOJARSE);
    }

    @FXML
    private void backup(ActionEvent event) throws JRException {
         carnetServiceImpl.backup();
    }

    @FXML
    private void abrirExportarCarnet(ActionEvent event) throws IOException {
        stageManager.switchScene(FxmlView.EXPORTARCARNET);
    }

    @FXML
    private void abrirInformeParadas(ActionEvent event) throws IOException {
        stageManager.switchScene(FxmlView.DATOSPARADA);
    }

    @FXML
    private void abrirServicios(ActionEvent event) throws IOException {
        stageManager.switchScene(FxmlView.MENUSERVICIOS);
    }

    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        stageManager.switchScene(FxmlView.MENUPRINCIPAL);
    }

    @FXML
    private void verEnvio(ActionEvent event) throws IOException {
        stageManager.switchScene(FxmlView.VERENVIO);
    }

    @FXML
    private void verCarnets(ActionEvent event) throws IOException {
        stageManager.switchScene(FxmlView.VERCARNETS);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
