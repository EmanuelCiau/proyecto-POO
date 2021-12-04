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
public class VistaEmpleado {
    
    Scanner esc;
    /**
     * menu principal de la clase empleado
     * regresa la opcion que se eligio
     * @return 
     */
    public int menuEmpleado(){
        esc=new Scanner(System.in);
        System.out.println("1.-Agregar un nuevo cliente");
        System.out.println("2.-Agregar un nuevo empleado");
        System.out.println("3.-Borrar un cliente");
        System.out.println("4.-Cambiar contraseña");
        System.out.println("5.-Modificar datos Cliente");
        System.out.println("6.-Restablececer contraseña cliente");
        System.out.println("7.-Ver lista de clientes");
        System.out.println("8.-salir");
        return esc.nextInt();
    }
    
    //Pedir número de cuenta 
    public int pedirCuenta(){//envia un entero conocido como numero de cuenta.
        esc = new Scanner(System.in);
        System.out.println("Ingrese su numero de cuenta ");
        return esc.nextInt();
    } 
    
    /**
     * metodo que pide la contraseña y lo regresa
     * @return 
     */
    public int Contraseña(){
        esc = new Scanner(System.in);
        System.out.println("Ingrese su contraseña: ");
        return esc.nextInt();
    }
    
    /**
     * metodo que pide el nombre y lo regresa
     * @return 
     */
    public String pedirNombre(){
        esc = new Scanner(System.in);
        System.out.println("Ingrese el nombre: ");
        return esc.nextLine();
    }
     
    /**
     * metodo que pide la edad y la regresa
     * @return 
     */
    public int pedirEdad(){
        esc = new Scanner(System.in);
        System.out.println("ingrese la edad: ");
        return esc.nextInt();
    }
    
    /**
     * metodo que pide el correo y lo regresa
     * @return 
     */
    public String pedirCorreo(){
        esc = new Scanner(System.in);
        System.out.println("Ingrese el conrreo: ");
        return esc.nextLine();
    }
    
    /**
     * metodo que pide el numero de telefono y lo regresa
     * @return 
     */
    public int pedirTelefono(){
        esc = new Scanner(System.in);
        System.out.println("Ingrese el telefono: ");
        return esc.nextInt();
    }
    
    /**
     * metodo que pide el saldo del cliente y lo regresa
     * @return 
     */
    public double pedirSaldo(){
        esc = new Scanner(System.in);
        System.out.println("con cuanto decea inicar su cuenta: ");
        return esc.nextDouble();
    }
    
    /**
     * metodo que pide el puesto del empleado y lo regresa
     * @return 
     */
    public String pedirPuesto(){
        esc=new Scanner(System.in);
        System.out.println("ingrese el puesto: ");
        return esc.nextLine();
    }
    
    /**
     * metodo que pide el nombre del usuario y lo regresa
     * @return 
     */
    public String pedirUsuario(){
        esc=new Scanner(System.in);
        System.out.println("ingrese el usuario: ");
        return esc.nextLine();
    }
    
    /**
     * metodo que pide la nueba contraseña
     * @return 
     */
    public int cambiarContrasena(){
        esc=new Scanner(System.in);
        System.out.println("ingrese la nueva contraseña: ");
        return esc.nextInt();
    }
   
    
    
}
