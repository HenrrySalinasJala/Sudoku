package sudoku.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TXTHandler {

	private String path;
	private File txtFile;
	private Scanner scanner;

	public TXTHandler(String path) {
		try {
			txtFile = new File(path);
			scanner = new Scanner(txtFile);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * This method read a txt file and return the content into a String variable
	 * 
	 * @return keep the content readed of txt file
	 */
	public String readTXTFile() {
		String fileContent = "";
		while (scanner.hasNextLine()) {
			fileContent = scanner.nextLine();
		}
		return fileContent;
	}

	/***
	 * This method parse a String to Matrix
	 * 
	 * @param txtReaded
	 *            a variable that contain the value that should be parsed to
	 *            matrix
	 * @return the method should return a int matrix
	 */
	public int[][] parseToMatrix(String txtReaded) {
		int[][] grid = new int[9][9];
		List<String> rows = new ArrayList<String>();
		int index = 0;
		char[] arrayTxt = txtReaded.toCharArray();
		int row = 0;
		int col = 0;
		while (index < txtReaded.length()) {
			grid[(int) Math.ceil(row / index)][col] = arrayTxt[index];
			index += 1;
			col += 1;
			if (index % 8 == 0) {
				col = 0;
			}
		}
		return grid;
	}

	/***
	 * This method write some data into txt file
	 * 
	 * @param matrix
	 *            this parameter keep the data that should be wrote into txt
	 *            file
	 */
	public void writeTXT(String matrix) {
		FileWriter fWriter;
		try {
			fWriter = new FileWriter(txtFile);
			PrintWriter pWriter = new PrintWriter(fWriter);
			pWriter.println(matrix);
			pWriter.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}
