/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author bari
 */
public class AppView extends JFrame implements View, ActionListener {
    private final Model model;
    private final Controller controller;
    
    private JPanel mainPanel = new JPanel(new BorderLayout());
    private JPanel currentPlayerPanel = new JPanel();

    private ArrayList<JButton> boardCells;
    private JLabel currentPlayerJL;
    private JTextField currentPlayerTF;
    
    
    public AppView(Controller controller, Model model){
        this.controller = controller;
        this.model = model;
        boardCells = new ArrayList<>();
        currentPlayerJL = new JLabel("current player:");
        currentPlayerTF = new JTextField(15);
        initComponents();
        getPlayersNames();
    }
    
    private void initComponents(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);        
        
        //Panel for boardCells
        JPanel boardPanel = new JPanel(new GridLayout(3,3));
        boardPanel.setPreferredSize(new Dimension(200,200));
        
        //ArrayList<JButton> boardCells = new ArrayList<>();
        
        for(int i = 0; i < 9; i++){
            String buttonName = "";
            JButton tempButton = new JButton(buttonName);
            tempButton.addActionListener(this);
            boardPanel.add(tempButton);
            boardCells.add(tempButton);
        }
        mainPanel.add(boardPanel, BorderLayout.CENTER);
        
        //JPanel for texField with the current Player
        currentPlayerPanel.setLayout(new BoxLayout(currentPlayerPanel, BoxLayout.X_AXIS));
        currentPlayerPanel.add(currentPlayerJL);
        currentPlayerPanel.add(currentPlayerTF);
        mainPanel.add(currentPlayerPanel, BorderLayout.SOUTH);
        
        /*
        //JPanel for players info
        JPanel playerInfo = new JPanel();
        playersInfoList.setPreferredSize(new Dimension(100,250));
        playerInfo.add(playersInfoList);
        mainPanel.add(playerInfo, BorderLayout.EAST);
        */
        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
        
    }
    private void getPlayersNames(){
        String[] playersNames = new String[2];
        playersNames[0] = JOptionPane.showInputDialog("Input player1 name");
        playersNames[1] = JOptionPane.showInputDialog("Input player2 name");
        controller.checkPlayersNames(playersNames);
    }
    
    private String wonGameInfo(Player[] playersInfo){
        String message;
        message = playersInfo[0].toString() + "\n" + playersInfo[1].toString();
        return message;
    }
    /*@Override
    public void updateView( Object data){
        if( data instanceof BoardCells){
            BoardCells bs = (BoardCells)data;
            
         }
    }
    
    
    @Override
    public void updateView( Object data){
        if( data instanceof GameInfo){
            //...
        }
    }
*/
    @Override
    public void updateView(String[] boardCells, GameState gameState) {
        for(int i = 0; i < 9; i++){
            this.boardCells.get(i).setText(boardCells[i]);
        }
        switch(gameState){
            case PLAYING:   currentPlayerTF.setText(model.getCurrentPlayer().getName());
                            break;
            
            case FULL:      JOptionPane.showMessageDialog(this, "Board full!\nNo winner!", "Board full", JOptionPane.PLAIN_MESSAGE);
                            exit();
                            break;
            
            case WIN:       JOptionPane.showMessageDialog(this, wonGameInfo(model.getPlayers()), "WIN", JOptionPane.PLAIN_MESSAGE);
                            exit();
                            break;
        }
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //System.out.println(boardCells.indexOf(e.getSource()));
        Cell move = new Cell((boardCells.indexOf(e.getSource()) / 3),(boardCells.indexOf(e.getSource()) % 3));
        String sign = ((JButton)e.getSource()).getText();
        move.setSign(sign);
        controller.checkMove(move);
        
    }

    private void exit() {
        int choice = JOptionPane.showConfirmDialog(this, "Continue Playing? ", "exit the game", JOptionPane.YES_NO_OPTION); 
        controller.exitTheGame(choice);
    }
    
}
