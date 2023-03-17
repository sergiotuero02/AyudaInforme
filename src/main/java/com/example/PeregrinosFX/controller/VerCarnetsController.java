package com.example.PeregrinosFX.controller;

import com.example.PeregrinosFX.Connections.ConnectExistDB;
import com.example.PeregrinosFX.bean.Parada;
import com.example.PeregrinosFX.config.StageManager;
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
public class VerCarnetsController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;
    @Lazy
    @Autowired
    private ParadaServiceImpl paradaServiceImpl;
    @FXML
    private Label paradaLBL;
    @FXML
    private ComboBox paradaCB;
    @FXML
    private Label carnetLBL;
    @FXML
    private ListView carnetsLV;
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
    private void verCarnets(ActionEvent event){
        Parada parada = (Parada) paradaCB.getSelectionModel().getSelectedItem();
        ConnectExistDB connectExistDB = new ConnectExistDB();
        connectExistDB.carnets(parada, carnetsLV);
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
}
