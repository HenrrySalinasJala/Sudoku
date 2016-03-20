import static org.junit.Assert.*;

import org.junit.Test;

import sudoku.Settings;
import sudoku.io.XMLHandler;

public class XMLHandlerTest {
	@Test
	public void aXMLFileCanBeCreateWithLevelOutputAndAlgorithm() throws Exception
	{
		XMLHandler xml = new XMLHandler("levelX", "algorithmX", "sudokuConfig.xml");
		xml.writeXML();
	}
	@Test
	public void theLevelOutputAndAlgorithmInformationCanBeReaded() throws Exception
	{
		Settings set = new Settings("levelX", "algorithmX", "wwautput.xml");
		XMLHandler xml = new XMLHandler(set.getLevel(), set.getAlgorithm(), set.getOuput());
		xml.readXML(".\\files\\sudokuConfig.xml");
		System.out.println(xml.getAlgorithm());
	}
}
