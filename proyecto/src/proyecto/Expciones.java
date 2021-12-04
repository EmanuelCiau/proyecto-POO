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
public class Expciones extends Exception{
    
    public Expciones(){}
    

    
    public void ds() throws Expciones{
       
        if(0==-1){
             throw new Expciones(); //lanza un exception
        }     
    }
    
}
