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
public class Cell {
    int row, col;
    String sign;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        sign = "";
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Cell){
            return(this.sign.equals(((Cell) obj).sign));
        }
        return false;
    }
    
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
    
    
}
