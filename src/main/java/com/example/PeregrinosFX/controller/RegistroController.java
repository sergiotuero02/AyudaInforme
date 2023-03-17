package com.example.PeregrinosFX.controller;

import com.example.PeregrinosFX.bean.Parada;
import com.example.PeregrinosFX.bean.User;
import com.example.PeregrinosFX.config.StageManager;
import com.example.PeregrinosFX.service.CarnetService;
import com.example.PeregrinosFX.service.ParadaService;
import com.example.PeregrinosFX.service.PeregrinoService;
import com.example.PeregrinosFX.service.impl.UserServiceImpl;
import com.example.PeregrinosFX.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

@Controller
public class RegistroController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @Lazy
    @Autowired
    private UserServiceImpl userServiceImpl;

    @Lazy
    @Autowired
    private ParadaService paradaService;

    @Lazy
    @Autowired
    private PeregrinoService peregrinoService;

    @Lazy
    @Autowired
    private CarnetService carnetService;

    @FXML
    private Label nombreLBL;

    @FXML
    private Label usuarioLBL;

    @FXML
    private Label contrasenaLBL;

    @FXML
    private Label confirmcontraLBL;

    @FXML
    private Label paradaLBL;

    @FXML
    private Label nacionalidadLBL;

    @FXML
    private TextField nombreTF;

    @FXML
    private TextField usuarioTF;

    @FXML
    private TextField contrasenaTF;

    @FXML
    private TextField confirmcontraTF;

    @FXML
    private ComboBox paradaCB;

    @FXML
    private ComboBox nacionalidadCB;

    @FXML
    private Button aceptarBTN;

    @FXML
    private Button cancelarBTN;

    public StageManager getStageManager() {
        return stageManager;
    }

    public void setStageManager(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    public Label getNombreLBL() {
        return nombreLBL;
    }

    public void setNombreLBL(Label nombreLBL) {
        this.nombreLBL = nombreLBL;
    }

    public Label getUsuarioLBL() {
        return usuarioLBL;
    }

    public void setUsuarioLBL(Label usuarioLBL) {
        this.usuarioLBL = usuarioLBL;
    }

    public Label getContrasenaLBL() {
        return contrasenaLBL;
    }

    public void setContrasenaLBL(Label contrasenaLBL) {
        this.contrasenaLBL = contrasenaLBL;
    }

    public Label getConfirmcontraLBL() {
        return confirmcontraLBL;
    }

    public void setConfirmcontraLBL(Label confirmcontraLBL) {
        this.confirmcontraLBL = confirmcontraLBL;
    }

    public Label getParadaLBL() {
        return paradaLBL;
    }

    public void setParadaLBL(Label paradaLBL) {
        this.paradaLBL = paradaLBL;
    }

    public Label getNacionalidadLBL() {
        return nacionalidadLBL;
    }

    public void setNacionalidadLBL(Label nacionalidadLBL) {
        this.nacionalidadLBL = nacionalidadLBL;
    }

    public String getNombreTF() {
        return nombreTF.getText();
    }

    public void setNombreTF(TextField nombreTF) {
        this.nombreTF = nombreTF;
    }

    public String getUsuarioTF() {
        return usuarioTF.getText();
    }

    public void setUsuarioTF(TextField usuarioTF) {
        this.usuarioTF = usuarioTF;
    }

    public String getContrasenaTF() {
        return contrasenaTF.getText();
    }

    public void setContrasenaTF(TextField contrasenaTF) {
        this.contrasenaTF = contrasenaTF;
    }

    public TextField getConfirmcontraTF() {
        return confirmcontraTF;
    }

    public void setConfirmcontraTF(TextField confirmcontraTF) {
        this.confirmcontraTF = confirmcontraTF;
    }

    public ComboBox getParadaCB() {
        return paradaCB;
    }

    public void setParadaCB(ComboBox paradaCB) {
        this.paradaCB = paradaCB;
    }

    public ComboBox getNacionalidadCB() {
        return nacionalidadCB;
    }

    public void setNacionalidadCB(ComboBox nacionalidadCB) {
        this.nacionalidadCB = nacionalidadCB;
    }

    public Button getAceptarBTN() {
        return aceptarBTN;
    }

    public void setAceptarBTN(Button aceptarBTN) {
        this.aceptarBTN = aceptarBTN;
    }

    public Button getCancelarBTN() {
        return cancelarBTN;
    }

    public void setCancelarBTN(Button cancelarBTN) {
        this.cancelarBTN = cancelarBTN;
    }

    public static User userCreado;

    @FXML
    private void registro(ActionEvent event) throws IOException {

        //Comprobamos la disponibilidad del usuario
        if (userServiceImpl.userDisponible(getUsuarioTF())) {
            usuarioLBL.setText("NO DISPONIBLE");
            usuarioLBL.setTextFill(Paint.valueOf("#FF0000"));

            //Comprobamos que se han introducido todos los campos
        } else if (confirmcontraTF.equals("") || contrasenaTF.equals("") || usuarioTF.equals("") || nombreTF.equals("") || paradaCB.getSelectionModel().getSelectedItem() == null || nacionalidadCB.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos no introducidos");
            alert.setHeaderText(null);
            alert.setContentText("Introduzca todos los campos.");
            alert.showAndWait();
        }
        //Comprobamos que las contraseñas coincidan
        else if (!confirmcontraTF.getText().equals(contrasenaTF.getText())) {
            contrasenaLBL.setText("NO COINCIDEN");
            contrasenaLBL.setTextFill(Paint.valueOf("#FF0000"));
            confirmcontraLBL.setText("NO COINCIDEN");
            confirmcontraLBL.setTextFill(Paint.valueOf("#FF0000"));
        }
        //Una vez comprobamos, llamamos al metodo registro y mostramos un mensaje al usuario
        else {

            userCreado = userServiceImpl.registro((Parada) paradaCB.getSelectionModel().getSelectedItem(), getNombreTF(), getUsuarioTF(), getContrasenaTF(), (String) nacionalidadCB.getValue());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Usuario registrado");
            alert.setHeaderText(null);
            alert.setContentText("El usuario " + getUsuarioTF() + " se ha registrado correctamente.");
            alert.showAndWait();
            stageManager.switchScene(FxmlView.USUARIOCREADO);

        }

    }

    @FXML
    private void volverAlMenu(ActionEvent event) throws IOException {
        stageManager.switchScene(FxmlView.MENUPRINCIPAL);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nacionalidadCB.getItems().addAll(
                "España",
                "Alemania",
                "Rusia",
                "Rumanía",
                "Italia",
                "Francia"

        );
        ArrayList<Parada> paradas = new ArrayList<>();
        paradas = (ArrayList<Parada>) paradaService.findAll();
        for (Parada p : paradas) {
            paradaCB.getItems().add(p);
        }
    }
}
