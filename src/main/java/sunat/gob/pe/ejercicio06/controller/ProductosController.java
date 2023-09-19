/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.ejercicio06.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sunat.gob.pe.ejercicio06.controller.enums.EstadoEnum;
import sunat.gob.pe.ejercicio06.model.dao.IAlumnoDao;
import sunat.gob.pe.ejercicio06.model.dao.impl.AlumnoDaoImpl;
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

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnGuardar;

    private ObservableList<Alumno> alumnoData = FXCollections.observableArrayList();

    private Alumno alumnoActual = new Alumno(0L, "", "", "", "", "", 0);

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        enlazarTabla();
        llenarDatosEnTabla();
        seleccionarElementoDeTabla();

    }

    private void seleccionarAlumno(Alumno alumnoNuevo) {
        if (alumnoNuevo != null) {
            alumnoActual.setIdAlumno(alumnoNuevo.getIdAlumno());
            alumnoActual.setNombres(alumnoNuevo.getNombres());
            alumnoActual.setApellidos(alumnoNuevo.getApellidos());
            alumnoActual.setDireccion(alumnoNuevo.getDireccion());
            alumnoActual.setSexo(alumnoNuevo.getSexo());
            alumnoActual.setCorreo(alumnoNuevo.getCorreo());
            alumnoActual.setEstado(alumnoNuevo.getEstado());
        } else {
            alumnoActual = new Alumno(0L, "", "", "", "", "", 0);
        }
    }

    private void enlazarTabla() {
        alumnoTable.setItems(alumnoData);
        txtNombres.textProperty().bindBidirectional(alumnoActual.getNombres1());
        txtApellidos.textProperty().bindBidirectional(alumnoActual.getApellidos1());
        txtEmail.textProperty().bindBidirectional(alumnoActual.getCorreo1());

        idColumn.setCellValueFactory(rowData -> rowData.getValue().getIdAlumno1());
        nombresColumn.setCellValueFactory(rowData -> rowData.getValue().getNombres1());
        apellidosColumn.setCellValueFactory(rowData -> rowData.getValue().getApellidos1());
        emailColumn.setCellValueFactory(rowData -> rowData.getValue().getCorreo1());

        estadoColumn.setCellValueFactory(rowData -> new SimpleStringProperty(
                EstadoEnum.getStringValueFromInt(rowData.getValue().getEstado())));
    }

    private void llenarDatosEnTabla() {        
        IAlumnoDao alumnoDao = new AlumnoDaoImpl();
        alumnoData.addAll(alumnoDao.listarAlumno());
    }

    private void seleccionarElementoDeTabla() {
        alumnoTable.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Alumno> ov, Alumno alumnoAntiguo, Alumno alumnoNuevo) -> {
            seleccionarAlumno(alumnoNuevo);
            StringBinding btnGuardarText = new StringBinding() {
                @Override
                protected String computeValue() {
                    if (alumnoActual.getIdAlumno() == 0L) {
                        return "Guardar";
                    }
                    return "Actualizar";
                }
            };
            btnGuardar.textProperty().bind(btnGuardarText);
        });
    }

    public void guardarAlumno(ActionEvent event) {
        if (alumnoActual.getIdAlumno() == 0L) {
            if (alumnoActual.getNombres().isEmpty()) {
                mostrarAlertas("Warning", "Ingrese nombres", Alert.AlertType.WARNING);
                return;
            }

            if (alumnoActual.getApellidos().isEmpty()) {
                mostrarAlertas("Warning", "Ingrese Apellidos", Alert.AlertType.WARNING);    
                return;
            }

            if (alumnoActual.getCorreo().isEmpty()) {
                mostrarAlertas("Warning", "Ingrese Correo", Alert.AlertType.WARNING);
                return;
            }

            alumnoActual.setEstado(EstadoEnum.ACTIVO.getValor());
            IAlumnoDao alumnoDao = new AlumnoDaoImpl();
            alumnoDao.guardarAlumno(alumnoActual);
            mostrarAlertas("Informacion", "Se guardo exitosamente", Alert.AlertType.INFORMATION);
            llenarDatosEnTabla();
        }
    }
    
    private void mostrarAlertas(String header, String content, Alert.AlertType type){
        Alert dialogo = new Alert(type);        
        dialogo.setHeaderText(header);
        dialogo.setContentText(content);
        dialogo.show();
    }

}
