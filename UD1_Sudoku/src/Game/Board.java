package Game;

import java.util.HashSet;

public class Board {
	private final char[][][] grid;

	public Board() {
		grid = new char[3][3][3];
	}

	public Board(int n) {
		grid = new char[n][n][n];
	}

	public void setGrid(HashSet<Character> hs) {
		
	}
}
