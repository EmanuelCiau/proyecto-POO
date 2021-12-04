/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.poo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Domingo Ciau
 */
public class MenuController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button cliente;
    @FXML 
    private Button empleado;
    @FXML
    private AnchorPane panel;
    
    @FXML
    private void handleButtonAction(ActionEvent event){
        try {
            FXMLLoader cargar= new FXMLLoader(getClass().getResource("Contraseña_1.fxml"));
            Parent root =cargar.load();
            
            VistaClienteController vistaControl= cargar.getController();
            
            Scene scene = new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Mi banquito");
            stage.setScene(scene);
            //stage.initOwner(panel.getScene().getWindow());
            //((Stage)panel.getScene().getWindow()).close();
            stage.show();
            stage.setOnCloseRequest(e -> vistaControl.cerrarVentana());
            
            Stage myStage= (Stage) this.cliente.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void desplegarMenu(ActionEvent event) {
    }
    
}
