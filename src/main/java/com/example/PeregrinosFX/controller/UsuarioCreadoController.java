package com.example.PeregrinosFX.controller;

import com.example.PeregrinosFX.config.StageManager;
import com.example.PeregrinosFX.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.PeregrinosFX.controller.RegistroController.userCreado;

@Controller
public class UsuarioCreadoController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    private TextField passTF;

    @FXML
    private TextField usuarioTXT;

    @FXML
    private TextField nacionalidadTXT;

    @FXML
    private TextField paradaTXT;

    @FXML
    private Button inicioBTN;

    @FXML
    private void inicioAction(ActionEvent event) throws IOException {
        stageManager.switchScene(FxmlView.MENUPRINCIPAL);

    }

    @FXML
    private void mostrarAction(ActionEvent event) throws IOException {
        passTF.setText(userCreado.getContrasenia());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        paradaTXT.setText(userCreado.getPeregrino().getCarnet().getParadaInicial().getNombre());
        usuarioTXT.setText(userCreado.getUsuario());
        nacionalidadTXT.setText(userCreado.getPeregrino().getNacionalidad());
        String contrasenaOcult = "";
        for(int i = 0; i<userCreado.getContrasenia().length(); i++){
            contrasenaOcult = contrasenaOcult+ "*";
        }
        passTF.setText(contrasenaOcult);
    }



    public StageManager getStageManager() {
        return stageManager;
    }

    public void setStageManager(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    public TextField getPassTF() {
        return passTF;
    }

    public void setPassTF(TextField passTF) {
        this.passTF = passTF;
    }

    public Button getInicioBTN() {
        return inicioBTN;
    }

    public void setInicioBTN(Button inicioBTN) {
        this.inicioBTN = inicioBTN;
    }

    public TextField getUsuarioTXT() {
        return usuarioTXT;
    }

    public void setUsuarioTXT(TextField usuarioTXT) {
        this.usuarioTXT = usuarioTXT;
    }

    public TextField getNacionalidadTXT() {
        return nacionalidadTXT;
    }

    public void setNacionalidadTXT(TextField nacionalidadTXT) {
        this.nacionalidadTXT = nacionalidadTXT;
    }

    public TextField getParadaTXT() {
        return paradaTXT;
    }

    public void setParadaTXT(TextField paradaTXT) {
        this.paradaTXT = paradaTXT;
    }
}
