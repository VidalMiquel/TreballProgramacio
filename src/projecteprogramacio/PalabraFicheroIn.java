package projecteprogramacio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PalabraFicheroIn {

    private BufferedReader BufferedFicheroIn = null;
    private FileReader FileFicheroIn = null;
    private static final int FINAL_FICHERO = -1;
    private static final int ESPACIO = (int) ' ';
    private static final int SALTO_LINEA = (int) '\n';
    private static final int RETURN = (int) '\r';
    private int caracter = ESPACIO;
    private int linea;
    private int columna;

    public PalabraFicheroIn(String nombreFichero) throws FileNotFoundException {
        FileFicheroIn = new FileReader(nombreFichero);
        BufferedFicheroIn = new BufferedReader(FileFicheroIn);
    }

    public void cerrarFichero() throws IOException {
        BufferedFicheroIn.close();
    }

    public boolean hayPalabras() throws IOException {
        buscarPalabras();
        return (caracter != FINAL_FICHERO);
    }

    //revisar que aquets son els caracters que no alfabètics dins el fitxer
    private boolean esSeparador(int caracter) {
        return ((caracter == ',') || (caracter == '.') || (caracter == ':') || (caracter == '@') || (caracter == '?')
                || (caracter == '!') || (caracter == '"') || (caracter == '(') || (caracter == ')') || (caracter == '<')
                || (caracter == '>'));
    }

    private void buscarPalabras() throws IOException {
        while ((caracter == ESPACIO) || (caracter == RETURN) || (caracter == SALTO_LINEA)
                || (esSeparador(caracter))) {
            actualizacionLineaColumna();
            caracter = BufferedFicheroIn.read();
        }
    }

    public Palabra lectura() throws IOException {

        Palabra palabra = new Palabra();

        boolean asignacionPosicion = false;
        while ((caracter != FINAL_FICHERO) && (caracter != ESPACIO) && (caracter != RETURN)
                && (caracter != SALTO_LINEA) && (!esSeparador(caracter))) {
            if (!asignacionPosicion) {
                palabra.putLinea(linea);
                palabra.putColumna(columna);
                asignacionPosicion = true;
            }
            actualizacionLineaColumna();

            palabra.añadirCaracter((char) caracter);

            caracter = BufferedFicheroIn.read();
        }

        return palabra;
    }

    public void actualizacionLineaColumna() {
        if (caracter == SALTO_LINEA) {
            linea++;
            columna = 1;
        } else {
            columna++;
        }
    }
}
