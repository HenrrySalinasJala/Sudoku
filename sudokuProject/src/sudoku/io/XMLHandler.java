package sudoku.io;

import java.io.File;
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

    public XMLHandler(String level, String algorithm, String output, String path) throws Exception
    {
        builder = new SAXBuilder();
        xmlFile = new File(path);
        this.path = path;
        this.level = level;
        this.algorithm = algorithm;
        this.output = output;
    }
    public void writeXML() throws Exception
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
        OutputStream os = new FileOutputStream(this.xmlFile);
        xmlOutput.output(document, os);
    }
    public void readXML() throws JDOMException, IOException
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
    }
    public String getLevel()
    {
        return level;
    }
    public String getOutput()
    {
        return output;
    }
    public String getAlgorithm()
    {
        return algorithm;
    }
    public String getPath()
    {
        return path;
    }
    public void setConfigLevel(String level) throws JDOMException, IOException
    {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(this.path);
        Document doc = (Document) builder.build(xmlFile);
        Element rootNode = doc.getRootElement();
        Element levelElement = rootNode.getChild("level");
        levelElement.setText(level);
        this.level = levelElement.getText();
    }
    public void setConfigAlgorithm(String algorithm) throws JDOMException, IOException
    {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(this.path);
        Document doc = (Document) builder.build(xmlFile);
        Element rootNode = doc.getRootElement();
        Element algorithmElement = rootNode.getChild("algorithm");
        algorithmElement.setText(algorithm);
        this.algorithm = algorithmElement.getText();
    }
    public void setConfigOutput(String output) throws JDOMException, IOException
    {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(this.path);
        Document doc = (Document) builder.build(xmlFile);
        Element rootNode = doc.getRootElement();
        Element outputElement = rootNode.getChild("output");
        outputElement.setText(output);
        this.output = outputElement.getText();
    }
    public void setConfigPath(String path) throws JDOMException, IOException
    {
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(this.path);
        Document doc = (Document) builder.build(xmlFile);
        Element rootNode = doc.getRootElement();
        Element pathElement = rootNode.getChild("path");
        pathElement.setText(path);
        this.path = pathElement.getText();
    }
}
