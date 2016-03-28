package sudoku;

public class GameBoard {
    static int  SIZE= 9;
    public  static int  [][] grid;
    public GameBoard() {
        grid=new int[][] { 
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },      
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },                          
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
    }
    @Override
    public String toString(){
        String gridString="";
        for (int i = 0; i < SIZE; i++)
        {
             for (int j = 0; j < SIZE; j++)
            {
                gridString+=grid[i][j];
            }
             
        }
        return gridString;
    } 
    public int getSize(){
        return GameBoard.SIZE;
    }
}
