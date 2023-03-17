package com.example.PeregrinosFX.service.impl;

import com.example.PeregrinosFX.bean.Parada;
import com.example.PeregrinosFX.bean.Servicio;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static com.example.PeregrinosFX.bean.Servicio.db;

public class ServicioServiceImpl {

public static void cargarServicios(ComboBox serviciosCB){
    Servicio servicio = new Servicio();
    for (Object s : db.queryByExample(servicio)) {
        serviciosCB.getItems().add((Servicio)s);
    }
}


    public static void addServicio(TextField nombreTF, TextField precioTF, TableView paradaTB){

        Servicio s = new Servicio();
        int contador = 0;
        for (Object o : db.queryByExample(s)){
            if (nombreTF.getText().equalsIgnoreCase(((Servicio) o).getNombre())) {
                contador++;
            }
        }
        ArrayList<Long> paradasSer = new ArrayList<>();
        for (int i = 0; i < paradaTB.getItems().size(); i++) {
            paradasSer.add(((Parada) paradaTB.getItems().get(i)).getIdParada());
        }

        if(contador != 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("El servicio ya existe");
            alert.show();
        }
        else if (nombreTF.getText().equals("") || precioTF.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Introduzca el nombre y el precio");
            alert.show();

        } else {
            try {
                s.setPrecio(Double.parseDouble(precioTF.getText()));
                s.setNombre(nombreTF.getText());

                s.setIdParadas(paradasSer);
                db.store(s);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SERVICIO AÑADIDO");
                alert.setContentText("SERVICIO AÑADIDO EXITOSAMENTE");
                alert.show();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Introduzca un número en el precio");
                alert.show();
            }


        }

    }

    public static void editarServicio(TextField nombreTF, TextField precioTF, TableView paradaTB, Servicio servicio){

        ArrayList<Long> paradasSel = new ArrayList<Long>();
        for (Object o : paradaTB.getItems()) {
            paradasSel.add(((Parada) o).getIdParada());
        }

        Servicio s = new Servicio();
        int contador = 0;
        for (Object o : db.queryByExample(s)) {
            if (nombreTF.getText().equalsIgnoreCase(((Servicio) o).getNombre()) && !nombreTF.getText().equalsIgnoreCase(servicio.getNombre())) {
                contador++;
            }
        }
        if (contador != 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("El servicio ya existe");
            alert.show();
        } else if (nombreTF.getText().equals("") || precioTF.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Introduzca el nombre y el precio");
            alert.show();
            db.close();
        } else {
            try {
                servicio.setNombre(nombreTF.getText());
                servicio.setPrecio(Double.parseDouble(precioTF.getText()));
                servicio.setIdParadas(paradasSel);
                db.store(servicio);
                db.commit();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("SERVICIO EDITADO");
                alert.setContentText("SERVICIO EDITADO EXITOSAMENTE");
                alert.show();
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Introduzca un número en el precio");
                alert.show();
            }
        }
    }
}
