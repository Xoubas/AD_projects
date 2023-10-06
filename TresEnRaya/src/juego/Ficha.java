package juego;
import java.util.Objects;

public class Ficha implements Comparable<Ficha> {

	private final TipoFichas tipo;

	//Constructor
	public Ficha() {
		this.tipo = TipoFichas.VACIA;
	}
	
	public Ficha(TipoFichas tipo) {
		this.tipo = tipo;
	}

	public TipoFichas getTipo() {
		return tipo;
	}

	public boolean isEmpty() {
		return this.tipo == null || this.tipo == TipoFichas.VACIA;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ficha other = (Ficha) obj;
		return tipo == other.tipo;
	}

	@Override
	public int compareTo(Ficha f) {
		if (tipo == f.tipo)
			return 0;

		if (tipo == TipoFichas.CRUZ)
			return -1;

		return 1;
	}

	@Override
	public String toString() {
		return tipo.toString();
	}
}
