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
import sudoku.Settings;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLHandler {
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
    public XMLHandler(String path)
    {
        builder = new SAXBuilder();
        xmlFile = new File(path);
    }

    /***
     * This method write the xml file in a certain path with next information level settings output settings algorithm settings path settings
     */
    public void writeXML(Settings setting)
    {
        try
        {
            
            Element settings = new Element("settings");
            Document document = new Document(settings);
            Element level = new Element("level");
            level.setText(setting.getLevel());
            Element output = new Element("output");
            output.setText(setting.getOutput());
            Element algorithm = new Element("algorithm");
            algorithm.setText(setting.getAlgorithm());
            Element path = new Element("path");
            path.setText(setting.getPath());
            document.getRootElement().addContent(level);
            document.getRootElement().addContent(output);
            document.getRootElement().addContent(algorithm);
            document.getRootElement().addContent(path);
            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            OutputStream outPutStream = new FileOutputStream(this.xmlFile);
            xmlOutput.output(document, outPutStream); 
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
    public Settings readXML(Settings settings)
    {
       
        try
        {
            
            Document document = (Document) builder.build(xmlFile);
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren("settings");
            for (int i = 0; i < list.size(); i++)
            {
                Element node = (Element) list.get(i);
                settings.setLevel(node.getChildText("level")); 
                settings.setOutput(node.getChildText("output")); 
                settings.setAlgorithm(node.getChildText("algorithm"));;
                settings.setPath(node.getChildText("path")) ;
            }
            
        } catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return settings;
    }

    public void setXmlNode(String nodeName,String nodeValue)
    {
        try
        {
            SAXBuilder builder = new SAXBuilder();
            Document doc = (Document) builder.build(xmlFile);
            Element rootNode = doc.getRootElement();
            Element pathElement = rootNode.getChild(nodeName);
            pathElement.setText(nodeValue);
           
        } catch (JDOMException exception)
        {
            exception.printStackTrace();
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
