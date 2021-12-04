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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Domingo Ciau
 */
public class VistaClienteController implements Initializable {


    @FXML private Button aceptar1;
    @FXML private Button boton1;
    @FXML private Button boton2;
    @FXML private Button boton3;
    @FXML private Button boton4;
    @FXML private Button boton5;
    @FXML private Button boton6;
    @FXML private Button aceptar2;
    @FXML private Button aceptar3;
    @FXML private Button guardar1;
    @FXML private AnchorPane panelClient;
    @FXML private AnchorPane panelClient2;
    @FXML private TextField ingreso;
    @FXML private TextField cuenta;
    @FXML private TextField cuenta2;
    @FXML private TextField contraseña;
    @FXML private Label imprimir;
    @FXML private Label nombre;
    @FXML private Label saldo;
    private int lugarCli,pocTran=-1;
    
    GuardarDatos guardar=new GuardarDatos();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    @FXML
    private void boton1(ActionEvent event) {
        try {
            FXMLLoader cargar= new FXMLLoader(getClass().getResource("PantallaDeposito.fxml"));
            Parent root =cargar.load();
            
            Object vistaControl = cargar.getController();
            
            Scene scene = new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Mi banquito");
            stage.setScene(scene);

            stage.show();

            ((Stage)panelClient.getScene().getWindow()).close();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void boton2(ActionEvent event) {
        try {
            FXMLLoader cargar= new FXMLLoader(getClass().getResource("PantallaRetiro.fxml"));
            Parent root =cargar.load();
            
            Object vistaControl = cargar.getController();
            
            Scene scene = new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Mi banquito");
            stage.setScene(scene);

            stage.show();

            ((Stage)panelClient.getScene().getWindow()).close();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void boton3(ActionEvent event) {
        try {
            FXMLLoader cargar= new FXMLLoader(getClass().getResource("PantallaTrasferencia.fxml"));
            Parent root =cargar.load();
            
            Object vistaControl = cargar.getController();
            
            Scene scene = new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Mi banquito");
            stage.setScene(scene);

            stage.show();

            ((Stage)panelClient.getScene().getWindow()).close();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void boton4(ActionEvent event) {
        try {
            FXMLLoader cargar= new FXMLLoader(getClass().getResource("PantallaEstadoCuenta.fxml"));
            Parent root =cargar.load();
            
            Object vistaControl = cargar.getController();
            
            Scene scene = new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Mi banquito");
            stage.setScene(scene);

            stage.show();

            ((Stage)panelClient.getScene().getWindow()).close();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.nombre.setText(guardar.clientes.get(lugarCli).getNombre());
        this.saldo.setText(guardar.clientes.get(lugarCli).getSaldo()+ "");
    }
    @FXML
    private void boton5(ActionEvent event){
        try {
            FXMLLoader cargar= new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root =cargar.load();
            
            MenuController menuControl= cargar.getController();
            
            Scene scene = new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Mi banquito");
            stage.setScene(scene);
            
            stage.show();
            ((Stage)panelClient.getScene().getWindow()).close();
        } catch (IOException ex) {
            Logger.getLogger(VistaClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //((Stage)panelClient.getScene().getWindow()).close();
    }
    @FXML
    public void cerrarVentana() {
        try {
            FXMLLoader cargar= new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root =cargar.load();
            
            MenuController menuControl= cargar.getController();
            
            Scene scene = new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Mi banquito");
            stage.setScene(scene);
            
            stage.show();
            ((Stage)panelClient.getScene().getWindow()).close();
            /**Stage myStage= (Stage) this.boton5.getScene().getWindow();
            myStage.close();**/
        } catch (IOException ex) {
            Logger.getLogger(VistaClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void boton6(ActionEvent event) {
        try {
            FXMLLoader cargar= new FXMLLoader(getClass().getResource("VistaCliente.fxml"));
            Parent root =cargar.load();
            
            VistaClienteController vistaControl= cargar.getController();
            
            Scene scene = new Scene(root);
            Stage stage=new Stage();
            stage.setTitle("Mi banquito");
            stage.setScene(scene);

            stage.show();
            
            ((Stage)panelClient2.getScene().getWindow()).close();
        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void guardar1(ActionEvent event) {
        boolean respuesta;
        respuesta=comprobarCliente();
        respuesta=compContrasena(lugarCli);
        System.out.println("no entro");
        if(respuesta=true){
            try {
                FXMLLoader cargar= new FXMLLoader(getClass().getResource("VistaCliente.fxml"));
                Parent root =cargar.load();
            
                VistaClienteController vistaControl= cargar.getController();
            
                Scene scene = new Scene(root);
                Stage stage=new Stage();
                stage.setTitle("Mi banquito");
                stage.setScene(scene);

                stage.show();
            
                ((Stage)panelClient.getScene().getWindow()).close();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
  
    @FXML
    private void aceptar1(ActionEvent event) {
        boolean respuesta;
        respuesta=agregarDeposito();
        if(respuesta==true){
            this.imprimir.setText("Cliente no encontrado");
        }
        System.out.println(guardar.clientes.get(lugarCli).getSaldo());
        
    }
    @FXML
    private void aceptar2(ActionEvent event) {
        System.out.println(guardar.clientes.get(lugarCli).getNombre());
        boolean respuesta;
        respuesta=retirarDinero(lugarCli);
        if(respuesta==true){
        this.imprimir.setText("Cliente no encontrado");
        }
        
    }
    @FXML
    private void aceptar3(ActionEvent event) {
        boolean respuesta;
        respuesta=hacerTransferencia();
        if(respuesta==true){
        this.imprimir.setText("Cliente no encontrado");
        }
        System.out.println(guardar.clientes.get(lugarCli).getSaldo());
    }
    
    /**
     * metodo que pide el numero de cuenta conprueva si existe
     * retorna su pocion en el array
     * @return 
     */
    public boolean comprobarCliente(){
      
        int num=Integer.parseInt(this.cuenta2.getText());
        try{
            lugarCli=guardar.obtCliente(num); 
            noCliente(lugarCli);
            
        }catch(Expciones e){ 
            this.imprimir.setText("Cliente no encontrado");
            return true;
        }
        return false;
    }
    
    /**
     * metodo que pide la transferencia y la compruba 
     * @return 
     */
    public boolean comprobarClienteTras(){
        boolean respuesta=true;
        int num=Integer.parseInt(this.cuenta.getText());
        try{
            pocTran=guardar.obtCliente(num); 
            noCliente(pocTran);
        }catch(Expciones e){
            this.imprimir.setText("Cliente no encontrado");
            respuesta=false;
        } 
        return true;
    }
    
    /**
     * metodo que compruva la contraseña y la valida
     * @param posContrasena 
     */
    public boolean compContrasena(int posContrasena){
        boolean respuesta;
       
            int num=Integer.parseInt(this.contraseña.getText());
            try{
               respuesta=guardar.compContrasena(num,posContrasena); 
               comprobacionContraseña(respuesta);
            }catch(Expciones e){
                this.imprimir.setText("contraseña invalida");
                return true;
            }
            return false;
    }

    //Agregar deposito a la cuenta 
    public boolean agregarDeposito(){
        double a, b=0, c=guardar.clientes.get(lugarCli).getSaldo();
        System.out.println(guardar.clientes.get(lugarCli).getSaldo());
        try{
            b=Double.parseDouble(this.ingreso.getText());
            depositoIncorrrecto(b);
        }catch(Expciones ex){
            this.imprimir.setText("deposito incorrecto revise de nuevo");
            return false;
        }
        a=b+c;
        guardar.clientes.get(lugarCli).setSaldo(a);
        return true;
    }

    //Transferir
    public boolean hacerTransferencia(){
   
        int posTras=pocTran;
        Double a, b , c=0.0, d=guardar.clientes.get(lugarCli).getSaldo(), e=guardar.clientes.get(posTras).getSaldo();

        try{
            c=Double.parseDouble(this.ingreso.getText());
            depositoIncorrrecto(c);
        }catch(Expciones ex){
            this.imprimir.setText("Cantidad invalida");
            return false;
        }
        //Resta el valor que se le transfirio a la cuenta
        try{
            b = d-c;
            saldoInsuficiente(b);

            guardar.clientes.get(lugarCli).setSaldo(b);
        }catch(Expciones exp){
            this.imprimir.setText("saldo insuficiente en la cuenta");
            return false;
        }
        a = c+e; //Suma el valor a transferir a la cuenta que se quiere
        guardar.clientes.get(posTras).setSaldo(a);
        return true;
    }

    //Retirar Dinero
    public boolean retirarDinero(int cliente){

        Double a, b=0.0, c=guardar.clientes.get(cliente).getSaldo();
        
        try{
            b=Double.parseDouble(this.ingreso.getText());
            saldoInsuficiente(b);

        }catch(Expciones ex){
            this.imprimir.setText("retiro no valido");
            return false;
        }
        try{
            a=c-b;
            saldoInsuficiente(a);
            guardar.clientes.get(cliente).setSaldo(a);
        }catch(Expciones es){
            this.imprimir.setText("Saldo insuficiente");
            return false;
        }
        
        return true;
    }

    /**
     * metodo que crea una exepcio y la regresa
     * @param noCuenta
     * @throws Expciones 
     */
    public void noCliente(int noCuenta) throws Expciones{
       
        if(noCuenta==-1){
             throw new Expciones(); //lanza un exception
        } 
        
    }
    
    /**
     * metodo que comprueva que un deposito sea mayor a 0
     * @param dps
     * @throws Expciones 
     */
    public void depositoIncorrrecto(double dps) throws Expciones{
        
        if(dps<=0){
             throw new Expciones(); //lanza un exception
        }
        
    }
    
    /**
     * metodo que crea una exepcion si el cliente no cuenta con saldo suficiente
     * @param dps
     * @throws Expciones 
     */
    public void saldoInsuficiente(double dps) throws Expciones{
        
        if(dps<0){
             throw new Expciones(); //lanza un exception
        }
        
    }
    
    /**
     * metod que lanza un exepcion si tu contraseña no es correcta
     * @param con
     * @throws Expciones 
     */
    public void comprobacionContraseña(boolean con) throws Expciones{
        
        if(con==true){
             throw new Expciones(); //lanza un exception
        }
        
    }
    
}
