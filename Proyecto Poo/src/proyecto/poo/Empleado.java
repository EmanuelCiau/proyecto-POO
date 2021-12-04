/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.poo;

import java.io.Serializable;

/**
 *
 * @author Domingo Ciau
 */
public class Empleado extends Persona implements Serializable{
    private String usuario;
    private int contrasena,numEmpleado;
    private String puesto;
    private String historial;

    //constructores
    public Empleado(){}
    public Empleado(String nom, int eda, String corr, int tel,int num, String usua, int ctrs, String psto, String htral){
        super(nom, eda, corr, tel);
        numEmpleado=num;
        usuario=usua;
        contrasena=ctrs;
        puesto=psto;
        historial=htral;
    }

    //seters
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public void setHistorial(String historial) {
        this.historial = historial;
    }
    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }
    

    //geters 
    public String getUsuario() {
        return usuario;
    }
    public int getContrasena() {
        return contrasena;
    }
    public String getPuesto() {
        return puesto;
    }
    public String getHistorial() {
        return historial;
    }
    public int getNumEmpleado() {
        return numEmpleado;
    }
    
  
    @Override
    public String toString() {
        return "NOMBRE: "+getNombre()+"PUESTO: "+getPuesto()+"USUARIO: "+getUsuario()+"EDAD: "+getEdad()+"CORREO: "+getCorreo()+"TELEFONO: "+getTelefono();
    }
    
}
