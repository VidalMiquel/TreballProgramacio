package projecteprogramacio;

import static java.lang.Math.abs;
import java.util.Random;

public class CodificacionAlfabetica {
    
    /*
    FUNCIONALITAT: duu a terme la codificació i la decodificació d'un fitxer.
    */

    //Declaracions dels atibuts
    private static final int NUMERO_CARACTERES=37;
    private static final char [] ALFABETO="abcdefghijklmnopqrstuvwxyz.,:@?!\"()<>".toCharArray();
    private int desplazamiento;
    

    //Constructor que inicialitza la classe Random i calcula el despalçament
    //segons la llavor passada per paràmetre.
    public CodificacionAlfabetica(int semilla) {
        Random generador=new Random(semilla*1000);
        desplazamiento=(int) (generador.nextDouble()*NUMERO_CARACTERES);
    }
    

    //Mètode que obté el caràcter codificat del caràcter passat per paràmetre.
    public char codificar(char caracter) {
        if (valido(caracter)) {
            return ALFABETO[(posicion(caracter)+desplazamiento)%NUMERO_CARACTERES];
        }
        else {
            return caracter;
        }
    }

    //MÉTODO deCodificar LLEVA A TÉRMINO LA OBTENCIÓN DEL CARACTER DECODIFICADO
    //DEL CARACTER DADO POR PARÁMETRO
    //Mètode que obté el caràcter decodificat del caràcter passat per paràmete.
    public char deCodificar(char caracter) {
        if (valido(caracter)) {
            int valor=posicion(caracter)-desplazamiento;
            if (valor<0) {
                valor=NUMERO_CARACTERES-abs(valor);
            }
            return ALFABETO[valor%NUMERO_CARACTERES];            
        }
        else {
            return caracter;
        }
    } 
    
    //Mètode que obté la posició en l'array alfabeto d'un caràcter passat per
    //paràmetre.
    public int posicion(char caracter) {
        int indice;
        for (indice=0;caracter!=ALFABETO[indice];indice++) {}
        return indice;
    }
    
    //Mètode que verifica si un caràcter passat per paràmetre és un caràcter
    //que pot ser codificat o decodificat.
    private boolean valido(char caracter) {
        for (int indice=0;indice<ALFABETO.length;indice++) {
            if (caracter==ALFABETO[indice]) {
                return true;
            }
        }
        return false;
    }
}
