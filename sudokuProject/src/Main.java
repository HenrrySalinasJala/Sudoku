import sudoku.GameBoard;

public class Main {

	public static void main(String[] args) {
		GameBoard sudo=new GameBoard();
		System.out.println("BEFORE\n");
		sudo.printGrid(sudo.grid);
		
		sudo.solveGrid();
		System.out.println("AFTER\n");
		sudo.printGrid(sudo.grid);
	}

}
