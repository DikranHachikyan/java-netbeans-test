/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.ArrayList;

/**
 *
 * @author bari
 */
public class AppModel implements Model{
    private final Board board;
    private final Player[] players = new Player[]{
     new Player("Player 1"),
     new Player("Player 2")
    };
    private Player currentPlayer;
    private GameState gameState;
    
    private ArrayList<View> views;
    
    public AppModel(){
        board = new Board();
        //players = new Player[2];
        initPlayers();
        currentPlayer = players[0];
        gameState = GameState.PLAYING;
        views = new ArrayList<>();
    }
    
    private void initPlayers(){
        players[0] = new Player("Player1");
        players[0].setSign(Sign.CROSS);
        players[0].setWins(0);
        
        players[1] = new Player("Player2");
        players[1].setSign(Sign.ZERO);
        players[1].setWins(0);
    }
    
    @Override
    public Player[] getPlayers(){
        return players;
    }
    
    private void changePlayer(){
        Sign sign = currentPlayer.getSign();
        switch(sign){
            case CROSS: currentPlayer = players[1];
                        break;
            case ZERO: currentPlayer = players[0];
                        break;
        }
    }
    
    @Override
    public void play(Cell move) {
        move.setSign(currentPlayer.getSign().getDescription());
        board.cells[move.getRow()][move.getCol()].setSign(move.getSign());
        checkGameState(move);
        changePlayer();
        updateView(board.getBoard());
    }

    @Override
    public void setPlayersNames(String[] playersNames) {
        for(int i = 0; i < playersNames.length; i++){
            players[i].setName(playersNames[i]);
        }
        updateView(board.getBoard());
    }
    
    public void checkGameState(Cell selectedCell){
        
        //проверка за победа в ред
        int gs = 0;
        while(selectedCell.equals(board.cells[selectedCell.getRow()][gs])){
            gs++;
            if (gs == 3){
                System.out.println("победа ред");
                currentPlayer.setWins(currentPlayer.getWins() + 1);
                gameState = GameState.WIN;
                break;
            }
        }
        //проверка за победа в колона
        gs=0;
        while(selectedCell.equals(board.cells[gs][selectedCell.getCol()])){
            gs++;
            if (gs == 3){
                System.out.println("победа колона");
                currentPlayer.setWins(currentPlayer.getWins() + 1);
                gameState = GameState.WIN;
                break;
            }
        }
        //проверка за победа в главен диагонал
        gs=0;
        while(selectedCell.equals(board.cells[gs][gs])){
            gs++;
            if (gs == 3){
                System.out.println("победа гл. диагонал");
                currentPlayer.setWins(currentPlayer.getWins() + 1);
                gameState = GameState.WIN;
                break;
            }
        }
        //проверка за победа в диагонал
        gs=0;
        for(int r = 0; r < 3; r++){
            int j = Math.abs(r - 2);
                if(selectedCell.equals(board.cells[r][j])){
                    gs++;
                    if (gs == 3){
                        System.out.println("победа диагонал");
                        currentPlayer.setWins(currentPlayer.getWins() + 1);
                        gameState = GameState.WIN;
                        break;
                    }
                }
        }
        //проверка за равен резултат
        if(gameState == GameState.PLAYING){
            gs=0;
            for(int r = 0; r < 3; r++){
                for(int j = 0; j < 3; j++){
                    Cell c = board.cells[r][j];
                    if(!c.getSign().isEmpty()){
                        gs++;
                    }
                }
                if(gs == 9){
                    System.out.println("равен резултат");
                    gameState = GameState.FULL;
                }
            }
        }
        
    }

    @Override
    public void registerView(View view) {
        views.add(view);
    }

    @Override
    public void updateView(String[] boardCells) {
        for(View view : views){
            view.updateView(boardCells, gameState);
        }
        
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    @Override
    public void newGame(){
        board.clearBoard();
        gameState = GameState.PLAYING;
        updateView(board.getBoard());
    }
    
}
