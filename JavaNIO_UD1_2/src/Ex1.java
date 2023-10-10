import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex1 {
	public static void main(String[] args) {
		/*
		 * a) Escribe un programa Java que compruebe si una ruta de archivo es absoluta o
		 * relativa y si existe.
		 */
		Path p1 = Paths.get("cosa.txt");
		Path p2 = Paths.get("/home/sanclemente.local/a21javierbq/Escritorio");

		System.out.println(p1.isAbsolute()+" "+p2.isAbsolute());
	}
}
