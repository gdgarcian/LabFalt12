/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tournament;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    
    public static void guardar(Interface a){
        try{
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("league.obj"));
        ous.writeObject(a);
        ous.close();
        }catch(Exception e){
                System.out.println("Error");
        }
    }
    
    public static Interface recuperar(){
        Interface a = null;
        try{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("league.obj"));
        a = (Interface)ois.readObject();
        ois.close();
        }catch(Exception e){
            System.out.println("Error desconocido");
        }
        return a;
    }
    
    public static void main(String[] args){
        Interface inter = new Interface();
        Scanner s = new Scanner(System.in);
        guardar(inter);
        if(recuperar()!=null)
        inter = recuperar();
       
        while(true){  
            
            
            try {
                inter.menu();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            
        }
    }
    
}
 