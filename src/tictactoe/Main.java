/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javax.swing.SwingUtilities;

/**
 *
 * @author bari
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Runnable run = new Runnable(){
            @Override
            public void run() {
                Model model = new AppModel();
                Controller controller = new AppController(model);
                View view = new AppView(controller, model);
                model.registerView(view);
                
            }
            
        };
        SwingUtilities.invokeLater(run);
    }
    
}
