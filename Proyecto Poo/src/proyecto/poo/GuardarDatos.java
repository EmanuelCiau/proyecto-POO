/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.poo;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Domingo Ciau
 */
public class GuardarDatos {
    
    ArrayList <Cliente> clientes=new ArrayList <Cliente>();
    ArrayList <Empleado> empleado=new ArrayList<Empleado>();

    Cliente cli=new Cliente("ema", 20, "ema", 55, 6555, 33, 300.0, "", "");
    Empleado emp=new Empleado("juan", 24, "arturo", 6565,334, "Emmanel",4567, "","");
    //Buscar cuenta
    public int obtCliente(int cuenta){//esta funcion encuenta el numero en el que se aloja un cliente apartir de su numero de cuenta
        clientes.add(cli);
        empleado.add(emp);
        for (int i=0; i<clientes.size(); i++){
            if(cuenta == clientes.get(i).getNoCuenta()){
                return i;
            } 
        } return -1;
    }
    
    //validar la contraseña
    public boolean compContrasena(int contrasena, int pconContrasena){
        if(contrasena == clientes.get(pconContrasena).getContrasena()){
            return false;
        } 
        return true;
    }
    
    public void guardarClientes(){
     
        try {
            FileOutputStream salida=new FileOutputStream("archivo.txt");
            ObjectOutputStream flujo=new ObjectOutputStream(salida);
            flujo.writeObject(clientes);
            flujo.writeObject(empleado);
            flujo.close();
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }

    public void regresarClientes() throws ClassNotFoundException {
        clientes.clear();
        empleado.clear();
        try {
            FileInputStream entrada=new FileInputStream("archivo.txt");
            ObjectInputStream flujoEntrada=null;
            flujoEntrada=new ObjectInputStream(entrada);
            while(flujoEntrada!=null){
                clientes=(ArrayList <Cliente>)flujoEntrada.readObject();
                empleado=(ArrayList <Empleado>)flujoEntrada.readObject();
            }
            entrada.close();
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
    }
    
    public int obtEmpleado(int cuenta){//esta funcion encuenta el numero en el que se aloja un cliente apartir de su numero de cuenta
        for (int i=0; i<empleado.size(); i++){
            if(cuenta == empleado.get(i).getNumEmpleado()){
                return i;
            } 
        } return -1;
    }
    
    //validar la contraseña
    public boolean compContrasenaEmp(int contrasena, int pconContrasena){
        if(contrasena == empleado.get(pconContrasena).getContrasena()){
            return false;
        } 
        return true;
    }
    
    public void agregarClient(Cliente cli){
        clientes.add(cli);
    }
    
    public boolean cliente(int cuenta){
        for(int i=0; i<clientes.size(); i++){
            if(clientes.get(i).getNoCuenta()==cuenta){
                return true;
            }
        }return false;
    }
   
    public boolean empleado(int numEmpleado){
        for(int i=0; i<empleado.size(); i++){
            if(empleado.get(i).getNumEmpleado()==numEmpleado){
                return true;
            }
        }return false;
    }
    
    public void agregarEmpleado(Empleado emp){
        empleado.add(emp);
    }
    
    public void borrarClient(int client){
        clientes.remove(client);
    }
}
