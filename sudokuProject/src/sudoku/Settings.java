package sudoku;

import sudoku.io.XMLHandler;

public class Settings {
	private String level;
	private String output;
	private String algorithm;
	private XMLHandler xml;
	public Settings(String level,String algorithm,String output) throws Exception{
		xml=new XMLHandler(level,algorithm,output);
	}
	public String getLevel(){
		return xml.getLevel();
	}
	public void setLevel(String level){
		xml.setConfigLevel(level);
	}
}
