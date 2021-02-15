package projecteprogramacio;

import java.io.*;

public class Analisis {
    
    /*
    FUNCIONALITAT: duu a terme l'anàlisi inicial, del número de caràcters,
    paraules i línies que formen el fitxer a tractar.
    */

    //Declaracions dels atributs.
    private static int palabras;
    private static int linias;
    private static int caracteres;

    //Metode principal que s'encarrega d'imprimir l'informacio basica del fitxer 
    public static boolean analisis(String nomFitxer) throws Exception {
        palabras = 0;
        linias = 0;
        caracteres = 0;

        numCaracteresTotal(nomFitxer);
        numPalabrasTotal(nomFitxer);
        numLiniasTotal(nomFitxer);
        
        System.out.println("Hay un total de " + caracteres + " caracteres");
        System.out.println("Hay un total de " + palabras + " palabras");
        System.out.println("Hay un total de " + linias + " linias");

        if (caracteres == 0) {     //Retorna true si el fitxer esta buit
            System.out.println("El fichero deseado esta vacio. Ninguna opción del menu es aplicable");
            return true;
        } else {
            return false;
        }
    }

    //Metode que conta el nombre de caracters del fitxer.
    private static void numCaracteresTotal(String nombreFichero) throws IOException {
        FileReader input;
        BufferedReader bufIn;

        input = new FileReader(nombreFichero);
        bufIn = new BufferedReader(input);

        int lectura = bufIn.read();
        while (lectura != -1) {
            //Evitam contar els salts de linies com caracters.
            if (lectura >= ' ') { 
                caracteres++;
            }
            lectura = bufIn.read();
        }
        bufIn.close();
        input.close();
    }

    //Mètode que conta el nombre de linias del fitxer.
    private static void numLiniasTotal(String nombreFichero) throws Exception {
        LiniaFicheroIn li;
        li = new LiniaFicheroIn(nombreFichero);
        //Llegim fins quedarnos sense paraules.
        while (li.hayLineas()) {
            li.lectura();
            linias++;
        }
        //Tancam l'arxiu.
        li.cerrarFichero();
    }

    //Mètode que conta el nombre de paraules del fitxer.
    private static void numPalabrasTotal(String nombreFichero) throws IOException {
        PalabraFicheroIn pi;
        pi = new PalabraFicheroIn(nombreFichero);
        //Llegim fins quedarnos sense linies.
        while (pi.hayPalabras()) {
            pi.lectura();
            palabras++;
        }
        //Tancam l'arxiu.
        pi.cerrarFichero();
    }
    

}
