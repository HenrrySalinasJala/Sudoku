import java.util.Scanner;

import sudoku.GameBoard;
import sudoku.Settings;
import sudoku.ui.sudokuUI;

public class Main {
    
    
    public static void main(String[] args)throws Exception
    {
        
        
        sudokuUI sudoku=new sudokuUI();
        sudoku.start();
        /*
        GameBoard sudo = new GameBoard();
        System.out.println("BEFORE\n");
        sudo.printGrid(sudo.getGrid());
        sudo.solveGrid();
        System.out.println("AFTER\n");
        sudo.printGrid(sudo.getGrid());*/
    }

}
