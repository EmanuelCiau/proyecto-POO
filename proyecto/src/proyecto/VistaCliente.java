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
public class VistaCliente {
    
    
    Scanner lectura;

    //Menu de opciones para el cliente
    public Integer Menu(){
        lectura = new Scanner(System.in);

        System.out.println("---MENÚ---");
        System.out.println();
        System.out.println("1-Realizar deposito");
        System.out.println("2-Realizar retiro");
        System.out.println("3-Realizar transferencia");
        System.out.println("4-Consultar estado de cuenta");
        System.out.println("5-Salir");
        System.out.print("Opción: ");

        return lectura.nextInt();
    }
    
    //Deposito 
    public Double pedirDeposito(){//pide la cantidad a depositar y la envia
       lectura = new Scanner(System.in); 
        System.out.println("Cantidad a depositar:");
        return lectura.nextDouble();
    }

    //Retiro
    public Double pedirRetiro(){//pide la cantidad a retirar y la envia
       lectura = new Scanner(System.in); 
        System.out.println("Cantidad a retirar:");
        return lectura.nextDouble();
    }
    
    //Transferencia
    public Double pedirTransferencia(){//pide la cantidad a transferir
        lectura = new Scanner(System.in); 
         System.out.println("Cantidad a transferir:");
         return lectura.nextDouble();
     }    

    //Pedir número de cuenta 
    public int pedirCuenta(){//envia un entero conocido como numero de cuenta.
        lectura = new Scanner(System.in);
        System.out.println("Ingrese su numero de cuenta ");
        return lectura.nextInt();
    } 

    //Pedir número de cuenta que recibira la transferencia
    public int cuentaQueRecibeTransferecia(){//envia un entero conocido como numero de cuenta.
        lectura = new Scanner(System.in);
        System.out.println("Ingrese el número de cuenta que recibe la transferencia:");
        return lectura.nextInt();
    } 
    
    public int Contraseña(){
        lectura = new Scanner(System.in);
        System.out.println("Ingrese su contraseña: ");
        return lectura.nextInt();
    }
    
}
