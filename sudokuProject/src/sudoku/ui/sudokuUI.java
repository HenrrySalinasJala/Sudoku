package sudoku.ui;

import java.util.Scanner;
import sudoku.Settings;
    

public class sudokuUI {
    public int settingIntOption;
    public String settingStringOption;
    public static Scanner input;
    public Settings setting;
    public sudokuUI() throws Exception{
        setting = new Settings();
        setting.writeXmlSettings();
        setting.readXmlSettings();
        input = new Scanner(System.in);
    }
    
    public void start() {
        mainMenu();
        int option=readIntegerInput();
        System.out.println(option);
        if(option==1) {
            printSettigMenu();
        }
        input.close();
    }
    public void mainMenu()
    {
        System.out.println("\tSUDOKU GAME SOLVER\n\t===================");
        System.out.println("Insert a number for select one of the next optios:\n");
        System.out.println("1. Configure Settings\n");
        System.out.println("2. Solve a Sudoku from .txt file\n");
        
    }
    public void printTitle() {
        System.out.println("\tSUDOKU GAME SOLVER\n\t===================");

    }
    public void readSettingsMenu(int optionSelected) throws Exception {
        switch (optionSelected)
        {
            case 1:
                printSetLevel();
                break;
            case 2:
                printSetOutput();
                break;
            case 3:
                printSetAlgorithm();
                break;
            case 4:
                printCurrentSettings();
                break;
            default:
                break;
        }
        
        setting.writeXmlSettings();
    }
    public void printSettigMenu() {
        System.out.println("\tSudoku Config\n\t=============");
        System.out.println("Insert a number for select one of the next options:\n");
        System.out.println("1. Set Level\n");
        System.out.println("2. Set Output\n");
        System.out.println("3. Set Algorithm\n");
        System.out.println("4. Show Current Settings\n\n");
    }
    
    /**
     * 
     */
    private void printSetLevel()
    {
        System.out.println("Select New Level: \n");
        System.out.println("1. Easy\n");
        System.out.println("2. Medium\n");
        System.out.println("3. Hard\n");
    }
    private void printSetOutput()
    {
        System.out.println("Select New Output: \n");
        System.out.println("1. TXT File\n");
        System.out.println("2. CSV File\n");
    }
    public void printSetAlgorithm() {
        System.out.println("Select New Algorithm: \n");
        System.out.println("1. Backtrack\n");
        System.out.println("2. Noigl\n");
        System.out.println("3. Other\n");
    }
    public void printCurrentSettings() {
        System.out.println("Current Level: "+setting.getLevel()+"\n");
        System.out.println("Current Output: "+setting.getOuput()+"\n");
        System.out.println("Current Algorithm: "+setting.getAlgorithm()+"\n");
    }
    
    /**
     * @return
     */
    private int readIntegerInput()
    {
        settingIntOption=input.nextInt();
        return settingIntOption;
    }
    private String readStringInput() {
        settingStringOption=input.next();
        return settingStringOption;
    }
}
