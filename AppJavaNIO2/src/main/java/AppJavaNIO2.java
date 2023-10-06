import java.io.IOException;
import java.nio.file.*;

public class AppJavaNIO2 {
	public static void main(String[] args) throws IOException {
		Path p = Paths.get("/home/stx/Escritorio/git.txt");
		Path p2 = Paths.get("/home/stx/Escritorio/gitCopy.txt");
		if (Files.exists(p)) {
			System.out.println("Exists");
			Files.copy(p, p2);
		}
	}
}
