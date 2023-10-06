package juego;

public class Tablero {
	final Ficha[][] tab = new Ficha[3][3];

	public Tablero() {
		for (int x = 0; x < tab.length; x++) {
			for (int y = 0; y < tab.length; y++) {
				tab[x][y] = new Ficha();
			}
		}
	}

	// Check empty coordinates and ranges
	private boolean isEmpty(int x, int y) {
		return this.tab[x][y].isEmpty();
	}

	private boolean err(int x, int y) {
		boolean emp = isEmpty(x, y);
		return !((x < 0 || x > 2 || y < 0 || y > 2) && emp == true);
	}

	public void addFicha(int x, int y, Ficha fi) {
		boolean error = err(x, y);

		if (error == true) {
			this.tab[x][y] = fi;
			System.out.println("Ficha añadida");
		}

		else
			System.out.println("No se pudo añadir la ficha");
	}

	private boolean isFull(int x, int y) {
		for (int x1 = 0; x1 < tab.length; x1++) {
			for (int y1 = 0; y1 < tab.length; y1++) {
				if (this.tab[x1][y1].getTipo().equals(TipoFichas.VACIA))
					return false;
			}
		}
		return true;
	}

	public Ficha[][] getTab() {
		return tab;
	}

	// Check winner
	public boolean isWinner() {
		for (int x = 0; x < tab.length; x++) {
			if (tab[0][x].getTipo() != TipoFichas.VACIA && (tab[0][x] == (tab[1][x]) && (tab[1][x] == (tab[2][x]))))
				return true;

			if (tab[x][0].getTipo() != TipoFichas.VACIA && (tab[x][0] == (tab[x][1]) && (tab[x][1] == (tab[x][2]))))
				return true;

			if (tab[0][0].getTipo() != TipoFichas.VACIA && (tab[0][0] == (tab[1][1]) && tab[1][1] == (tab[2][2])))
				return true;

			if (tab[2][0].getTipo() != TipoFichas.VACIA && (tab[2][0] == tab[1][1]) && tab[1][1] == tab[0][2])
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				sb.append(tab[x][y].getTipo().getCaracter());

				if (y < 2)
					sb.append(" | ");
			}
			sb.append("\n");
			if (x < 2)
				sb.append("---------\n");
		}

		return sb.toString();
	}

}
