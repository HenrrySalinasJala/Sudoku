import static org.junit.Assert.*;

import org.junit.Test;

import sudoku.GameBoard;
import sudoku.io.CSVHandler;
import sudoku.io.TXTHandler;

public class TXTHandlerTest {

	@Test
    public void TXTHandlerTests()
    {
		TXTHandler testTXTHandler = new TXTHandler(".\\files\\filetxt.txt");        
		testTXTHandler.readTXT();
        assertTrue(testTXTHandler instanceof  TXTHandler);      
    }
}
