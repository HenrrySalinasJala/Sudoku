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
     * @throws Exception
     */
    public Settings() throws Exception
    {
        xml = new XMLHandler("1", "backtrack", "sudoku.txt", ".\\files\\settingsDefault.xml");
    }
    /***
     * This method return the level value
     * @return
     */
    public String getLevel()
    {
        return xml.getLevel();
    }
    /***
     * This method return the output value
     * @return
     */
    public String getOuput()
    {
        return xml.getOutput();
    }
    /***
     * This method return the algorithm value
     * @return
     */
    public String getAlgorithm()
    {
        return xml.getAlgorithm();
    }
    
    public String getPath()
    {
        return xml.getPath();
    }
    
    /***
     * This method return the level value
     * @return
     */
    public String getXMLLevel()
    {
        return xml.getLevel();
    }
    /**
     * this method set the level attribute
     * @param level input parameter represent the new value that take the level settings
     * @throws IOException
     * @throws JDOMException
     */
    public void setLevel(String level) throws JDOMException, IOException
    {
        xml.setConfigLevel(level);
    }
    /**
     * this method set the algorithm attribute
     * @param algorithm input parameter represent the new value that take the algorithm settings
     * @throws IOException
     * @throws JDOMException
     */
    public void setAlgorithm(String algorithm) throws JDOMException, IOException
    {
        xml.setConfigAlgorithm(algorithm);
    }
    /**
     * this method set the output attribute
     * @param output input parameter represent the new value that take the output settings
     * @throws IOException
     * @throws JDOMException
     */
    public void setOutput(String output) throws JDOMException, IOException
    {
        xml.setConfigOutput(output);
    }
    /**
     * this method set the path attribute
     * @param path input parameter represent the new value that take the path settings
     * @throws IOException
     * @throws JDOMException
     */
    public void setPath(String path) throws JDOMException, IOException
    {
        xml.setConfigPath(path);
    }
    /***
     * This method write the settings config into a xml file
     * @throws Exception
     */
    public void writeXmlSettings() throws Exception
    {
        xml.writeXML();
    }
    /***
     * This method read the xml file settings
     * @throws Exception
     */
    public void readXmlSettings() throws Exception
    {
        xml.readXML();
    }
}
