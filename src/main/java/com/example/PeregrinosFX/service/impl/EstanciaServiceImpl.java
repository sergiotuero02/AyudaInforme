package com.example.PeregrinosFX.service.impl;

import com.example.PeregrinosFX.bean.*;
import com.example.PeregrinosFX.config.StageManager;
import com.example.PeregrinosFX.repository.EstanciaRepository;
import com.example.PeregrinosFX.service.CarnetService;
import com.example.PeregrinosFX.service.EstanciaService;
import com.example.PeregrinosFX.service.PeregrinoService;
import com.example.PeregrinosFX.view.FxmlView;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.PeregrinosFX.bean.Servicio.db;
import static com.example.PeregrinosFX.controller.LoginController.rol;

@Service
public class EstanciaServiceImpl implements EstanciaService {

    @Lazy
    @Autowired
    private StageManager stageManager;

    @Autowired
    private EstanciaRepository estanciaRepository;

    @Autowired
    private EstanciaService estanciaService;

    @Autowired
    private PeregrinoService peregrinoService;

    @Autowired
    private CarnetService carnetService;

    public static Parada paradaEnvio;

    /*
    * Finalmente este método solo añade un campo a la tabal peregrino/parada, no fui capaz de gestionar el alojamineto completo
    * desde aquí por fallos que no pude arreglar, de forma que lo temriné desde el propio controlador, aunque no sea lo óptimo, funciona
    **/
    public void alojarse(Peregrino peregrinoCB, Parada paradaCB) {
            List<Parada> paradasPeregrino = peregrinoCB.getParadas();
            paradasPeregrino.add(paradaCB);
            peregrinoCB.setParadas(paradasPeregrino);
            peregrinoService.addPeregrino(peregrinoCB);
            peregrinoCB.getCarnet().setDistancia(peregrinoCB.getCarnet().getDistancia()+100);

    }

    public void alojar(Peregrino peregrino, Parada parada, CheckBox estanciaCheck, CheckBox vipCB, TableView servicioTB, ComboBox pagosCB, TextField extraTF, Label totalLBL){

        boolean envio = false;

        try {
            //Llamamos al método alojarse que nos va añadir un campo a la tabla peregrino_parada con el peregrino y la parada seleccionados
            //!Este método nos permite añadir varias veces la misma combinación peregrino parada! por lo que un peregrino puede realizar la misma parada varias veces
            alojarse(peregrino, parada);

            //Si hay una estancia la añadiremos, diferenciando si es vip o no
            if (estanciaCheck.isSelected()) {
                Estancia e = new Estancia();
                if (vipCB.isSelected()) {

                    peregrino.getCarnet().setNumVips(peregrino.getCarnet().getNumVips() + 1);

                    e.setVip(true);
                    e.setFecha(LocalDate.now());
                    e.setParada(parada);
                    e.setPeregrino(peregrino);

                }
                if (!vipCB.isSelected()) {

                    e.setVip(false);
                    e.setFecha(LocalDate.now());
                    e.setParada(parada);
                    e.setPeregrino(peregrino);

                }
                if (servicioTB.getItems().size() > 0) {
                    if (pagosCB.getSelectionModel().getSelectedItem().equals(null)) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setHeaderText(null);
                        alert.setContentText("Introduzca un método de pago");
                        alert.showAndWait();
                    } else {
                        ArrayList<Servicio> servicios = new ArrayList<Servicio>();
                        for (Object o : servicioTB.getItems()) {
                            Servicio s = (Servicio) o;
                            servicios.add(s);
                        }


                        ConjuntoContratado cc = new ConjuntoContratado();
                        cc.setEstancia(e);
                        cc.setExtra(extraTF.getText());
                        cc.setServicios(servicios);
                        cc.setPrecioTotal(Double.parseDouble(totalLBL.getText()));
                        cc.setModoPago(pagosCB.getSelectionModel().getSelectedItem().toString().charAt(0));
                        paradaEnvio = parada;
                        for (Servicio s : cc.getServicios()) {
                            if (s.getNombre().equals("Envio a casa")) {
                                envio = true;
                            } else {
                                envio = false;
                            }
                        }
                        db.store(cc);

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Conjunto contratado");
                        alert.setHeaderText(null);
                        alert.setContentText("Se le ha asignado el paquete de servicios " + cc);
                        alert.showAndWait();

                    }
                } else {
                    addEstancia(e);
                    carnetService.addCarnet(peregrino.getCarnet());
                }
                //Mostramos un mensaje informando del éxito de la operación
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Peregrino alojado");
                alert.setHeaderText(null);
                alert.setContentText("El peregrino " + peregrino.getNombre() + " ha realizado la parada correctamente.");
                alert.showAndWait();
                if (envio) {
                    stageManager.switchScene(FxmlView.ENVIO);
                } else {
                    if (rol == 2) {
                        stageManager.switchScene(FxmlView.MENUADMINPARADA);
                    }
                    if (rol == 3) {
                        stageManager.switchScene(FxmlView.MENUADMINGENERAL);
                    }
                }
            }

        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Introduzca todos los campos");
            alert.setHeaderText(null);
            alert.setContentText("Introduzca todos los campos");
            alert.show();
        }
    }

    @Override
    public Estancia save(Estancia entity) {
        return null;
    }

    @Override
    public Estancia update(Estancia entity) {
        return null;
    }

    @Override
    public void delete(Estancia entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteInBatch(List<Estancia> entities) {

    }

    @Override
    public Estancia find(Long id) {
        return null;
    }

    @Override
    public List<Estancia> findAll() {
        return estanciaRepository.findAll();
    }

    @Override
    public Estancia addEstancia(Estancia estancia) {
        return estanciaRepository.save(estancia);
    }

    @Override
    public ArrayList<Estancia> findByParada(Parada parada) {
        return estanciaRepository.findByParada(parada);
    }

}
