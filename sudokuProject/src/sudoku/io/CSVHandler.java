package sudoku.io;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.ParseConversionEvent;

import java.io.File;
import java.io.FileWriter;
import com.csvreader.CsvWriter;
import sudoku.Cell;
import com.csvreader.CsvReader;

public class CSVHandler {

   private String output; 
    
    public CSVHandler(String output)   
    {
        this.output = output; 
        Cell cell=new Cell(0,0);        
    }
    public int[][] csvRead()
    {      int[][]  grid = new int[9][9]; 	
        try
        {
        		CsvReader rsudoku = new CsvReader(output);	
        		List<String> spot = new ArrayList<String>();
        		String grides="";

               while (rsudoku.readRecord())
			{
            	   grides+=rsudoku.getRawRecord();
                }
        		rsudoku.close(); 
                String[] parts = grides.split(",");
                for (int i = 0; i < 8; i++) 
                {
                	 
                	String []cell = parts[i].split("(?!^)");
                    for (int j = 0; j < 8; j++) {
						grid[i][j]= Integer.parseInt(cell[j]);
					}
                   
				}
               
        		
        		
            
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return grid;
		  
     }
    
    
    public void csvWrite(String grid,int gridSize)
    {       
        boolean alreadyExists = new File(output).exists();
        try
        {
            CsvWriter csvOutput = new CsvWriter(new FileWriter(output, true), ',');
            List<String> spot = new ArrayList<String>();
            int index = 0;
            while (index < grid.length()) {
                spot.add(grid.substring(index, Math.min(index + gridSize,grid.length())));
                index += gridSize;
            }
            for (String row : spot)
            {
                csvOutput.write(row);
            }
                 
            csvOutput.endRecord();
            csvOutput.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }        
    } 
}