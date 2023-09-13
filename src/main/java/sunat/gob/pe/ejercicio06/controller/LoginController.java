/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.ejercicio06.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sunat.gob.pe.ejercicio06.App;
import sunat.gob.pe.ejercicio06.model.dao.IAlumnoDao;
import sunat.gob.pe.ejercicio06.model.dao.impl.AlumnoDaoImpl;
import sunat.gob.pe.ejercicio06.model.entities.Alumno;
import sunat.gob.pe.ejercicio06.model.entities.Usuario;

/**
 * FXML Controller class
 *
 * @author Aldo Malaver
 */
public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    public void autenticarUsuario(ActionEvent actionEvent) throws IOException {

        if(validarDatos()){
            IAlumnoDao alumnoDao = new AlumnoDaoImpl();
            Alumno alumno = new Alumno(0L, "Aldo", "Malaver", 
                    "Masculino", "Avenida ABC",
            "almalaver@gmail.com", 1);
            
            alumnoDao.guardarAlumno(alumno);
            FXMLLoader loader =  App.getFXMLLoader("dashboard");
            Parent dashboard = loader.load();
            App.scene.setRoot(dashboard);
            DashboardController dashboardController = loader.<DashboardController>getController();
            dashboardController.setMensaje(txtUsuario.getText());            
            App.scene.getStylesheets().add(App.class.getResource("styles.css").toExternalForm());
        }  
       
    }
    
    private boolean validarDatos(){
        
         if (txtUsuario.getText().isEmpty()) {
            System.out.println("Ingrese usuario válido");
            return false;
        }

        if (txtPassword.getText().isEmpty()) {
            System.out.println("Ingrese password válido");
            return false;
        }

        List<Usuario> listaUsuarios = devolverListaUsuarios();

        //do while, while, for, for each
        //int i = 0;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUsuario().equals(txtUsuario.getText())
                    && usuario.getPassword().equals(txtPassword.getText())) {
                System.out.println("Credenciales válidas");
                return true;
            }
        }       
        
        System.out.println("Credenciales inválidas");     
        return false;
    }
    
    

    private List<Usuario> devolverListaUsuarios() {

        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario("amalaver", "abcd.1234"));
        listaUsuarios.add(new Usuario("pcruz", "45fdgdfds**2"));
        listaUsuarios.add(new Usuario("despinoza", "345dd3wj"));
        listaUsuarios.add(new Usuario("mherrera", "dsjnsjd234"));

        return listaUsuarios;
    }

}
