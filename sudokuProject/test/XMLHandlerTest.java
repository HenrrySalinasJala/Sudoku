import static org.junit.Assert.*;

import org.junit.Test;

import sudoku.Settings;
import sudoku.io.XMLHandler;

public class XMLHandlerTest {
	@Test
	public void aXMLFileCanBeCreateWithLevelOutputAndAlgorithm() throws Exception
	{
		Settings set = new Settings("levelXMLHandlerTest", "algorithmXMLHandlerTest", ".\\files\\xmlHandlerTest.xml");
		XMLHandler xml = new XMLHandler(set.getLevel(), set.getAlgorithm(), set.getOuput());
		xml.writeXML();
	}
	@Test
	public void theLevelOutputAndAlgorithmInformationCanBeReaded() throws Exception
	{
		Settings set = new Settings("levelXMLHandlerTest", "algorithmXMLHandlerTest", "xmlHandlerTest.xml");
		XMLHandler xml = new XMLHandler(set.getLevel(), set.getAlgorithm(), set.getOuput());
		xml.writeXML();
		xml.readXML(".\\files\\xmlHandlerTest.xml");
		assertEquals(xml.getLevel(), "levelXMLHandlerTest");
		assertEquals(xml.getAlgorithm(), "algorithmXMLHandlerTest");
		assertEquals(xml.getOutput(), ".\\files\\xmlHandlerTest.xml");
	}
}
