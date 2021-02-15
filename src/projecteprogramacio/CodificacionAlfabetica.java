package projecteprogramacio;

import static java.lang.Math.abs;
import java.util.Random;

public class CodificacionAlfabetica {

    /*
    FUNCIONALITAT: duu a terme la codificació i la decodificació d'un fitxer.
     */
    //Declaracions dels atibuts
    private static final int NUMERO_CARACTERES = 37;
    private static final char[] ALFABETO = "abcdefghijklmnopqrstuvwxyz.,:@?!\"()<>".toCharArray();
    private int desplazamiento;

    //Constructor que inicialitza la classe Random i calcula el despalçament
    //segons la llavor passada per paràmetre.
    public CodificacionAlfabetica(int semilla) {
        Random generador = new Random(semilla * 1000);
        desplazamiento = (int) (generador.nextDouble() * NUMERO_CARACTERES);
    }

    //Mètode que obté el caràcter codificat del caràcter passat per paràmetre.
    private char codificar(char caracter) {
        if (valido(caracter)) {
            return ALFABETO[(posicion(caracter) + desplazamiento) % NUMERO_CARACTERES];
        } else {
            return caracter;
        }
    }

    //MÉTODO deCodificar LLEVA A TÉRMINO LA OBTENCIÓN DEL CARACTER DECODIFICADO
    //DEL CARACTER DADO POR PARÁMETRO
    //Mètode que obté el caràcter decodificat del caràcter passat per paràmete.
    private char deCodificar(char caracter) {
        if (valido(caracter)) {
            int valor = posicion(caracter) - desplazamiento;
            if (valor < 0) {
                valor = NUMERO_CARACTERES - abs(valor);
            }
            return ALFABETO[valor % NUMERO_CARACTERES];
        } else {
            return caracter;
        }
    }

    //Mètode que obté la posició en l'array alfabeto d'un caràcter passat per
    //paràmetre.
    private int posicion(char caracter) {
        int indice;
        for (indice = 0; caracter != ALFABETO[indice]; indice++) {
        }
        return indice;
    }

    //Mètode que verifica si un caràcter passat per paràmetre és un caràcter
    //que pot ser codificat o decodificat.
    private boolean valido(char caracter) {
        for (int indice = 0; indice < ALFABETO.length; indice++) {
            if (caracter == ALFABETO[indice]) {
                return true;
            }
        }
        return false;
    }

    //Mètode que engloba el procés de codificar el fitxer corresponent.
    public void codificarTexto(String fichero) throws Exception {
        //Inicialitzam els objectes per llegir i escriure linies.
        LiniaFicheroIn fich = new LiniaFicheroIn(fichero);
        LiniaFicheroOut fichCod = new LiniaFicheroOut(fichero + ".cod.txt");

        Linia secuencia;
        Linia auxiliar;
        int codigo;
        //Llegim linies des del fitxer especificat.
        while (fich.hayLineas()) {
            //Inicialitzam la linia auxiliar a la qual guardarem la 
            //linia codificada.
            auxiliar = new Linia();
            secuencia = fich.lectura();
            //Recorrem la linia llegida.
            for (int i = 0; i < secuencia.getNumeroCaracteres(); i++) {
                //Codifica caràcter a caràcter la linia llegida.
                codigo = (char) codificar(secuencia.obtenerCaracter(i));
                //Afegiex a la linia auxiliar, el caràcter codificat.
                auxiliar.añadirCaracter(codigo);
            }
            fichCod.escrituraLinia(auxiliar);
            fichCod.nuevaLinea();
        }
        fich.cerrarFichero();
        fichCod.cerrarFichero();
        System.out.println("Fichero codificado correctamente. (" + fichero + ".cod.txt)");
    }
    //Mètode que engloba el procés de codificar el fitxer corresponent.
    public void deCodificarTexto(String fichero) throws Exception {
        //Inicialitzam els objectes per llegir i escriure linies.
        LiniaFicheroIn fichCod = new LiniaFicheroIn(fichero);
        LiniaFicheroOut fichDec = new LiniaFicheroOut(fichero + ".decod.txt");
        Linia secuenciaCod;
        Linia ayuda;
        int codi;
        //Llegim linies des del fitxer especificat.
        while (fichCod.hayLineas()) {
            //Inicialitzam la linia ayuda a la qual guardarem la 
            //linia deCodificada.
            ayuda = new Linia();
            secuenciaCod = fichCod.lectura();
            //Recorrem la linia llegida.
            for (int i = 0; i < secuenciaCod.getNumeroCaracteres(); i++) {
                //DeCodifica caràcter a caràcter la linia llegida.
                codi = (char) deCodificar(secuenciaCod.obtenerCaracter(i));
                //Afegiex a la linia ayuda, el caràcter deCodificat.
                ayuda.añadirCaracter(codi);
            }
            fichDec.escrituraLinia(ayuda);

        }
        fichCod.cerrarFichero();
        fichDec.cerrarFichero();
        System.out.println("Fichero decodificado correctamente. (" + fichero + ".decod.txt)");
    }
}
