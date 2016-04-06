package sudoku;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import sudoku.io.TXTHandler;

public class TXTHandlerTest {

	@Test
	public void aTXTHandlerObjectShouldBeCreatedWithout() {
		TXTHandler txtHandler = new TXTHandler(".\\files\\sudoku.txt");
		assertNotNull(txtHandler);
	}

	@Test
	public void aTxtFileReadedShouldBeReturnAMatrix() {
		int[][] grid = new int[][] { { 0, 0, 3, 0, 2, 0, 6, 0, 0 }, { 9, 0, 0, 3, 0, 5, 0, 0, 1 },
				{ 0, 0, 1, 8, 0, 6, 4, 0, 0 }, { 0, 0, 8, 1, 0, 2, 9, 0, 0 }, { 7, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 0, 0, 6, 7, 0, 8, 2, 0, 0 }, { 0, 0, 2, 6, 0, 9, 5, 0, 0 }, { 8, 0, 0, 2, 0, 3, 0, 0, 9 },
				{ 0, 0, 5, 0, 1, 0, 3, 0, 0 } };
		TXTHandler txtHandler = new TXTHandler(".\\files\\sudokuLine.txt");
		GameBoard board = new GameBoard(grid);
		int[][] gridReaded = txtHandler.parseToMatrix(txtHandler.readTXTFile());
		java.util.Arrays.deepEquals(board.getGrid(), gridReaded);
	}

	@Test
	public void aTxtFileShouldBeCretedWithAMatrix() {
		int[][] grid = new int[][] { { 0, 0, 3, 0, 2, 0, 6, 0, 0 }, { 9, 0, 0, 3, 0, 5, 0, 0, 1 },
				{ 0, 0, 1, 8, 0, 6, 4, 0, 0 }, { 0, 0, 8, 1, 0, 2, 9, 0, 0 }, { 7, 0, 0, 0, 0, 0, 0, 0, 8 },
				{ 0, 0, 6, 7, 0, 8, 2, 0, 0 }, { 0, 0, 2, 6, 0, 9, 5, 0, 0 }, { 8, 0, 0, 2, 0, 3, 0, 0, 9 },
				{ 0, 0, 5, 0, 1, 0, 3, 0, 0 } };
		TXTHandler txtHandler = new TXTHandler(".\\files\\sudokuWWW.txt");
		GameBoard board = new GameBoard(grid);
		txtHandler.writeTXT(board.toString());
		File file = new File(".\\files\\sudokuWWW.txt");
		assertTrue(file.exists());
	}
}
