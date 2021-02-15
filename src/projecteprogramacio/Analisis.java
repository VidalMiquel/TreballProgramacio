package projecteprogramacio;

import java.io.*;

public class Analisis {

    //ATRIBUTS
    private static int palabras;
    private static int linias;
    private static int caracteres;

    //Metode principal que s'encarrega d'imprimir l'informacio basica del fitxer 
    public static boolean analisis(String nomFitxer) throws IOException {
        palabras = 0;
        linias = 0;
        caracteres = 0;

        caracteres(nomFitxer);
        palabras(nomFitxer);
        linias(nomFitxer);

        System.out.println("Hay un total de " + caracteres + " caracteres");
        System.out.println("Hay un total de " + palabras + " palabras");
        System.out.println("Hay un total de " + (linias + 1) + " linias");

        if (caracteres == 0) {     //Retorna true si el fitxer esta buit
            System.out.println("El fichero deseado esta vacio. Ninguna opción del menu es aplicable");
            return true;
        } else {
            return false;
        }
    }

    //Metode que conta el nombre de caracters del fitxer
    private static void caracteres(String nombreFichero) throws IOException {
        FileReader input;
        BufferedReader bufIn;

        input = new FileReader(nombreFichero);
        bufIn = new BufferedReader(input);

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
    private static void linias(String nombreFichero) throws IOException {
        FileReader input;
        BufferedReader bufIn;
        
        input = new FileReader(nombreFichero);
        bufIn = new BufferedReader(input);

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
    private static void palabras(String nombreFichero) throws IOException {
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
    

}
