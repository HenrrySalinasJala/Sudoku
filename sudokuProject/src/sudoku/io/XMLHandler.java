package sudoku.io;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLHandler {
	private DocumentBuilderFactory	documentBuilderFactory	= DocumentBuilderFactory.newInstance();
	private DocumentBuilder			documentBuilder;
	private Document				document;
	private Element					configurations;
	private Attr					attribute;
	private Element					level;
	private Element					output;
	private Element					algorithm;
	private TransformerFactory		transformerFactory;
	private Transformer				transformer;
	private DOMSource				source;
	private StreamResult			streamResult;
	private NodeList				nodeList;
	private static String			elementName				= "configurations";

	public XMLHandler(String level, String algorithm, String output) throws Exception
	{
		documentBuilder = documentBuilderFactory.newDocumentBuilder();
		document = documentBuilder.newDocument();
		configurations = document.createElement(elementName);
		document.appendChild(configurations);
		setConfigLevel(level);
		setConfigAlgorithm(algorithm);
		setConfigOutput(output);
	}
	public void writeXML() throws Exception
	{
		this.transformerFactory = TransformerFactory.newInstance();
		this.transformer = transformerFactory.newTransformer();
		this.source = new DOMSource(this.document);
		this.streamResult = new StreamResult(new File(getOutput()));
		this.transformer.transform(source, streamResult);
	}
	public XMLHandler readXML(String path) throws Exception
	{
		this.document = documentBuilder.parse(path);
		nodeList = this.document.getElementsByTagName(elementName);
		for (int i = 0; i < nodeList.getLength(); i++)
		{
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element) node;
				String lev = element.getElementsByTagName("level").item(0).getTextContent();
				String alg = element.getElementsByTagName("algorithm").item(0).getTextContent();
				String ou = element.getElementsByTagName("output").item(0).getTextContent();
				this.level.setTextContent(lev);
				this.algorithm.setTextContent(alg);
				this.output.setTextContent(ou);
			}
		}
		return this;
	}
	public String getLevel()
	{
		return level.getTextContent();
	}
	public String getOutput()
	{
		return output.getTextContent();
	}
	public String getAlgorithm()
	{
		return algorithm.getTextContent();
	}
	public void setConfigLevel(String level)
	{
		this.level = document.createElement("level");
		this.level.appendChild(document.createTextNode(level));
		configurations.appendChild(this.level);
	}
	public void setConfigAlgorithm(String algorithm)
	{
		this.algorithm = document.createElement("algorithm");
		this.algorithm.appendChild(document.createTextNode(algorithm));
		configurations.appendChild(this.algorithm);
	}
	public void setConfigOutput(String output)
	{
		this.output = document.createElement("output");
		this.output.appendChild(document.createTextNode(output));
		configurations.appendChild(this.output);
	}
}
