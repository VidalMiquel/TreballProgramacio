package projecteprogramacio;

import java.io.*;

public class Analisis {
    //ATRIBUTS
    private int palabras;
    private int linias;
    private int caracteres;

    //Metode constructor
    public Analisis() {
        palabras = 0;
        linias = 0;
        caracteres = 0;
    }
    //Metode principal que s'encarrega d'imprimir l'informacio basica del fitxer 
    public void analisis(String nomFitxer) throws IOException {
        caracteres(nomFitxer);
        palabras(nomFitxer);
        linias(nomFitxer);

        System.out.println("Hi ha un total de " + caracteres + " caracters");
        System.out.println("Hi ha un total de " + palabras + " paraules");
        System.out.println("Hi ha un total de " + (linias + 1) + " linies");
    }
    //Metode que conta el nombre de caracters del fitxer
    private void caracteres(String nombreFichero) throws IOException {
        FileReader input;

        input = new FileReader(nombreFichero);
        BufferedReader bufIn = new BufferedReader(input);

        int lectura = bufIn.read();
        while (lectura != -1) {
            if (lectura >= ' ') { //Evitam contar els salts de linies com caracters
                caracteres++;
            }
            lectura = bufIn.read();
        }
        bufIn.close();
        input.close();
    }
    //Metode que conta el nombre de linias del fitxer
    private void linias(String nombreFichero) throws IOException {
        FileReader input;

        input = new FileReader(nombreFichero);
        BufferedReader bufIn = new BufferedReader(input);

        int lectura = bufIn.read();
        while (lectura != -1) {
            if (lectura == 10) {//El 10 equival al salt de linia
                linias++;
            }
            lectura = bufIn.read();
        }
        bufIn.close();
        input.close();
    }
    //Metode que conta el nombre de paraules del fitxer
    private void palabras(String nombreFichero) throws IOException {
        PalabraFicheroIn pi;
        pi = new PalabraFicheroIn(nombreFichero);
        //Llegim fins quedarnos sense paraules
        while (pi.hayPalabras()) {
            pi.lectura();
            palabras++;
        }
        //Tancam l'arxiu
        pi.cerrarFichero();
    }
    //metode que retorna el nombre de caracters
    public int getCaracteres() {
        return caracteres;
    }

}
