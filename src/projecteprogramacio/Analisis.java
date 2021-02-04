package projecteprogramacio;

import java.io.*;

public class Analisis {

    private int palabras = 0;
    private int linias = 0;
    private int caracteres = 0;

    public void analisis(String nomFitxer) throws IOException {
        caracteres(nomFitxer);
        palabras(nomFitxer);
        linias(nomFitxer);

        System.out.println("Hi ha un total de " + caracteres + " caracters");
        System.out.println("Hi ha un total de " + palabras + " paraules");
        System.out.println("Hi ha un total de " + (linias + 1) + " linies");
    }

    public void caracteres(String nombreFichero) throws IOException {
        FileReader input;

        input = new FileReader(nombreFichero);
        BufferedReader bufIn = new BufferedReader(input);

        int lectura = bufIn.read();
        while (lectura != -1) {
            if (lectura >= ' ') { //Evitamos contabilizar los saltos de linia como caracteres
                caracteres++;
            }
            lectura = bufIn.read();
        }
        bufIn.close();
        input.close();
    }

    public void linias(String nombreFichero) throws IOException {
        FileReader input;

        input = new FileReader(nombreFichero);
        BufferedReader bufIn = new BufferedReader(input);

        int lectura = bufIn.read();
        while (lectura != -1) {
            if (lectura == 10) {//El 10 es equivalente al salto de linia
                linias++;
            }
            lectura = bufIn.read();
        }
        bufIn.close();
        input.close();
    }

    public void palabras(String nombreFichero) throws IOException {
        PalabraFicheroIn pi;
        pi = new PalabraFicheroIn(nombreFichero);
        //leemos hasta quedarnos sin palabras
        while (pi.hayPalabras()) {
            pi.lectura();
            palabras++;
        }
        //cerramos el archivo
        pi.cerrarFichero();
    }
}
