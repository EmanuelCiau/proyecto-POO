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
public class Cliente extends Persona implements Serializable{
    private int noCuenta,contrasena;
    private Double saldo;
    private String historal,reciente;

    //constructor
    public Cliente(){}
    public Cliente(String nom, int eda, String corr, int tel, int no, int ctr, Double sldo, String his, String rcts){
        super(nom,eda,corr,tel);
        noCuenta=no;
        contrasena=ctr;
        saldo=sldo;
        historal=his;
        reciente=rcts;
    }

     //seters
    public void setNoCuenta(int noCuenta) {
        this.noCuenta = noCuenta;
    }
    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public void setHistoral(String historal) {
        this.historal = historal;
    }public void setReciente(String reciente) {
        this.reciente = reciente;
    }

    //geters
    public int getNoCuenta() {
        return noCuenta;
    }
    public int getContrasena() {
        return contrasena;
    }
    public Double getSaldo() {
        return saldo;
    }
    public String getHistoral() {
        return historal;
    }
    public String getReciente() {
        return reciente;
    }

    @Override
    public String toString() {
        return "NOMBRE: "+getNombre()+"EDAD: "+getEdad()+"CORREO: "+getCorreo()+"TELEFONO: "+getTelefono()+"NUMERO CUENTA: "+getNoCuenta();
    }

}
