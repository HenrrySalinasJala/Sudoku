import static org.junit.Assert.*;
import org.junit.Test;

import sudoku.io.CSVHandler;

public class CSVHandlerTest {
	@Test
	public void CSVHandlerCanBeCreatedWithNoParameters()
	{
		CSVHandler testCSVHandler = new CSVHandler();
		assertNotNull(testCSVHandler);
	}
	@Test
	public void CSVHandlerCanWriteandReadCSVs()
	{
		CSVHandler testCSVHandler = new CSVHandler();
		testCSVHandler.csvWrite("0", "0", "0", "0", "0", "0", "0", "0", "0");
		testCSVHandler.csvRead();
		assertEquals(testCSVHandler.getspot1(), "0");
	}
}
