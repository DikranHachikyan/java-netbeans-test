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
/*
public class Sign {
    public static final String CROSS = "X";
    public static final String ZERO = "O";
    public static final String EMPTY = "";

}
*/

public enum Sign { CROSS("X"), ZERO("O");
    
    private String description;
    private Sign(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return description;
    }

/*
    public String toString(){
        String printed;
        switch(this){
            case CROSS: printed = CROSS.description;
                        break;
            case ZERO:  printed = ZERO.description;
                        break;
            default: printed = EMPTY.description;
                        break;
        }
        return printed;
    }
*/
}
