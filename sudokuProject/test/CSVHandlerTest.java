import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import sudoku.GameBoard;
import sudoku.io.CSVHandler;

public class CSVHandlerTest {
    @Test
    public void CSVHandlerCanBeCreatedWithNoParameters()
    {
        CSVHandler testCSVHandler = new CSVHandler(".\\files\\filecsv.csv");
        assertNotNull(testCSVHandler);
    }
    @Test
    public void CSVHandlerCanWrite()
    {
        CSVHandler testCSVHandler = new CSVHandler(".\\files\\filecsv.csv");
        GameBoard board=new GameBoard();
        testCSVHandler.csvWrite(board.toString(),board.getSize());
        assertEquals(board.getSize(),9);
    }
    
    @Test
    public void CSVHandlerCanRead()
    {
        CSVHandler testCSVHandler = new CSVHandler(".\\files\\filecsv.csv");
        GameBoard board=new GameBoard();
        testCSVHandler.csvWrite(board.toString(),board.getSize());
        assertEquals(board.getSize(),9);
    }
    

 
}
