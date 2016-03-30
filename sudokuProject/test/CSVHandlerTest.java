import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import sudoku.GameBoard;
import sudoku.io.CSVHandler;

public class CSVHandlerTest {
    @Test
    public void CSVHandlerCanBeCreatedWithNoParameters()
    {
        CSVHandler testCSVHandler = new CSVHandler(".\\files\\filecsvcreate.csv");
        assertNotNull(testCSVHandler);
    }
    @Test
    public void CSVHandlerCanWrite()
    {
        CSVHandler testCSVHandler = new CSVHandler(".\\files\\filecsvwrite.csv");
        GameBoard board=new GameBoard();
        testCSVHandler.csvWrite(board.toString(),board.getSize());
        assertEquals(board.getSize(),9);
    }
    
    @Test
    public void CSVHandlerCanRead()
    {int[][]  grid = new int[][] { 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
        CSVHandler testCSVHandler = new CSVHandler(".\\files\\filecsv.csv");
        GameBoard board=new GameBoard(grid);
        
            
            testCSVHandler.csvWrite(board.toString(),board.getSize());
        int[][]gridReaded;
        gridReaded = testCSVHandler.csvRead();
        java.util.Arrays.deepEquals(grid, gridReaded);
    }
    

 
}
