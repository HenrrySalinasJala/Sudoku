import static org.junit.Assert.*;
import org.junit.Test;
import sudoku.Settings;
import sudoku.io.XMLHandler;

public class XMLHandlerTest {
    @Test
    public void aXMLFileCanBeCreateWithLevelOutputAndAlgorithm() throws Exception
    {
        Settings set = new Settings("levelXMLHandlerTest", "algori.txt", "ou.txt");
        XMLHandler xml = new XMLHandler(set.getLevel(), set.getAlgorithm(), set.getOuput(),".\\files\\xmlHandlerX.xml");
        xml.writeXML();
    }
    @Test
    public void theLevelOutputAndAlgorithmInformationCanBeReaded() throws Exception
    {
        Settings setting = new Settings("levelXMLHandlerTest", "algorithmXMLHandlerTest", "out.csv");
        XMLHandler xml = new XMLHandler(setting.getLevel(), setting.getAlgorithm(), setting.getOuput(),".\\files\\xmlHandlerX.xml");
        xml.writeXML();
        xml.readXML();
        assertEquals("levelXMLHandlerTest",xml.getLevel());
        assertEquals("algorithmXMLHandlerTest",xml.getAlgorithm());
        assertEquals(".\\files\\out.csv",xml.getOutput());
    }
    @Test
    public void theLevelCanBeChanged ()throws Exception
    {
        Settings setting = new Settings("levelXMLHandlerTest", "algorithmXMLHandlerTest", "out.csv");
        XMLHandler xml = new XMLHandler(setting.getLevel(), setting.getAlgorithm(), setting.getOuput(),".\\files\\xmlHandlerX.xml");
        xml.writeXML();
        xml.readXML();
        xml.setConfigLevel("2");
        assertEquals("2",xml.getLevel());
    }
}
