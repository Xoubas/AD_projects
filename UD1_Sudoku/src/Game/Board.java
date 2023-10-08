package Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

public class Board {
	public final char[][][] grid;
	private final int size;

	public Board() {
		size = 3;
		grid = new char[9][3][3];
	}

	public Board(int n) {
		size = n;
		int boxes = n * n;
		grid = new char[boxes][n][n];
	}

	public void setGrid(HashSet<Character> hs) {
		for (int i = 0; i < grid.length; i++) {
			grid[i] = fillBox(hs);
		}
	}

	private char[][] fillBox(HashSet<Character> hs) {
		char[][] box = new char[size][size];
		LinkedHashSet<Character> newSym = shuffleSymbols(hs);
		Iterator<Character> ite = newSym.iterator();
		for (int j = 0; j < grid[0].length; j++) {
			for (int k = 0; k < grid[0][0].length; k++) {
				box[j][k] = ite.next();
			}
		}
		if (checkBox(box))
			fillBox(newSym);

		return box;
	}

	private boolean checkBox(char[][] box) {
		boolean result = false;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				for (int k = 0; k < grid[0][0].length; k++) {
					if (box[j][k] != grid[i][j][k]) {
						result = false;
					}

					else {
						result = true;
						break;
					}
				}
			}
		}
		return result;
	}

	private LinkedHashSet<Character> shuffleSymbols(HashSet<Character> hs) {
		ArrayList<Character> al = new ArrayList<Character>(hs);
		Collections.shuffle(al);
		LinkedHashSet<Character> symbols = new LinkedHashSet<Character>(al);
		return symbols;
	}

	public char[][][] getGrid() {
		return grid;
	}

	public void printGrid() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				for (int k = 0; k < grid[0][0].length; k++) {
					System.out.println(grid[i][j][k]);
				}
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public static void main(String[] args) {
		Board name = new Board();
		HashSet<Character> hs = new HashSet<Character>();
		char[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8' };
		for (char c : arr)
			hs.add(c);
		name.setGrid(hs);
		name.printGrid();
	}
}
