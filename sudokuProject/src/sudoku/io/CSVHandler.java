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

	/**
	 * This is the constructor of the class CSVHandler 
	 * @param output is used for the path of the file
	 */
	public CSVHandler(String output) {
		this.output = output;
		Cell cell = new Cell(0, 0);
	}

	/**
	 * This method read a csv file give a path e.g. .\\files\\namecsv.csv   
	 * @return is used for return the matrix that had been read 
	 */
	public int[][] csvRead() {
		int[][] grid = new int[9][9];
		try {
			CsvReader rsudoku = new CsvReader(output);
			List<String> spot = new ArrayList<String>();
			String grides = "";

			while (rsudoku.readRecord()) {
				grides += rsudoku.getRawRecord();
			}
			rsudoku.close();
			String[] parts = grides.split(",");
			parseLineIntoStringArray(grid, parts);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return grid;
	}
/**
 * This method split the string in a only field
 * @param grid the matrix of integer that should be numbers of 0 to 9 
 * @param parts is the string to be splited.
 */
	private void parseLineIntoStringArray(int[][] grid, String[] parts) {
		for (int i = 0; i < 8; i++) {
			String[] cell = parts[i].split("(?!^)");
			for (int j = 0; j < 8; j++) {
				grid[i][j] = Integer.parseInt(cell[j]);
			}
		}
	}

	/**
	 * This method write in a csv file
	 * @param grid shown the string to be converted.
	 * @param gridSize is the long of matrix write
	 */
	public void csvWrite(String grid, int gridSize) {
		boolean alreadyExists = new File(output).exists();
		try {
			CsvWriter csvOutput = new CsvWriter(new FileWriter(output, true), ',');
			List<String> spot = new ArrayList<String>();
			int index = 0;
			while (index < grid.length()) {
				spot.add(grid.substring(index, Math.min(index + gridSize, grid.length())));
				index += gridSize;
			}
			for (String row : spot) {
				csvOutput.write(row);
			}
			csvOutput.endRecord();
			csvOutput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}