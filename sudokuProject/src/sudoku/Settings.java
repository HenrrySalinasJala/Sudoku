package sudoku;

import org.w3c.dom.DOMException;

import sudoku.io.XMLHandler;

public class Settings {
	private String		level;
	private String		output;
	private String		algorithm;
	private XMLHandler	xml;

	public Settings(String level, String algorithm, String output) throws Exception 
	{
		this.level = level;
		this.output = output;
		this.algorithm = algorithm;
		xml=new XMLHandler(level, algorithm, output);
	}
	public Settings() throws Exception
	{
		this.level = "1";
		this.algorithm = "Backtrack";
		this.output = "sudokuDefaultConfig.xml";
		xml=new XMLHandler(level, algorithm, output);
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
	
	public void setLevel(String level) {
		this.level=level;
		xml.setConfigLevel(level);
	}
	public void setAlgorithm(String algorithm)
	{
		this.algorithm=algorithm;
		xml.setConfigOutput(algorithm);	
	}
	public void setOutput(String output)
	{
		this.output=output;
		xml.setConfigOutput(output);	
	}
	public void writeXmlSettings() throws Exception
	{
		xml.writeXML();
	}
	public void readXmlSettings() throws  Exception
	{
		xml.readXML(output);
		level=xml.getLevel();
		algorithm=xml.getAlgorithm();
		output=xml.getOutput();
	}
}
