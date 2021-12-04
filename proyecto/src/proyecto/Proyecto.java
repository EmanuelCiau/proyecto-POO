/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.util.Scanner;

/**
 *
 * @author Domingo Ciau
 */
public class Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        GuardarDatos guarda=new GuardarDatos();
        VistaCliente vis1=new VistaCliente();
        VistaEmpleado vis=new VistaEmpleado();
        ControlCliente con=new ControlCliente(guarda, vis1);
        ControlEmpleado emple=new ControlEmpleado(vis, guarda);
        Scanner esc=new Scanner(System.in);
        
        boolean star=true;
        guarda.regresarClientes();
        int opcion=0;
        
        while(star){
            System.out.println("menu principal: ");
            System.out.println("1.-ingresar como cliente");
            System.out.println("2.-ingresar como empleado");
            System.out.println("3.-salir");

            opcion=esc.nextInt();
            switch(opcion){
                
                case 1: con.MenuCliente();break;
                
                case 2: emple.MenuEmpleado();break;
                
                case 3: star=false;break;
            } 
        }
        guarda.guardarClientes();
    }
    
}
