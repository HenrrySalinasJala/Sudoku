package sudoku.algorthms;

import sudoku.Cell;

public interface ISudokuSolver {
	public boolean solve(Cell currentCell, int grid[][]);
}
