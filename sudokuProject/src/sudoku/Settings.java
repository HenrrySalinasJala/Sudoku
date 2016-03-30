package sudoku;

import java.io.IOException;
import org.jdom2.JDOMException;
import org.w3c.dom.DOMException;
import sudoku.io.XMLHandler;

public class Settings {
    private XMLHandler xml;

    /***
     * this function is the construcor of the class
     * 
     * @param level
     *            keep the level of sudoku game
     * @param algorithm
     *            keep the algorithm used to solve the sudoku
     * @param output
     *            keep the output name of the xml file
     * @throws Exception
     *             if a exception occours when de code is exeuted this
     *             implementation let catch some possible error
     */
    public Settings(String level, String algorithm, String output, String path) throws Exception
    {
        xml = new XMLHandler(level, algorithm, output, path);
    }
    /***
     * this is a constructor without parameters
     * 
     * @throws Exception
     */
    public Settings() throws Exception
    {
        xml = new XMLHandler("1", "backtrack", "sudoku.txt", ".\\files\\settingsDefault.xml");
    }
    public String getLevel()
    {
        return xml.getLevel();
    }
    public String getOuput()
    {
        return xml.getOutput();
    }
    public String getAlgorithm()
    {
        return xml.getAlgorithm();
    }
    public String getXMLLevel()
    {
        return xml.getLevel();
    }
    /**
     * this method set the level attribute
     * 
     * @param level
     *            input parameter for assign to attribute
     * @throws IOException
     * @throws JDOMException
     */
    public void setLevel(String level) throws JDOMException, IOException
    {
        xml.setConfigLevel(level);
    }
    public void setAlgorithm(String algorithm) throws JDOMException, IOException
    {
        xml.setConfigAlgorithm(algorithm);
    }
    public void setOutput(String output) throws JDOMException, IOException
    {
        xml.setConfigOutput(output);
    }
    public void setPath(String path) throws JDOMException, IOException
    {
        xml.setConfigPath(path);
    }
    public void writeXmlSettings() throws Exception
    {
        xml.writeXML();
    }
    public void readXmlSettings() throws Exception
    {
        xml.readXML();
    }
}
