package tictactoe;

/**
 *
 * @author bari
 */
public class Board {
    Cell cells[][];
    private int row, col;
    
    public Board(){
        cells = new Cell[3][3];
        initCells();
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
    
    private void initCells(){
        for(int i=0; i < 3; i++){
            for(int j=0; j < 3; j++){
                cells[i][j] = new Cell(i,j);
            }
        }
    }
    
    public String[] getBoard(){
        String[] btns = new String[9];
        for(int i = 0; i < 9; i++){
            btns[i] = (cells[(Integer)(i / 3)][i % 3]).getSign();
        }
        return btns;
    }
    
    public void clearBoard(){
        for(int i=0; i < 3; i++){
            for(int j=0; j < 3; j++){
                cells[i][j].setSign("");
            }
        }
    }
}
