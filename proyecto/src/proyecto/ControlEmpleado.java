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
public class ControlEmpleado {
    VistaEmpleado vis;
    GuardarDatos guarda;

    public ControlEmpleado(VistaEmpleado vis, GuardarDatos guarda) {
        this.vis = vis;
        this.guarda = guarda;
    }
    Cliente cli;
    Empleado emp;
    
    //Menu 
    public void MenuEmpleado(){
        int posCuenta=comprobarEmpleado();
        compContrasenaEmp(posCuenta);
        Integer opcion = 0;

        while(opcion != 6){
            switch(vis.menuEmpleado()){
                case 1 : agregarCliente(); break;
                
                case 2 : agregarEmpleado();break;
                
                case 3 : borrarCliente(); break;
                
                case 4 : cambiarContrasena(posCuenta);break;
                
                case 5:  modificarClient(comprobarCliente());break;
                
                case 6:  cambiarContrasenaCliente(comprobarCliente());break;
                
                case 7:  break;
                
                case 8 : opcion = 6; break;
            }
        }
    }
    
    /**
     * reste metodo revicisa el elmpleado y lo cotega con los datos para encontrarlo 
     * @return 
     */
    public int comprobarEmpleado(){
        boolean respuesta=true;
        int posEmple=0;
        while(respuesta){
            try{
               posEmple=guarda.obtEmpleado(vis.pedirCuenta()); 
               noCliente(posEmple);
               respuesta=false;
            }catch(Expciones e){ 
                System.out.println("Empleado no encontrado");
                System.out.println("intentelo de nuevo");
                respuesta=true;
            } 
        }
        return posEmple;
    }
    
    /**
     * metodo que valida la contraseña del empleado
     * @param posContrasena 
     */
    public void compContrasenaEmp(int posContrasena){
        boolean respuesta=true;
        while(respuesta){
            try{
               respuesta=guarda.compContrasenaEmp(vis.Contraseña(),posContrasena); 
               comprobacionContraseña(respuesta);
            }catch(Expciones e){ 
                System.out.println("contraseña invalida");
            } 
        }
    }

    /**
     * metodo que crea un expcion para comprobar la contraseña
     * @param con
     * @throws Expciones 
     */
    public void comprobacionContraseña(boolean con) throws Expciones{
        
        if(con==true){
             throw new Expciones(); //lanza un exception
        }  
    }
    
    /**
     * metodo que regresa una excepcion si no se encuentra un cliente
     * @param noCuenta
     * @throws Expciones 
     */
    public void noCliente(int noCuenta) throws Expciones{
       
        if(noCuenta==-1){
             throw new Expciones(); //lanza un exception
        } 
        
    }
    
    /**
     * metodo que crea un objeto cliente y lo mandan para guardarlo 
     */
    public void agregarCliente(){
        cli=new Cliente();
        cli.setNombre(vis.pedirNombre());
        cli.setEdad(vis.pedirEdad());
        cli.setCorreo(vis.pedirCorreo());
        cli.setTelefono(vis.pedirTelefono());
        cli.setSaldo(vis.pedirSaldo());
        cli.setNoCuenta(generarCuenta());
        cli.setContrasena(generarContrasena());
        guarda.agregarClient(cli);
    }
    
    /**
     * metodo para generar un numero de cuenta de cliente y lo regresa para guardarlo 
     * @return 
     */
    public int generarCuenta(){
        int cuenta=0;
        boolean estar=true;
        while(estar){
            cuenta= (int)(Math.random()*1000000000);
            estar=guarda.cliente(cuenta);
        }
        return cuenta;
    }
    
    /**
     * metodo que genera una contraseña y lo regrasa
     * @return 
     */
    public int generarContrasena(){
        int contrasena=0;
        contrasena=(int)(Math.random()*10000);
        return contrasena;
    }
    
    /**
     * metodo que gener un nuemro de empleado 
     * @return 
     */
    public int generarNumEmpleado(){
        int cuenta=0;
        boolean estar=true;
        while(estar){
            cuenta= (int)(Math.random()*100000);
            estar=guarda.empleado(cuenta);
        }
        return cuenta;
    }
    
    /**
     * metodo que crea un objeto de tipo empleado y lo guarda
     */
    public void agregarEmpleado(){
        emp=new Empleado();
        emp.setNombre(vis.pedirNombre());
        emp.setEdad(vis.pedirEdad());
        emp.setCorreo(vis.pedirCorreo());
        emp.setTelefono(vis.pedirTelefono());
        emp.setPuesto(vis.pedirPuesto());
        emp.setUsuario(vis.pedirUsuario());
        emp.setNumEmpleado(generarNumEmpleado());
        emp.setContrasena(generarContrasena());
        guarda.agregarEmpleado(emp);
    }
    
    /**
     * metodo que se encarga de borrar un cliente y comprobar si existe ese cliente
     */
    public void borrarCliente(){
        boolean respuesta=true;
        int posClient=0;
        while(respuesta){
            try{
               posClient=guarda.obtCliente(vis.pedirCuenta()); 
               noCliente(posClient);
               respuesta=false;
            }catch(Expciones e){ 
                System.out.println("Cliente no encontrado");
                System.out.println("intentelo de nuevo");
                respuesta=true;
            } 
        }
        guarda.borrarClient(posClient);
    }
    
    /**
     * metodo que recive la pocion del empleado y permite cambiar la contraseña
     * @param posContrasena 
     */
    public void cambiarContrasena(int posContrasena){
        boolean respuesta=true;
        while(respuesta){
            try{
               respuesta=guarda.compContrasenaEmp(vis.Contraseña(),posContrasena); 
               comprobacionContraseña(respuesta);
            }catch(Expciones e){ 
                System.out.println("contraseña invalida");
            } 
        }
        guarda.empleado.get(posContrasena).setContrasena(vis.cambiarContrasena());
    }
    
    /**
     * metodo que modifica a un cliente 
     * @param posCliente 
     */
    public void modificarClient(int posCliente){
        guarda.clientes.get(posCliente).setNombre(vis.pedirNombre());
        guarda.clientes.get(posCliente).setEdad(vis.pedirEdad());
        guarda.clientes.get(posCliente).setCorreo(vis.pedirCorreo());
        guarda.clientes.get(posCliente).setTelefono(vis.pedirTelefono()); 
    }
    
    /**
     * metodo que pide el nuemr de cuenta de un cliente y regresa la pocion en la que se encuentraf
     * @return 
     */
    public int comprobarCliente(){
        boolean respuesta=true;
        int posCli=0;
        while(respuesta){
            try{
               posCli=guarda.obtCliente(vis.pedirCuenta()); 
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
     * metodo que cambia la contradeña de un cliente
     * @param posContrasena 
     */
    public void cambiarContrasenaCliente(int posContrasena){
        boolean respuesta=true;
        while(respuesta){
            try{
               respuesta=guarda.compContrasena(vis.Contraseña(),posContrasena); 
               comprobacionContraseña(respuesta);
            }catch(Expciones e){ 
                System.out.println("contraseña invalida");
            } 
        }
        guarda.clientes.get(posContrasena).setContrasena(vis.cambiarContrasena());
    }
    
}
