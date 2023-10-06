package juego;
public enum TipoFichas {
	CRUZ('X', -1), CIRCULO('O', 1), VACIA(' ', 0);

	private final char caracter;
	private final int valor;

	public char getCaracter() {
		return caracter;
	}
	
	public int getValor() {
		return valor;
	}

	private TipoFichas(char caracter, int valor) {
		this.caracter = caracter;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return String.valueOf(caracter);
	}
}
