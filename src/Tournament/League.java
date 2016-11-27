/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tournament;
import java.io.Serializable;
import java.util.*;

public class League  implements Serializable{
    
    public String start;
    public String end;    
    
    public ArrayList<Player> players;

    public League(String start, String end) {
        this.start = start;
        this.end = end;
        
        this.players = new ArrayList<>();
    }  
    
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    } 

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
    public boolean registrerPlayer(Player player){
        for(Player p : players)
        if(player.equals(p)){
            System.out.println("El jugador ya esta registrado.");
            return false;
        }
        players.add(player);
        return true;
        
    }
    
    
    
    
}