/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.poo;

/**
 *
 * @author Domingo Ciau
 */
public class Persona {
    private String nombre;
    private int edad;
    private String correo;
    private int telefono;

    //Constructor
    public Persona(){}
    public  Persona(String nom, int eda, String corr, int tel) {
        nombre=nom;
        edad=eda;
        correo=corr;
        telefono=tel;
    }
    
    //seters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    //geters
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getCorreo() {
        return correo;
    }
    public int getTelefono() {
        return telefono;
    }
}
