package Game;

import java.util.Random;

public class Sudoku {
	Board board;
	Alphabet alphabet;

	public Sudoku(int n) {
		alphabet = new Alphabet(n);
		board = new Board(n);
	}

	public Sudoku() {
		alphabet = new Alphabet();
		board = new Board();
	}

//	public static void main(String[] args) {
//		Sudoku name = new Sudoku();
//		Board b= name.board;
//		char[][][] grid= b.getGrid();
//		
//		for (int j = 0; j < grid[0].length; j++) {
//			for (int k = 0; k < grid[0].length; k++) {
//				for (int r = 0; r < grid[0][0].length; r++) {
//					System.out.println(grid[j][k][r]);
//			}
//		}
//	}
//}
}
