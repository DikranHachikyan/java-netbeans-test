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
public class AppController implements Controller{
    private final Model model;
    
    public AppController(Model model){
        this.model = model;
    }

    @Override
    public void checkMove(Cell move) {
        boolean isCellAlreadyUsed = move.getSign().isEmpty();
        if(isCellAlreadyUsed){
            model.play(move);
        }
    }

    @Override
    public void exitTheGame(int choice) {
        switch(choice){
            case 0: model.newGame();
                    break;
            case 1: System.exit(0);
        }
    }

    @Override
    public void checkPlayersNames(String[] playersNames) {
        //TODO check if players names are valid
        model.setPlayersNames(playersNames);
    }
    
}
