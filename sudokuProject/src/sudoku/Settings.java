package sudoku;

import java.io.IOException;
import org.jdom2.JDOMException;
import org.w3c.dom.DOMException;
import sudoku.io.XMLHandler;

public class Settings {
    private XMLHandler xml;

    /***
     * this method is the constructor of the class
     * 
     * @param level
     *        keep the level of sudoku game
     * @param algorithm
     *        keep the algorithm used to solve the sudoku
     * @param output
     *        keep the output name of the xml file
     */
    public Settings(String level, String algorithm, String output, String path)
    {
        xml = new XMLHandler(level, algorithm, output, path);
    }

    /***
     * This is a constructor of settings object with default values and without parameters
     */
    public Settings()
    {
        String defaultLevel = "1";
        String defaultAlgorithm = "backtrack";
        String defaultOutput = "sudoku.txt";
        String defaultPath = ".\\files\\settingsDefault.xml";
        xml = new XMLHandler(defaultLevel, defaultAlgorithm, defaultOutput, defaultPath);
    }

    /***
     * This method return the level value
     * 
     * @return the return should by type String
     */
    public String getLevel()
    {
        return xml.getLevel();
    }

    /***
     * This method return the output value
     * 
     * @return the return should by type String
     */
    public String getOuput()
    {
        return xml.getOutput();
    }

    /***
     * This method return the algorithm value
     * 
     * @return the return should by type String
     */
    public String getAlgorithm()
    {
        return xml.getAlgorithm();
    }

    /***
     * This method return the path value
     * 
     * @return the return should by type String
     */
    public String getPath()
    {
        return xml.getPath();
    }

    /***
     * This method return the level value
     * 
     * @return the return should by type String
     */
    public String getXMLLevel()
    {
        return xml.getLevel();
    }

    /**
     * this method set the level attribute
     * 
     * @param level
     *        input parameter represent the new value that take the level settings
     */
    public void setLevel(String level)
    {
        xml.setConfigLevel(level);
    }

    /**
     * this method set the algorithm attribute
     * 
     * @param algorithm
     *        input parameter represent the new value that take the algorithm settings
     */
    public void setAlgorithm(String algorithm)
    {
        xml.setConfigAlgorithm(algorithm);
    }

    /**
     * this method set the output attribute
     * 
     * @param output
     *        input parameter represent the new value that take the output settings
     */
    public void setOutput(String output)
    {
        xml.setConfigOutput(output);
    }

    /**
     * this method set the path attribute
     * 
     * @param path
     *        input parameter represent the new value that take the path settings
     */
    public void setPath(String path)
    {
        xml.setConfigPath(path);
    }

    /***
     * This method write the settings config into a xml file calling writeXML method of XMLHandler class
     */
    public void writeXmlSettings()
    {
        xml.writeXML();
    }

    /***
     * This method read the xml file settings calling readXML method of XMLHandler class
     */
    public void readXmlSettings()
    {
        xml.readXML();
    }
}
