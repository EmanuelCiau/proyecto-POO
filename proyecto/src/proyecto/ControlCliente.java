/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Domingo Ciau
 */
public class ControlCliente {

    GuardarDatos guardar;
    VistaCliente vista;
    
    public ControlCliente(GuardarDatos guar, VistaCliente vis) {
        guardar=guar;
        vista=vis;
    }
    
    

    //Menu 
    public void MenuCliente(){
        int posCuenta=comprobarCliente();
        compContrasena(posCuenta);
        Integer opcion = 0;

        while(opcion != 6){
            switch(vista.Menu()){
                case 1 :  agregarDeposito(posCuenta);break;
                
                case 2 : retirarDinero(posCuenta);break;
                
                case 3 : Integer aux1, aux2; 
                aux1 = posCuenta;  
                aux2 = comprobarClienteTras();
                hacerTransferencia(aux1, aux2);break;
                
                case 4 : break;
                
                case 5 : opcion = 6; break;
            }
        }
    }
    
    /**
     * metodo que pide el numero de cuenta conprueva si existe
     * retorna su pocion en el array
     * @return 
     */
    public int comprobarCliente(){
        boolean respuesta=true;
        int posCli=0;
        while(respuesta){
            try{
               posCli=guardar.obtCliente(vista.pedirCuenta()); 
               noCliente(posCli);
               respuesta=false;
            }catch(Expciones e){ 
                System.out.println("Cliente no encontrado");
                System.out.println("intentelo de nuevo");
                respuesta=true;
            } 
        }
        return posCli;
    }
    
    /**
     * metodo que pide la transferencia y la compruba 
     * @return 
     */
    public int comprobarClienteTras(){
        boolean respuesta=true;
        int posCli=0;
        while(respuesta){
            try{
               posCli=guardar.obtCliente(vista.cuentaQueRecibeTransferecia()); 
               noCliente(posCli);
               respuesta=false;
            }catch(Expciones e){ 
                System.out.println("Cliente no encontrado");
                System.out.println("intentelo de nuevo");
                respuesta=true;
            } 
        }
        return posCli;
    }
    
    /**
     * metodo que compruva la contraseña y la valida
     * @param posContrasena 
     */
    public void compContrasena(int posContrasena){
        boolean respuesta=true;
        while(respuesta){
            try{
               respuesta=guardar.compContrasena(vista.Contraseña(),posContrasena); 
               comprobacionContraseña(respuesta);
            }catch(Expciones e){ 
                System.out.println("contraseña invalida");
            } 
        }
    }

    //Agregar deposito a la cuenta 
    public void agregarDeposito(int cliente){
        boolean respuesta=true;
        Double a, b=0.0, c=guardar.clientes.get(cliente).getSaldo();
        
        while(respuesta){
            try{
                b=vista.pedirDeposito();
                depositoIncorrrecto(b);
                respuesta=false;
            }catch(Expciones ex){
                System.out.println("deposito incorrecto revise de nuevo");
                respuesta=true;
            }
        }
        a=b+c;
        guardar.clientes.get(cliente).setSaldo(a);
    }

    //Transferir
    public void hacerTransferencia(int cliente1, int cliente2){
        boolean respuesta=true;
        Double a, b , c=0.0, d=guardar.clientes.get(cliente1).getSaldo(), e=guardar.clientes.get(cliente2).getSaldo();
        while(respuesta){
            
            try{
                c=vista.pedirTransferencia();
                depositoIncorrrecto(c);
                respuesta=false;
            }catch(Expciones ex){
                System.out.println("Cantidad invalida");
                respuesta=true;
            }
            //Resta el valor que se le transfirio a la cuenta
            try{
                b = d-c;
                saldoInsuficiente(b);
                respuesta=false;
                guardar.clientes.get(cliente1).setSaldo(b);
            }catch(Expciones exp){
                System.out.println("saldo insuficiente en la cuenta");
                respuesta=true;
            }
        }
        a = c+e; //Suma el valor a transferir a la cuenta que se quiere
        guardar.clientes.get(cliente2).setSaldo(a);
    }

    //Retirar Dinero
    public void retirarDinero(int cliente){
        boolean respuesta=true;
        Double a, b=0.0, c=guardar.clientes.get(cliente).getSaldo();
        
        while(respuesta){
            try{
                b=vista.pedirRetiro();
                saldoInsuficiente(b);
                respuesta=false;
            }catch(Expciones ex){
                System.out.println("retiro no valido");
                respuesta=true;
            }
            try{
                a=c-b;
                saldoInsuficiente(a);
                guardar.clientes.get(cliente).setSaldo(a);
                respuesta=false;
            }catch(Expciones es){
                System.out.println("Saldo insuficiente");
                respuesta=true;
            }
        }
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
