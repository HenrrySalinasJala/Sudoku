package sudoku.algorthms;

import sudoku.Cell;

public class BacktrackSolver {
    /**
     * this method check through the parameters if a values into a cell is valid 
     * @param currentCell this parameter contains the current cell object
     * @param value this parameter keep the value to evaluate is valid 
     * @param grid this parameter contains the matrix of sudoku
     * @return if the value is checked return true else return false
     */
    static boolean isValid(Cell currentCell, int value, int grid[][])
    {
        if (grid[currentCell.row][currentCell.col] != 0)
        {
            throw new RuntimeException("Cannot call for cell which already has a value");
        }
        for (int colIndex = 0; colIndex < grid.length; colIndex++)
        {
            if (grid[currentCell.row][colIndex] == value)
                return false;
        }
        for (int rowIndex = 0; rowIndex < grid.length; rowIndex++)
        {
            if (grid[rowIndex][currentCell.col] == value)
                return false;
        }
        if (!checkValueInGrid(currentCell, value, grid))
        {
            return false;
        }
        return true;
    }
   
    /***
     * This function check if value is present in grid to get the grid we should
     * @param currentCell  this parameter contains the current cell object
     * @param value value this parameter keep the value to evaluate is valid
     * @param grid grid this parameter contains the matrix of sudoku
     * @return if the value is checked return true else return false
     */
    public static boolean checkValueInGrid(Cell currentCell, int value, int[][] grid)
    {
        int x1 = 3 * (currentCell.row / 3);
        int y1 = 3 * (currentCell.col / 3);
        int x2 = x1 + 2;
        int y2 = y1 + 2;
        for (int x = currentCell.row; x <= x2; x++)
            for (int y = currentCell.col; y <= y2; y++)
                if (grid[x][y] == value)
                    return false;
        return true;
    }
    /***
     * this method get next cell in the matrix
     * @param cur keep the current cell
     * @return return the nex cell to evaluate
     */
    static Cell getNextCell(Cell cur)
    {
        int row = cur.row;
        int col = cur.col;
        col++;
        if (col > 8)
        {
            col = 0;
            row++;
        }
        if (row > 8)
            return null; // reached end
        Cell next = new Cell(row, col);
        return next;
    }
    /***
     * this a recursive method for solve the sudoku 
     * @param currentCell keep the current cell
     * @param grid keep the matrix of values
     * @return true of the sudoku is solved
     * 
     */
    public static boolean solve(Cell currentCell, int grid[][])
    {
        if (currentCell == null)
            return true;
        if (grid[currentCell.row][currentCell.col] != 0)
        {
            return solve(getNextCell(currentCell), grid);
        }
        for (int i = 1; i <= grid.length; i++)
        {
            boolean valid = isValid(currentCell, i, grid);
            if (!valid)
                continue;
            grid[currentCell.row][currentCell.col] = i;
            boolean solved = solve(getNextCell(currentCell), grid);
            if (solved)
                return true;
            else
                grid[currentCell.row][currentCell.col] = 0; // reset
        }
        return false;
    }
}
