/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author bari
 */
public class Player {
    String name;
    Sign sign;
    int wins;
    
    public Player(String name){
        this.name = name;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
    
    @Override
    public String toString(){
        String playerInfo;
        playerInfo = getName() + " wins: " + getWins();
        return playerInfo;
    }
}
