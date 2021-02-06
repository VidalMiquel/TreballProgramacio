package projecteprogramacio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PalabraFicheroIn {
    
    /*
    FUNCIONALITAT: lectura des de el fitxer especificat d'una linia.
    */

    //Declaracions dels atributs
    private BufferedReader BufferedFicheroIn = null;
    private FileReader FileFicheroIn = null;
    private static final int FINAL_FICHERO = -1;
    private static final int ESPACIO = (int) ' ';
    private static final int SALTO_LINEA = (int) '\n';
    private static final int RETURN = (int) '\r';
    private int caracter = ESPACIO;
    private int linea;
    private int columna;

    //Constructor que inicialtza el FileReader i el BufferedReader.
    public PalabraFicheroIn(String nombreFichero) throws FileNotFoundException {
        FileFicheroIn = new FileReader(nombreFichero);
        BufferedFicheroIn = new BufferedReader(FileFicheroIn);
    }

    //Mètode que tancar l'enllaç amb el fixter.
    public void cerrarFichero() throws IOException {
        BufferedFicheroIn.close();
    }

    public boolean hayPalabras() throws IOException {
        buscarPalabras();
        return (caracter != FINAL_FICHERO);
    }

    //Mètode que comprova si el caràcter llegit es un separador del fitxer.
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

    //Mètode que  incrementa els atirbuts linia i columna, segons
    //on es trobi la linia lletgida dins el fitxer.
    private void actualizacionLineaColumna() {
        if (caracter == SALTO_LINEA) {
            linea++;
            columna = 1;
        } else {
            columna++;
        }
    }
}
