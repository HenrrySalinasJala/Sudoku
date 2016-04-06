import static org.junit.Assert.*;
import org.junit.Test;
import sudoku.Settings;
import sudoku.io.XMLHandler;

public class XMLHandlerTest {
    @Test
    public void aXMLFileCanBeCreateWithLevelOutputAndAlgorithm()
    {
        Settings set = new Settings("levelXMLHandlerTest", "algori.txt", "ou.txt", ".\\files\\xmlHandlerX.xml");
        XMLHandler xml = new XMLHandler(set.getPath());
        xml.writeXML(set);
    }

    @Test
    public void theLevelOutputAndAlgorithmInformationCanBeReaded()
    {
        Settings setting = new Settings("levelXMLHandlerTest", "algorithmXMLHandlerTest", "out.csv",
                ".\\files\\xmlHandlerX.xml");
        XMLHandler xml = new XMLHandler(setting.getPath());
        xml.writeXML(setting);
        assertEquals("levelXMLHandlerTest", setting.getLevel());
        assertEquals("algorithmXMLHandlerTest", setting.getAlgorithm());
        assertEquals("out.csv", setting.getOutput());
    }
}
