package juego;

public class Classmain {
	public static void main(String[] args) {
		Tablero tab = new Tablero();
		Ficha fi = new Ficha(TipoFichas.CIRCULO);
		System.out.println(fi.toString());
		
		tab.addFicha(1, 1, new Ficha(TipoFichas.CIRCULO));
		tab.addFicha(0, 0, new Ficha(TipoFichas.CIRCULO));
		tab.addFicha(2, 2, new Ficha(TipoFichas.CIRCULO));
		
		System.out.println(tab.isWinner());
		System.out.println(tab.toString());
	}
}
