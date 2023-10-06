package Game;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Alphabet {
	private final static HashSet<Character> symbols = new HashSet<>();

	public Alphabet() {
		char[] arr = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		for (char c : arr)
			symbols.add(c);
	}

	public Alphabet(int n) {
		this();

		switch (n) {
		case 2: {
			trimAlphabet2();
			break;
		}
		case 3: {
			break;
		}
		case 4: {
			addAlphabet4();
			break;
		}
		case 5: {
			addAlphabet5();
			break;
		}
		default: {
			System.out.println("gei");
			break;
		}
		}

	}

	private void trimAlphabet2() {
		Iterator<Character> ite = symbols.iterator();
		while (ite.hasNext()) {
			int n = Character.getNumericValue(ite.next());
			if (n > 4)
				ite.remove();
		}
	}

	private void addAlphabet4() {
		for (char c = 'A'; c <= 'F'; c++)
			symbols.add(c);
	}

	private void addAlphabet5() {
		for (char c = 'A'; c <= 'N'; c++)
			symbols.add(c);
		symbols.add('Ñ');
	}

	public int getSize() {
		return symbols.size();
	}

	public static HashSet<Character> getSymbols() {
		return symbols;
	}

	@Override
	public int hashCode() {
		return Objects.hash(symbols);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alphabet other = (Alphabet) obj;
		return Objects.equals(symbols, other.symbols);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return symbols.toString();
	}
}
