package juego;
import java.awt.Point;
import java.util.Random;
import java.util.Scanner;

public class Game {
	private Tablero tab;
	private TipoFichas maquina;
	private Scanner sc;

	private TipoFichas fichaConsola() {
		Random rand = new Random();
		int num = rand.nextInt(2);

		if (num == 0)
			return TipoFichas.CRUZ;

		else
			return TipoFichas.CIRCULO;
	}

	public Game() {
		this.tab = new Tablero();
		this.maquina = fichaConsola();
		this.sc = new Scanner(System.in);
	}

	public static Point getCoordenadas(int pos) {
		int count = 0;
		Point p = null;

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				p = new Point(y, x);
				count++;
				if (count == pos)
					break;
			}
		}
		return p;
	}
}
