package com.example.PeregrinosFX.service.impl;

import com.example.PeregrinosFX.bean.Direccion;
import com.example.PeregrinosFX.bean.EnvioACasa;
import com.example.PeregrinosFX.bean.Parada;
import com.example.PeregrinosFX.config.StageManager;
import com.example.PeregrinosFX.repository.EnvioRepository;
import com.example.PeregrinosFX.view.FxmlView;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.PeregrinosFX.controller.LoginController.rol;
import static com.example.PeregrinosFX.service.impl.EstanciaServiceImpl.paradaEnvio;


@Service
public class EnvioServiceImpl {

    @Lazy
    @Autowired
    private StageManager stageManager;
    @Autowired
    public EnvioRepository envioRepository;

    public void guardarEnvio(TextField direccionTF, TextField localidadTF, TextField alturaTF, TextField anchoTF, TextField profundoTF, TextField pesoTF, CheckBox urgenteCB){
        if(direccionTF.equals("") || localidadTF.equals("") || alturaTF.equals("") || anchoTF.equals("") || profundoTF.equals("") || pesoTF.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Introduzca todos los campos");
            alert.show();
        }else {
            try {
                Direccion direccion = new Direccion();
                EnvioACasa envio = new EnvioACasa();
                double[]dimensiones = new double[3];
                dimensiones[0] = Double.parseDouble(alturaTF.getText());
                dimensiones[1] = Double.parseDouble(anchoTF.getText());
                dimensiones[2] = Double.parseDouble(profundoTF.getText());

                direccion.setDireccion(direccionTF.getText());
                direccion.setLocalidad(localidadTF.getText());

                envio.setVolumen(dimensiones);
                envio.setDireccion(direccion);
                envio.setPeso(Double.parseDouble(pesoTF.getText()));
                envio.setUrgente(urgenteCB.isSelected());
                envio.setIdParada(paradaEnvio.getIdParada());
                envioRepository.addEnvio(envio);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ÉXITO");
                alert.setContentText("Envío procesado exitosamente");
                alert.show();
                if (rol == 2) {
                    stageManager.switchScene(FxmlView.MENUADMINPARADA);
                }
                if (rol == 3) {
                    stageManager.switchScene(FxmlView.MENUADMINGENERAL);
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("El peso, la altura, el ancho y la profundidad deben ser un número");
                alert.show();
            }
        }
        }
    public void verEnvios(ListView enviosTA, Parada parada){
        enviosTA.getItems().clear();
        List<EnvioACasa> envios = envioRepository.verEnvios();
        if (envios.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("No hay ningún envíos");
            alerta.setContentText("No hay ningún envío para la parada seleccionada");
            alerta.show();
        } else {
            for (EnvioACasa envio : envios) {
                if (envio.getIdParada() == parada.getIdParada()) {
                    double[] volumen = envio.getVolumen();
                    String vol = String.valueOf(volumen[0]) + " " + String.valueOf(volumen[1]) + " " + String.valueOf(volumen[2]);
                    String envioTXT = envio.getId() + " Peso: " + envio.getPeso() + " Volumen: " + vol + " Direccion: " + envio.getDireccion().getDireccion() + " Localidad: " + envio.getDireccion().getLocalidad() + "\n";
                    enviosTA.getItems().add(envioTXT);
                }
            }
        }}
}
