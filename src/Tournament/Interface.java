/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tournament;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Vladimir
 */
public class Interface  implements Serializable{
    
    Scanner s = new Scanner(System.in);
    ArrayList<Player> players = new ArrayList<>();
    Tournament tournaments;
    League leagues;
    char seleccion;
    
    
    public Interface(){
        test();
    }
    public void listarJugadores(){
        for(Player p:players){
            System.out.println(p.getName());            
        }
    }
    public void listarJugadoresActivos(){
        for(Player p:players){
            if(p.active == true)
            System.out.println(p.getName());            
        }
    }
    
    public void menu() throws IOException{
        
        System.out.println("1) Listar todos los jugadores");
        System.out.println("2) Listar jugadores actvos");
        System.out.println("3) Registrar nuevo jugador.");        
        System.out.println("4) Registrar jugador en torneo.");        
        System.out.println("5) Registrar jugador en liga.");
        System.out.println("6) Guardar");
        System.out.println("7) Salir");
        
        
        
        seleccion = s.next().charAt(0);
        switch(seleccion){
            case '1': listarJugadores();
                break;
            case '2': listarJugadoresActivos();
                break;
            case '3':
                System.out.println("ok");
                registrarJugador();
                break;
            case '4': registrarEnTorneo();
                break;
            case '5':
                    registrarEnLiga();
                break;
            case '6':
                Main.guardar(this);
                break;
            case '7': System.exit(0);
                break;
            default:
        }
    }
    
    public void registrarJugador(){
        String nombre;
        String eMail;
        Player player;
        System.out.println("Ingrese el nombre del jugador.");
        nombre = s.next();
        System.out.println("Ingrese el email del jugador.");
        eMail = s.next();
        player = new Player(nombre, eMail);
        players.add(player);
        
    }
    
    public void registrarEnTorneo(){
        String nombre;
        if(tournaments == null){
            System.out.println("No hay torneos disponibles.");
        }else{
            System.out.println("Ingrese el nombre del jugador");
                nombre = s.next();
        for(Player p: players){
            if(p.getName().equals(nombre)){
                p.active = true;
                tournaments.registrerPlayer(p);
            }
        }
        }
    }
    
    public void registrarEnLiga(){
        String nombre;
        System.out.println("Ingrese el nombre del jugador");
                nombre = s.next();
        for(Player p: players){
            if(p.getName().equals(nombre))
                if(p.active){
                    leagues.registrerPlayer(p);
                }else{
                    System.out.println("El jugador no esta inscrito en ningun torneo.");
                }
            }
    }
    
    public void test(){
        Tournament t1 = new Tournament("01/01/15", "02/01/15");
        League l1 = new League("01/01/15", "09/12/15");
        Player p1 = new Player("James Rodriguez", "jajajames@gmail.com");
        Player p2 = new Player("Sasha Grey", "sasha@xvideos.com");
        tournaments = t1;
        players.add(p1);
        players.add(p2);
    }
    
}
