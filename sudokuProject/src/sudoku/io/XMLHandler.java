package sudoku.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javax.xml.transform.stream.StreamResult;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLHandler {
    String level;
    String output;
    String algorithm;
    String path;
    SAXBuilder builder;
    File xmlFile;
    private StreamResult streamResult;

    /***
     * This method is the constructor of XMLHandler
     * 
     * @param level
     *        this parameter represent the level of the game
     * @param algorithm
     *        this parameter represent the algorithm used for solve the game
     * @param output
     *        this parameter represent the type of output (.TXT, .CSV)
     * @param path
     *        this parameter represent the output path of xml setting file
     */
    public XMLHandler(String level, String algorithm, String output, String path)
    {
        builder = new SAXBuilder();
        xmlFile = new File(path);
        this.path = path;
        this.level = level;
        this.algorithm = algorithm;
        this.output = output;
    }

    /***
     * This method write the xml file in a certain path with next information level settings output settings algorithm settings path settings
     */
    public void writeXML()
    {
        try
        {
            Element settings = new Element("settings");
            Document document = new Document(settings);
            Element level = new Element("level");
            level.setText(this.level);
            Element output = new Element("output");
            output.setText(this.output);
            Element algorithm = new Element("algorithm");
            algorithm.setText(this.algorithm);
            Element path = new Element("path");
            path.setText(this.path);
            document.getRootElement().addContent(level);
            document.getRootElement().addContent(output);
            document.getRootElement().addContent(algorithm);
            document.getRootElement().addContent(path);
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            OutputStream os;
            os = new FileOutputStream(this.xmlFile);
        } catch (FileNotFoundException exception)
        {
            exception.printStackTrace();
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    /***
     * This method read the content of a xml file
     */
    public void readXML()
    {
        try
        {
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("settings");
            for (int i = 0; i < list.size(); i++)
            {
                Element node = (Element) list.get(i);
                this.level = node.getChildText("level");
                this.output = node.getChildText("output");
                this.algorithm = node.getChildText("algorithm");
                this.path = node.getChildText("path");
            }
        } catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     * This method get the current level value
     * 
     * @return the level field should be type String
     */
    public String getLevel()
    {
        return level;
    }

    /***
     * This method get the current output
     * 
     * @return the output value should be type String
     */
    public String getOutput()
    {
        return output;
    }

    /***
     * This method get the algorithm
     * 
     * @return the algorithm value should be type String
     */
    public String getAlgorithm()
    {
        return algorithm;
    }

    /***
     * This method return the current path value
     * 
     * @return the path value should be type String
     */
    public String getPath()
    {
        return path;
    }

    /***
     * This method set the level value but no write in xml file
     * 
     * @param level
     *        this parameter represent the new value that take the value field
     */
    public void setConfigLevel(String level)
    {
        try
        {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(this.path);
            Document doc = (Document) builder.build(xmlFile);
            Element rootNode = doc.getRootElement();
            Element levelElement = rootNode.getChild("level");
            levelElement.setText(level);
            this.level = levelElement.getText();
        } catch (JDOMException exception)
        {
            exception.printStackTrace();
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    /***
     * This method set the algorithm value but no write into xml file
     * 
     * @param algorithm
     *        this parameter represent the new value that take the algorithm field
     */
    public void setConfigAlgorithm(String algorithm)
    {
        try
        {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(this.path);
            Document doc = (Document) builder.build(xmlFile);
            Element rootNode = doc.getRootElement();
            Element algorithmElement = rootNode.getChild("algorithm");
            algorithmElement.setText(algorithm);
            this.algorithm = algorithmElement.getText();
        } catch (JDOMException exception)
        {
            exception.printStackTrace();
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    /***
     * This method set the output value but no write in file
     * 
     * @param output
     *        this parameter represent the new value that take the output field
     */
    public void setConfigOutput(String output)
    {
        try
        {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(this.path);
            Document doc = (Document) builder.build(xmlFile);
            Element rootNode = doc.getRootElement();
            Element outputElement = rootNode.getChild("output");
            outputElement.setText(output);
            this.output = outputElement.getText();
        } catch (JDOMException exception)
        {
            exception.printStackTrace();
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    /***
     * This method set the path value but no write in the file
     * 
     * @param path
     *        this parameter represent the new value that take the path field
     */
    public void setConfigPath(String path)
    {
        try
        {
            SAXBuilder builder = new SAXBuilder();
            File xmlFile = new File(this.path);
            Document doc = (Document) builder.build(xmlFile);
            Element rootNode = doc.getRootElement();
            Element pathElement = rootNode.getChild("path");
            pathElement.setText(path);
            this.path = pathElement.getText();
        } catch (JDOMException exception)
        {
            exception.printStackTrace();
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
