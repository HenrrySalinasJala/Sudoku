package sudoku.ui;

import java.util.Scanner;
import sudoku.Settings;

public class sudokuUI {
    public int settingIntOption;
    public String settingStringOption;
    public static Scanner input;
    public Settings setting;

    public sudokuUI()
    {
        setting = new Settings();
        setting.writeXmlSettings();
        setting.readXmlSettings();
        input = new Scanner(System.in);
    }

    public void start()
    {
        mainMenu();
        int option = readIntegerInput();
        System.out.println(option);
        switch (option)
        {
            case 1:
                printSettigMenu();
                break;
            default:
                break;
        }
        // input.close();
        start();
    }

    public void mainMenu()
    {
        System.out.println("\tSUDOKU GAME SOLVER\n\t===================");
        System.out.println("Insert a number for select one of the next optios:\n");
        System.out.println("1. Configure Settings\n");
        System.out.println("2. Solve a Sudoku from .txt file\n");
    }

    public void printTitle()
    {
        System.out.println("\tSUDOKU GAME SOLVER\n\t===================");
    }

    public void readSettingsMenu(int optionSelected)
    {
        switch (optionSelected)
        {
            case 1:
                printSetLevel();
                setLevel(readStringInput());
                break;
            case 2:
                printSetOutput();
                setOutput(readStringInput());
                break;
            case 3:
                printSetAlgorithm();
                setAlgorithm(readStringInput());
                break;
            case 4:
                printCurrentSettings();
                break;
            default:
                break;
        }
        setting.writeXmlSettings();
    }

    public void printSettigMenu()
    {
        System.out.println("\tSudoku Config\n\t=============");
        System.out.println("Insert a number for select one of the next options:\n");
        System.out.println("1. Set Level\n");
        System.out.println("2. Set Output\n");
        System.out.println("3. Set Algorithm\n");
        System.out.println("4. Show Current Settings\n");
        System.out.println("5. Go to Main Menu\n\n");
        readSettingsMenu(readIntegerInput());
        printSettigMenu();
    }

    public void setLevel(String levelSelected)
    {
        setting.setLevel(levelSelected);
    }

    public void setOutput(String outputSelected)
    {
        setting.setOutput(outputSelected);
    }

    public void setAlgorithm(String algorithmSelected)
    {
        setting.setAlgorithm(algorithmSelected);
    }

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

    public void printSetAlgorithm()
    {
        System.out.println("Select New Algorithm: \n");
        System.out.println("1. Backtrack\n");
        System.out.println("2. Noigl\n");
        System.out.println("3. Other\n");
    }

    public void printCurrentSettings()
    {
        System.out.println("Current Level: " + setting.getLevel() + "\n");
        System.out.println("Current Output: " + setting.getOutput() + "\n");
        System.out.println("Current Algorithm: " + setting.getAlgorithm() + "\n");
    }

    /**
     * @return
     */
    private int readIntegerInput()
    {
        settingIntOption = input.nextInt();
        return settingIntOption;
    }

    private String readStringInput()
    {
        settingStringOption = input.next();
        return settingStringOption;
    }
}
