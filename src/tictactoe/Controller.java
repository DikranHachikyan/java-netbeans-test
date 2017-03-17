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
public interface Controller {
    public void checkMove(Cell move);
    public void exitTheGame(int choice);
    public void checkPlayersNames(String[] playersNames);
}
