package sudoku.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import sudoku.Cell;



public class TXTHandler 
{
 private String output; 
 public ArrayList<String> lineas = null;
    
 public TXTHandler(String output)   
 {
    this.output = output;          
 }	
	
public void readTXT()
{
    File archivo = null;
	FileReader fr = null;
	ArrayList<String> lineas = new ArrayList<String>();
	try {
	archivo = new File (output);
	String linea;
	fr = new FileReader (archivo);
	BufferedReader br = new BufferedReader(fr);
	while((linea=br.readLine())!=null){
	lineas.add(linea);
	}	
	
	}
	catch(IOException e)
	{
	   System.out.println(e);
	}
	finally{
	try{ 
	if( fr != null){
	fr.close(); 
	}
	}catch (IOException e){
	}
	}
	System.exit(0);
}

public ArrayList<String> getlineas()
{
  return lineas;	
}

}	

