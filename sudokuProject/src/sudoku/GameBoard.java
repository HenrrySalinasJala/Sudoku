package sudoku;

import sudoku.algorthms.BacktrackSolver;
import sudoku.algorthms.ISudokuSolver;

public class GameBoard {
    public static int SIZE = 9;
    private static int[][] grid;

    public GameBoard(int [][]grid)
    {
        this.grid =grid;
    }
    public GameBoard()
    {
        grid = new int[][] { 
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
    
    public void solveGrid(ISudokuSolver solver)
    {
    	
        Cell cell = new Cell(0, 0);
        boolean solved = solver.solve(cell, grid);
        if (!solved)
        {
            System.out.println("SUDOKU cannot be solved.");
            return;
        }
    }
    public void printGrid(int grid[][])
    {
        for (int row = 0; row < SIZE; row++)
        {
            for (int col = 0; col < SIZE; col++)
                System.out.print(grid[row][col]);
            System.out.println();
        }
    }
    
    public void setGrid(int[][] grid) {
        this.grid=grid;
    }
    public int[][] getGrid() {
        return this.grid;
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
}
