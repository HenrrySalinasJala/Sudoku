package sudoku;

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
	public void setXMLLevel(String level)
	{
		xml.setConfigLevel(level);
	}
}
