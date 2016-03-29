import java.util.Scanner;

import sudoku.GameBoard;
import sudoku.Settings;

public class Main {
    
    
    public static void main(String[] args)throws Exception
    {
        Settings setting = new Settings();
        setting.writeXmlSettings();
        setting.readXmlSettings();
        System.out.println("\tSUDOKU GAME SOLVER\n\t===================");
        System.out.println("Insert a number for select one of the next optios:\n");
        System.out.println("1. Configure Settings\n");
        System.out.println("2. Solve a Sudoku from .txt file\n");
        Scanner input = new Scanner(System.in);
        
        int mainOption=input.nextInt();
                    
        if(mainOption ==1) {
            System.out.println("\tSudoku Config\n\t=============");
            System.out.println("Insert a number for select one of the next optios:\n");
            System.out.println("1. Set Level\n");
            System.out.println("2. Set Output\n");
            System.out.println("3. Set Algorithm\n");
            System.out.println("4. Show Current Settings\n\n");
            int configOption=input.nextInt();
            
            if(configOption==1) {
                System.out.println("Select New Level: \n");
                System.out.println("1. Easy\n");
                System.out.println("2. Medium\n");
                System.out.println("3. Hard\n");
                String newLevel=input.next();
                setting.setLevel(newLevel);
            }else if(configOption==2) {
                System.out.println("Insert new output name: \n");
                String newOption=input.nextLine();
                setting.setOutput(newOption);
            }else if(configOption==3) {
                System.out.println("Select New Algorithm: \n");
                System.out.println("1. Backtrack\n");
                System.out.println("2. Noigl\n");
                System.out.println("3. Other\n");
                String newAlgorithm=input.nextLine();
                setting.setAlgorithm(newAlgorithm);
            }else if (configOption==4) {
                System.out.println("Current Level: "+setting.getLevel()+"\n");
                System.out.println("Current Output: "+setting.getOuput()+"\n");
                System.out.println("Current Algorithm: "+setting.getAlgorithm()+"\n");
            }
            
        }
        setting.writeXmlSettings();
        
        
        input.close();
        GameBoard sudo = new GameBoard();
        System.out.println("BEFORE\n");
        sudo.printGrid(sudo.getGrid());
        sudo.solveGrid();
        System.out.println("AFTER\n");
        sudo.printGrid(sudo.getGrid());
    }
}
