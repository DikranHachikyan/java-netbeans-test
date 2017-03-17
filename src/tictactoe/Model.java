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
public interface Model {
    public void play(Cell move);
    public void setPlayersNames(String[] playersNames);
    public void registerView(View view);
    public void updateView(String[] boardCells);
    
    //public void updateView(Object data);
    
    public Player getCurrentPlayer();
    public Player[] getPlayers();
    public void newGame();
}
