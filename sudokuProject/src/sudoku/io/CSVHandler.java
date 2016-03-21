package sudoku.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import com.csvreader.CsvWriter;
import com.csvreader.CsvReader;

public class CSVHandler {
	String spot1, spot2, spot3, spot4, spot5, spot6, spot7, spot8, spot9;

	public String getspot1()
	{
		return spot1;
	}
	public CSVHandler()
	{
		this.spot1 = "0";
		this.spot2 = "0";
		this.spot3 = "0";
		this.spot4 = "0";
		this.spot5 = "0";
		this.spot6 = "0";
		this.spot7 = "0";
		this.spot8 = "0";
		this.spot9 = "0";
	}
	public void csvRead()
	{
		try
		{
			CsvReader rsudoku = new CsvReader(".\\files\\filecsv.csv");
			while (rsudoku.readRecord())
			{
				spot1 = rsudoku.get(0);
				spot2 = rsudoku.get(1);
				spot3 = rsudoku.get(2);
				spot4 = rsudoku.get(3);
				spot5 = rsudoku.get(4);
				spot6 = rsudoku.get(5);
				spot7 = rsudoku.get(6);
				spot8 = rsudoku.get(7);
				spot9 = rsudoku.get(8);
			}
			rsudoku.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void csvWrite(String spot1, String spot2, String spot3, String spot4, String spot5, String spot6,
			String spot7, String spot8, String spot9)
	{
		String outputFile = ".\\files\\filecsv.csv";
		boolean alreadyExists = new File(outputFile).exists();
		try
		{
			CsvWriter csvOutput = new CsvWriter(new FileWriter(outputFile, true), ',');
			if (!alreadyExists)
			{
				setTitles(csvOutput);
			}
			csvOutput.write(spot1);
			csvOutput.write(spot2);
			csvOutput.write(spot3);
			csvOutput.write(spot4);
			csvOutput.write(spot5);
			csvOutput.write(spot6);
			csvOutput.write(spot7);
			csvOutput.write(spot8);
			csvOutput.write(spot9);
			csvOutput.endRecord();
			csvOutput.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	private static void setTitles(CsvWriter csvOutput)
	{
		try
		{
			csvOutput.write("A");
			csvOutput.write("B");
			csvOutput.write("C");
			csvOutput.write("D");
			csvOutput.write("E");
			csvOutput.write("F");
			csvOutput.write("G");
			csvOutput.write("H");
			csvOutput.write("I");
			csvOutput.endRecord();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
