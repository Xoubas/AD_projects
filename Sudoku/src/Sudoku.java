import java.util.HashSet;

public class Sudoku {
    private final HashSet<Character> alfabeto = new HashSet<Character>();
    private final char[][] celas;

    public Sudoku() {
        celas = fillEmpSud();
    }

    public Sudoku(char[] alfabeto) throws Exception {
        int size = alfabeto.length;

        // Calcula la raíz cuadrada del tamaño del alfabeto
        int sqrtSize = (int) Math.sqrt(size);

        // Verifica si el tamaño no es un cuadrado perfecto
        if (sqrtSize * sqrtSize != size) {
            throw new Exception("Tamaño de sudoku no válido");
        }

        // Inicializa el Sudoku con celdas vacías (0)
        celas = new char[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                celas[i][j] = 0;
    }

    public Sudoku(char[][] celas) throws Exception {
        int rows = celas.length;
        int cols = celas[0].length;

        if (rows != cols) {
            throw new Exception("Tamaño Sudoku no válido");
        }

        if ((int) (Math.sqrt(rows) * Math.sqrt(rows)) != rows) {
            throw new Exception("Tamaño Sudoku no válido");
        }


        this.celas = celas;
    }

    //Used for the empty constructor
    private char[][] fillEmpSud() {
        char[][] mat = new char[alfabeto.size()][alfabeto.size()];
        for (int i = 0; i < alfabeto.size(); i++)
            for (int x = 0; x < alfabeto.size(); x++)
                mat[i][x] = '0';

        return mat;
    }
}