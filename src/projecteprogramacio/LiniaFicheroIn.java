package projecteprogramacio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LiniaFicheroIn {

    //Declaracions dels atributs
    private BufferedReader BufferedFicheroIn = null;
    private FileReader FileFicheroIn = null;
    private static final int FINAL_FICHERO = -1;
    private static final int RETURN = (int) '\r';
    private static final int SALTO_LINEA = (int) '\n';
    private int codigo = SALTO_LINEA;
    private int linia;
    private int columna;

    //Constructor que inicialitza el FileReader i el BufferedReader
    public LiniaFicheroIn(String nom) throws IOException {
        FileFicheroIn = new FileReader(nom);
        BufferedFicheroIn = new BufferedReader(FileFicheroIn);
    }

    //Metode que comprova si hi ha linies per llegir.
    public boolean hayLineas() throws Exception {
        codigo = BufferedFicheroIn.read();
        return (codigo != FINAL_FICHERO);
    }
    //Metode que llegeix linies
    public Linia lectura() throws Exception {
        Linia linea = new Linia();
        if (codigo == RETURN) {
            codigo = BufferedFicheroIn.read();
            return linea;
        }
        boolean asignacionPosicion = false;
        while ((codigo != FINAL_FICHERO) && (codigo != RETURN)) {
            if (!asignacionPosicion) {
                linea.putLinea(linia);
                linea.putColumna(columna);
                asignacionPosicion = true;
            }
            actualizacionLineaColumna();
            linea.añadirCaracter(codigo);
            codigo = BufferedFicheroIn.read();
        }
        return linea;
    }

    //Mètode que  incrementa el valor dels atributs linia i columna, segons
    //on es trobi la linia lletgida dins el fitxer.
    private void actualizacionLineaColumna() {
        if (codigo == SALTO_LINEA) {
            linia++;
            columna = 1;
        } else {
            columna++;
        }
    }

    //Mètode tanca l'enllaç amb el fitxer determinat.
    public void cerrarFichero() throws IOException {
        BufferedFicheroIn.close();
    }

}
