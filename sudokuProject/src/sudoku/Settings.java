package sudoku;

import java.io.IOException;
import org.jdom2.JDOMException;
import org.w3c.dom.DOMException;
import sudoku.io.XMLHandler;

public class Settings {
    private String level;
    private String output;
    private String algorithm;
    private XMLHandler xml;
    /***
     * this function is the construcor of the class
     * @param level keep the level of sudoku game
     * @param algorithm keep the algorithm used to solve the sudoku
     * @param output keep the output name of the xml file
     * @throws Exception if a exception occours when de code is exeuted this implementation let catch some possible error  
     */
    public Settings(String level, String algorithm, String output) throws Exception
    {
        this.level = level;
        this.output = ".\\files\\"+output;
        this.algorithm = algorithm;
        //xml = new XMLHandler(level, algorithm, output);
    }
    /***
     * this is a constructpr wthout parameters
     * @throws Exception
     */
    public Settings() throws Exception
    {
        this.level = "1";
        this.algorithm = "Backtrack";
        this.output = ".\\files\\sudokuDefaultConfig.xml";
        //xml = new XMLHandler(level, algorithm, output);
    }
   
    public String getLevel()
    {
        return level;
    }
    public String getOuput()
    {
        return output;
    }
    public String getAlgorithm()
    {
        return algorithm;
    }
    public String getXMLLevel()
    {
        return xml.getLevel();
    }
    /**
     * this method set the level attribute
     * @param level input parameter for assign to attribute
     * @throws IOException 
     * @throws JDOMException 
     */
    public void setLevel(String level) throws JDOMException, IOException
    {
        this.level = level;
        xml.setConfigLevel(level);
    }
    public void setAlgorithm(String algorithm) throws JDOMException, IOException
    {
        this.algorithm = algorithm;
        xml.setConfigAlgorithm(algorithm);
    }
    public void setOutput(String output) throws JDOMException, IOException
    {
        this.output = output;
        xml.setConfigOutput(output);
    }
    public void writeXmlSettings() throws Exception
    {
        xml.writeXML();
    }
    public void readXmlSettings() throws Exception
    {
        //xml.readXML(output);
        level = xml.getLevel();
        algorithm = xml.getAlgorithm();
        output = xml.getOutput();
    }
}
