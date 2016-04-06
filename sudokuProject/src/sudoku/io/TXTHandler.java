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

    public TXTHandler(String path)
    {
        try
        {
            txtFile = new File(path);
            scanner = new Scanner(txtFile);
        } catch (FileNotFoundException exception)
        {
            exception.printStackTrace();
        }
    }

    public String readTXTFile() {
        String fileContent="";
        while(scanner.hasNextLine()){
            fileContent = scanner.nextLine();

        }       
        return fileContent;
   }
    public int[][] parseToMatrix(String txtReaded) {
        int[][] grid = new int[9][9];
        List<String> rows = new ArrayList<String>();
        int index = 0;
        while (index < txtReaded.length()) {
            rows.add(txtReaded.substring(index, Math.min(index + 9,txtReaded.length())));
            index += 9;
        }
        for (int i = 0; i < rows.size(); i++)
        {
            String[] col = rows.get(i).split("(?!^)");
            for (int j = 0; j < 8; j++) {
                grid[i][j] = Integer.parseInt(col[j]);
            }
        }
        return grid;
    }

    public void writeTXT(String matrix)
    {
        FileWriter fWriter;
        try
        {
            fWriter = new FileWriter (txtFile);
            PrintWriter pWriter = new PrintWriter (fWriter);
            pWriter.println (matrix);
            pWriter.close();
        } catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }
}
