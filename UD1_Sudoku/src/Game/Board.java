package Game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Board {
	private final char[][][] grid;

	public Board() {
		grid = new char[9][3][3];
	}

	public Board(int n) {
		int boxes = n * n;
		grid = new char[boxes][n][n];
	}

	public void setGrid(HashSet<Character> hs) {
		for (int i = 0; i < grid.length; i++) {
			grid[i] = fillBox(hs);
			checkBox(grid[i]);
		}
	}

	private char[][] fillBox(HashSet<Character> hs) {
		char[][] box = null;
		Iterator<Character> ite = hs.iterator();
		for (int j = 0; j < grid[0].length; j++) {
			for (int k = 0; k < grid[0][0].length; k++) {
				Random ran = new Random();
				int n = ran.nextInt(hs.size());
				while (n >= 0)
					box[j][k] = ite.next();
			}
		}
		return box;
	}

	private void checkBox(char[][] box) {
		for (int i = 0; i < grid[0].length; i++) {
			if (grid[i].equals(box)) {

			}
		}

	}

	public void shuffle() {

	}

	public void shuffleSymbols() {

	}
}
