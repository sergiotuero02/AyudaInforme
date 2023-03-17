package com.example.PeregrinosFX.controller;

import com.example.PeregrinosFX.bean.Peregrino;
import com.example.PeregrinosFX.config.StageManager;
import com.example.PeregrinosFX.service.PeregrinoService;
import com.example.PeregrinosFX.service.impl.CarnetServiceImpl;
import com.example.PeregrinosFX.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
public class ExportarCarnetController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @Autowired
    private CarnetServiceImpl carnetServiceImpl;

    @Autowired
    private PeregrinoService peregrinoService;

    @FXML
    private Button expcarnetBTN;

    @FXML
    private Button cancelarBTN;

    @FXML
    private ComboBox peregrinosCB;

    @FXML
    private void exportarCarnet(ActionEvent event) throws IOException {
        try {
            //Llamamos al método exportar carnet e informamos al usuario del éxito de la operación
            carnetServiceImpl.exportarCarnet((Peregrino) peregrinosCB.getSelectionModel().getSelectedItem());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Usuario registrado");
            alert.setHeaderText(null);
            alert.setContentText("Carnet del peregrino " + peregrinosCB.getSelectionModel().getSelectedItem() + " ha sido exportado.");
            alert.showAndWait();

        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Introduzca todos los campos");
            alert.setHeaderText(null);
            alert.setContentText("Introduzca todos los campos");
            alert.showAndWait();
        }

    }

    @FXML
    private void cancelarAction(ActionEvent event) throws IOException {
        if (rol == 1) {
            stageManager.switchScene(FxmlView.MENUPEREGRINO);
        }
        if (rol == 3) {
            stageManager.switchScene(FxmlView.MENUADMINGENERAL);
        }
    }

    @FXML
    private void abrirRegistro(ActionEvent event) throws IOException {
        stageManager.switchScene(FxmlView.REGISTRO);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Cargamos los combo box, si el perfil/ rol es peregrino o parada solo cargaremos el valor correspondiente
        //a ese peregrino o parada, pero si es un admin general los cargaremos todos
        if (rol == 1) {
            peregrinosCB.setValue(u.getPeregrino());
        } else {
            ArrayList<Peregrino> peregrinos = new ArrayList<>();
            peregrinos = (ArrayList<Peregrino>) peregrinoService.findAll();
            for (Peregrino p : peregrinos) {
                peregrinosCB.getItems().add(p);
            }

        }
    }

}
