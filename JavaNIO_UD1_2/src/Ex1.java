import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex1 {
public static void main(String[] args) {
	 Path p = Paths.get("cosa.txt");
	 
	 System.out.println(p.isAbsolute());
}
}
