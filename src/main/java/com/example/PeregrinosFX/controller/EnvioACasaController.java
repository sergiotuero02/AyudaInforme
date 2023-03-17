package com.example.PeregrinosFX.controller;

import com.example.PeregrinosFX.config.StageManager;
import com.example.PeregrinosFX.service.impl.EnvioServiceImpl;
import com.example.PeregrinosFX.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.PeregrinosFX.controller.LoginController.rol;

@Controller
public class EnvioACasaController implements Initializable {
    @Lazy
    @Autowired
    private StageManager stageManager;

    @Lazy
    @Autowired
    private EnvioServiceImpl envioServiceImpl;
    @FXML
    private Label direccionLBL;
    @FXML
    private Label localidadLBL;
    @FXML
    private Label alturaLBL;
    @FXML
    private Label anchoLBL;
    @FXML
    private Label profundoLBL;
    @FXML
    private Label pesoLBL;
    @FXML
    private TextField direccionTF;
    @FXML
    private TextField localidadTF;
    @FXML
    private TextField alturaTF;
    @FXML
    private TextField anchoTF;
    @FXML
    private TextField profundoTF;
    @FXML
    private TextField pesoTF;
    @FXML
    private CheckBox urgenteCB;
    @FXML
    private Button aceptarBTN;
    @FXML
    private Button cancelarBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void enviarACasa(ActionEvent event){
        envioServiceImpl.guardarEnvio(direccionTF, localidadTF, alturaTF, anchoTF, profundoTF, pesoTF, urgenteCB);
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

    public Label getDireccionLBL() {
        return direccionLBL;
    }

    public void setDireccionLBL(Label direccionLBL) {
        this.direccionLBL = direccionLBL;
    }

    public Label getLocalidadLBL() {
        return localidadLBL;
    }

    public void setLocalidadLBL(Label localidadLBL) {
        this.localidadLBL = localidadLBL;
    }

    public Label getAlturaLBL() {
        return alturaLBL;
    }

    public void setAlturaLBL(Label alturaLBL) {
        this.alturaLBL = alturaLBL;
    }

    public Label getAnchoLBL() {
        return anchoLBL;
    }

    public void setAnchoLBL(Label anchoLBL) {
        this.anchoLBL = anchoLBL;
    }

    public Label getProfundoLBL() {
        return profundoLBL;
    }

    public void setProfundoLBL(Label profundoLBL) {
        this.profundoLBL = profundoLBL;
    }

    public Label getPesoLBL() {
        return pesoLBL;
    }

    public void setPesoLBL(Label pesoLBL) {
        this.pesoLBL = pesoLBL;
    }

    public TextField getDireccionTF() {
        return direccionTF;
    }

    public void setDireccionTF(TextField direccionTF) {
        this.direccionTF = direccionTF;
    }

    public TextField getLocalidadTF() {
        return localidadTF;
    }

    public void setLocalidadTF(TextField localidadTF) {
        this.localidadTF = localidadTF;
    }

    public TextField getAlturaTF() {
        return alturaTF;
    }

    public void setAlturaTF(TextField alturaTF) {
        this.alturaTF = alturaTF;
    }

    public TextField getAnchoTF() {
        return anchoTF;
    }

    public void setAnchoTF(TextField anchoTF) {
        this.anchoTF = anchoTF;
    }

    public TextField getProfundoTF() {
        return profundoTF;
    }

    public void setProfundoTF(TextField profundoTF) {
        this.profundoTF = profundoTF;
    }

    public TextField getPesoTF() {
        return pesoTF;
    }

    public void setPesoTF(TextField pesoTF) {
        this.pesoTF = pesoTF;
    }

    public CheckBox getUrgenteCB() {
        return urgenteCB;
    }

    public void setUrgenteCB(CheckBox urgenteCB) {
        this.urgenteCB = urgenteCB;
    }
}
