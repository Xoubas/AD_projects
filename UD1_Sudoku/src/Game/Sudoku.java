package Game;

public class Sudoku {
	Board board;
	Alphabet alphabet;

	public Sudoku(int n) {
		alphabet = new Alphabet(n);
		board = new Board(n);
	}

}
