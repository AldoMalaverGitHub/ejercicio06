/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.ejercicio06.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sunat.gob.pe.ejercicio06.model.entities.Alumno;

/**
 * FXML Controller class
 *
 * @author Aldo Malaver
 */
public class ProductosController implements Initializable {

    @FXML
    private TableView<Alumno> alumnoTable;
    
    @FXML
    private TableColumn<Alumno, Long> idColumn;
    
    @FXML
    private TableColumn<Alumno, String> nombresColumn;
    
    @FXML
    private TableColumn<Alumno, String> apellidosColumn;
    
    @FXML
    private TableColumn<Alumno, String> emailColumn;
    
    @FXML
    private TableColumn<Alumno, String> estadoColumn;
    
    private ObservableList<Alumno> alumnoData = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       alumnoTable.setItems(alumnoData);
       
       idColumn.setCellValueFactory(rowData -> rowData.getValue().getIdAlumno1());
       
    }    
    
}
