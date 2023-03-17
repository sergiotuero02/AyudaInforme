package com.example.PeregrinosFX.service.impl;

import com.example.PeregrinosFX.Connections.ConexBD;
import com.example.PeregrinosFX.bean.*;
import com.example.PeregrinosFX.repository.CarnetRepository;
import com.example.PeregrinosFX.repository.RepositorioMongo;
import com.example.PeregrinosFX.repository.UserRespository;
import com.example.PeregrinosFX.service.CarnetService;
import com.example.PeregrinosFX.service.UserService;
import javafx.scene.control.Alert;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarnetServiceImpl implements CarnetService {

    @Autowired
    private CarnetRepository carnetRespository;

    @Autowired
    private RepositorioMongo mongoRepository;

    public static File exportarCarnet(Peregrino p){
        String path = p.getIdPeregrino() + "_" + p.getNombre() + "peregrino.xml";
        Carnet c = p.getCarnet();
        File f = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbuilder = dbf.newDocumentBuilder();
            DOMImplementation implement = dbuilder.getDOMImplementation();

            Document doc = implement.createDocument(null, "carnet", null);
            Element carnet = doc.getDocumentElement();

            doc.setXmlVersion("1.0");

            Element id = doc.createElement("id");
            Text idValue;
            carnet.appendChild(id);
            idValue = doc.createTextNode(String.valueOf(p.getIdPeregrino()));
            id.appendChild(idValue);
            /*
             * Element fechaexp = doc.createElement("fechaExpedicion"); Text fechaexpValue;
             * carnet.appendChild(fechaexp); fechaexpValue = doc.createTextNode(
             * p.getCarnet().getFechaExpedicion().format(DateTimeFormatter.ofPattern(
             * "dd/MM/yyyy"))); fechaexp.appendChild(fechaexpValue);
             */
            Element paradaInicial = doc.createElement("paradaInicial");
            Text paradaInicialValue;
            carnet.appendChild(paradaInicial);
            paradaInicialValue = doc.createTextNode(String.valueOf(c.getParadaInicial()));
            paradaInicial.appendChild(paradaInicialValue);

            Element peregrino = doc.createElement("peregrino");
            carnet.appendChild(peregrino);

            Element nombrePeregrino = doc.createElement("nombre");
            Text nombreValue;
            peregrino.appendChild(nombrePeregrino);
            nombreValue = doc.createTextNode(p.getNombre());
            nombrePeregrino.appendChild(nombreValue);

            Element nacionalidad = doc.createElement("nacionalidad");
            Text nacionalidadValue;
            peregrino.appendChild(nacionalidad);
            nacionalidadValue = doc.createTextNode(p.getNacionalidad());
            nacionalidad.appendChild(nacionalidadValue);

            Element hoy = doc.createElement("hoy");
            Text fechaActualValue;
            carnet.appendChild(hoy);
            fechaActualValue = doc
                    .createTextNode(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            hoy.appendChild(fechaActualValue);

            Element distanciaTotal = doc.createElement("distanciaTotal");
            Text distanciaTotalValue;
            carnet.appendChild(distanciaTotal);
            distanciaTotalValue = doc.createTextNode(String.valueOf(p.getCarnet().getDistancia()));
            hoy.appendChild(distanciaTotalValue);

            Element estancias = doc.createElement("estancias");
            peregrino.appendChild(estancias);

            if (p.getEstancias() == null) {
                Element estancia = doc.createElement("estancia");
                Text estanciaValue;
                estancias.appendChild(estancia);
                estanciaValue = doc.createTextNode("no hay estancias");
                estancia.appendChild(estanciaValue);
            }

            if (p.getEstancias() != null) {

                for (Estancia e : p.getEstancias()) {
                    Element estancia = doc.createElement("estancia");
                    estancias.appendChild(estancia);


                    Element estanciaID = doc.createElement("idEstancia");
                    Text idEstValue;
                    estancia.appendChild(estanciaID);
                    idEstValue = doc.createTextNode(String.valueOf(e.getIdEstancia()));
                    estanciaID.appendChild(idEstValue);

                    Element fechaEstancia = doc.createElement("fechaEstancia");
                    Text fechaEstaValue;
                    estancia.appendChild(fechaEstancia);
                    fechaEstaValue = doc
                            .createTextNode(e.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    fechaEstancia.appendChild(fechaEstaValue);

                    Element estanciaVip = doc.createElement("vip");
                    Text estanciaVipValue;
                    estancia.appendChild(estanciaVip);
                    estanciaVipValue = doc.createTextNode(String.valueOf(e.isVip()));
                    estanciaVip.appendChild(estanciaVipValue);

                    Element parada = doc.createElement("parada");
                    Text paradaValue;
                    estancia.appendChild(parada);
                    paradaValue = doc.createTextNode(String.valueOf(e.getParada()));
                    parada.appendChild(paradaValue);

                }
            }

            Source fuente = new DOMSource(doc);
            f = new File(path);
            StreamResult resultado = new StreamResult(f);
            TransformerFactory fabricaTransformador = TransformerFactory.newInstance();
            Transformer transformador = fabricaTransformador.newTransformer();
            transformador.transform(fuente, resultado);
        } catch (ParserConfigurationException e) {
            System.out.println("Se ha producido una ParseConfigurationException: " + e.getMessage());
        } catch (TransformerConfigurationException e) {
            System.out.println("Se ha producido una TransformerConfigurationException e: " + e.getMessage());
        } catch (TransformerException e) {
            System.out.println("Se ha producido una TransformerException: " + e.getMessage());
        }
        return f;
    }

    public void backup() throws JRException {
        ArrayList<Carnet> carnets  = (ArrayList<Carnet>) findAll();
        ArrayList<String> carnetsBackup = new ArrayList<String>();
        for(Carnet c : carnets){
            carnetsBackup.add(c.toString());
        }
        String fileName = "backupcarnets " + LocalDate.now();
        CarnetBackup carnetBackup = new CarnetBackup();
        carnetBackup.setFileName(fileName);
        carnetBackup.setCarnetsBackup(carnetsBackup);
        mongoRepository.save(carnetBackup);
        JasperReport carnetsReport = JasperCompileManager.compileReport ("carnets.jrxml");
        JasperPrint informe = JasperFillManager.fillReport(carnetsReport,null, ConexBD.getCon());
        JasperExportManager.exportReportToPdfFile (informe, "carnets.pdf");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ÉXITO!");
        alert.setContentText("Copia de seguridad guardada exitosamente");
        alert.show();
    }

    @Override
    public Carnet save(Carnet entity) {
        return null;
    }

    @Override
    public Carnet update(Carnet entity) {
        return null;
    }

    @Override
    public void delete(Carnet entity) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteInBatch(List<Carnet> entities) {

    }

    @Override
    public Carnet find(Long id) {
        return null;
    }

    @Override
    public List<Carnet> findAll() {
        return carnetRespository.findAll();
    }

    @Override
    public Carnet addCarnet(Carnet carnet) {
        return carnetRespository.save(carnet);
    }
}
