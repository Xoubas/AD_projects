import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class Classmain {
	public static void copyPath(Path o, Path d) {

		try {
			if (!Files.isDirectory(o) && o.getFileName().toString().endsWith(".java")) {
				Files.copy(o, d.resolve(o.getFileName()), StandardCopyOption.REPLACE_EXISTING);

			} else if (Files.isDirectory(o)) {
				Stream<Path> s = Files.list(o);
				s.close();
				s.forEach(p -> copyPath(p, d));
			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Path origin = Path.of("/home/sanclemente.local/a21javierbq/Documentos/AD/ADProjects");
		Path destiny = Path.of("/home/sanclemente.local/a21javierbq/JavaDestiny");

		Classmain.copyPath(origin, destiny);
	}
}
