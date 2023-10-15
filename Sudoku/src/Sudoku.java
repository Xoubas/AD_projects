import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Sudoku {
    private final HashSet<Character> alfabeto = new HashSet<>();
    private char[][] celas;

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

        // Inicializa el Sudoku con celas vacías (0)
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

    public HashSet<Character> getAlfabeto() {
        return alfabeto;
    }

    //Used for the empty constructor

    private char[][] fillEmpSud() {
        char[][] mat = new char[getAlfabeto().size()][getAlfabeto().size()];
        for (int i = 0; i < getAlfabeto().size(); i++)
            for (int x = 0; x < getAlfabeto().size(); x++)
                mat[i][x] = '0';

        return mat;
    }

    public int getSize() {

        return this.celas.length;

    }

    public char[][] getcelas() {
        return celas;
    }

    /*
    public void setCelda(int i, int j, char c)
    Asigna el carácter c a la posición i, j del Sudoku. Debe comprobar que no excede
    los límites del Sudoku.
     */

    public void setCelda(int i, int j, char c) {

        if (i <= celas.length && j <= celas.length && getAlfabeto().contains(c)) {
            celas[i][j] = c;
        }

    }

    /*
    public void setcelas(char[][] celas)
    Asigna las celas al sudoku. Si el array de celas no es cuadrado perfecto de
    dimensiones posibles lanza una excepción (de tipo Exception) con el mensaje de
    “Tamaño de sudoku no válido”.
     */

    public void setcelas(char[][] celas) {
        this.celas = celas;

        if (celas.length != celas[0].length) {

            try {
                if (celas.length != celas[0].length) {
                    throw new Exception("Tamaño de sudoku no válido");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }
    }

    /*
    public char getCelda(int i, int j)
    Recoge las coordenadas y devuelve el carácter que está en esa posición. Debe
    comprobar que no excede los límites del Sudoku, en cuyo caso debe devolver 0
     */

    public char getCelda(int i, int j) {
        char c;
        if (i <= getAlfabeto().size() && j <= getAlfabeto().size()) {

            c = celas[i][j];
            return c;
        } else {
            c = 0;
            return c;
        }


    }

    /*
    public boolean isCompleted()
    Devuelve si el sudoku tiene todas las celas ocupadas, sin carácter 0.
     */

    public boolean isCompleted() {
        boolean completed = false;

        for (int i = 0; i < celas.length; i++) {
            for (int j = 0; j < celas[i].length; j++) {
                if (celas[i][j] == '0') {
                    completed = false;

                } else {
                    completed = true;

                }
            }
        }
        return completed;
    }

    private boolean comprobarLinea(int indiceLinea) {
        TreeSet<Character> linea = new TreeSet<>();
        boolean check = false;

        for (int i = 0; i < celas.length; i++) {
            for (int j = 0; j < celas.length; j++) {
                linea.add(celas[j][i]);
            }
            if (linea.size() != celas.length) {
                check = false;
                break;
            } else {
                linea.clear();
                check = true;
            }
        }


        return check;
    }

    private boolean comprobarColumna() {
        TreeSet<Character> columna = new TreeSet<>();
        boolean check = false;

        for (int i = 0; i < celas.length; i++) {
            for (int j = 0; j < celas.length; j++) {
                columna.add(celas[i][j]);
            }
            if (columna.size() != celas.length) {
                check = false;
                break;
            } else {
                columna.clear();
                check = true;
            }
        }

        return check;
    }

    private boolean comprobarCuadrado() {
        TreeSet<Character> cuadrado = new TreeSet<>();
        int tamCuadrado = (int) Math.sqrt(celas.length);
        boolean check = false;

        for (int i = 0; i < celas.length; i += tamCuadrado) {
            for (int j = 0; j < celas[0].length; j += tamCuadrado) {
                for (int x = i; x < i + tamCuadrado; x++) {
                    for (int y = j; y < j + tamCuadrado; y++) {
                        cuadrado.add(celas[i][j]);
                        check = (cuadrado.size() != celas.length) ? false : true;
                    }
                    return check;
                }
            }
        }
        return false;
    }

    public boolean isValid() {
        return comprobarLinea(0) && comprobarColumna() && comprobarCuadrado();
    }

    public void saveSudoku(String ruta) throws IOException {
        ObjectOutputStream os = null;
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(ruta));
            os.writeObject(this);
        } catch (IOException e) {
            throw new IOException(e);
        } finally {
            os.close();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < celas.length; i++) {
            for (int j = 0; j < celas[i].length; j++) {
                if (celas[i][j] == '0')
                    sb.append(" ");
                else
                    sb.append(celas[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}










