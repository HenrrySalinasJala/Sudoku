package sudoku;

import java.io.IOException;
import org.jdom2.JDOMException;
import org.w3c.dom.DOMException;
import sudoku.io.XMLHandler;

public class Settings {

    private XMLHandler xml;
    private String level;
    private String output;
    private String algorithm;
    private String path;

    /***
     * this method is the constructor of the class
     * 
     * @param level keep the level of sudoku game
     * @param algorithm keep the algorithm used to solve the sudoku
     * @param output keep the output name of the xml file
     */
    public Settings(String level, String algorithm, String output, String path)
    {
        this.level = level;
        this.algorithm = algorithm;
        this.output = output;
        this.path = path;
        xml = new XMLHandler(this.path);
    }

    /***
     * This is a constructor of settings object with default values and without parameters
     */
    public Settings()
    {
        this.level = "1";
        this.algorithm = "backtrack";
        this.output = "sudoku.txt";
        this.path = ".\\files\\settingsDefault.xml";
    }

    /***
     * This method return the level value
     * 
     * @return the return should by type String
     */
    public String getLevel()
    {
        return this.level;
    }

    /***
     * This method return the output value
     * 
     * @return the return should by type String
     */
    public String getOutput()
    {
        return this.output;
    }

    /***
     * This method return the algorithm value
     * 
     * @return the return should by type String
     */
    public String getAlgorithm()
    {
        return this.algorithm;
    }

    /***
     * This method return the path value
     * 
     * @return the return should by type String
     */
    public String getPath()
    {
        return this.path;
    }

    /***
     * This method return the level value
     * 
     * @return the return should by type String
     */
    public String getXMLLevel()
    {
        return this.level;
    }

    /**
     * this method set the level attribute
     * 
     * @param level input parameter represent the new value that take the level settings
     */
    public void setLevel(String level)
    {
        this.level = level;
    }

    /**
     * this method set the algorithm attribute
     * 
     * @param algorithm input parameter represent the new value that take the algorithm settings
     */
    public void setAlgorithm(String algorithm)
    {
        this.algorithm = algorithm;
    }

    /**
     * this method set the output attribute
     * 
     * @param output input parameter represent the new value that take the output settings
     */
    public void setOutput(String output)
    {
        this.output = output;
    }

    /**
     * this method set the path attribute
     * 
     * @param path input parameter represent the new value that take the path settings
     */
    public void setPath(String path)
    {
        this.path = path;
    }

    /***
     * This method write the settings config into a xml file calling writeXML method of XMLHandler class
     */
    public void writeXmlSettings()
    {
        xml = new XMLHandler(this.path);
        xml.writeXML(this);
    }

    /***
     * This method read the xml file settings calling readXML method of XMLHandler class
     */
    public void readXmlSettings()
    {
        xml.readXML(this);
    }
}
