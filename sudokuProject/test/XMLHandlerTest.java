import static org.junit.Assert.*;

import org.junit.Test;

import sudoku.io.XMLHandler;


public class XMLHandlerTest {

	@Test
	public void aXMLFileCanBeCreateWithLevelOutputAndAlgorithm() throws Exception {
		XMLHandler xml =new XMLHandler("levelX","algorithmX","sudokuConfig.xml");
		
		xml.writeXML();
		
	}
	@Test
	
	public void theLevelOutputAndAlgorithmInformationCanBeReaded() throws Exception {
		XMLHandler xml = new XMLHandler("levelX","algorithmX","wwautput.xml");
		xml.readXML(".\\files\\sudokuConfig.xml");
		System.out.println(xml.getAlgorithm());
		
	}

}
