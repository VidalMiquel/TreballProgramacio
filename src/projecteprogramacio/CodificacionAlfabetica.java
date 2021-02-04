package projecteprogramacio;

import static java.lang.Math.abs;
import java.util.Random;

public class CodificacionAlfabetica {

    private static final int NUMERO_CARACTERES=37;
    private static final char [] ALFABETO="abcdefghijklmnopqrstuvwxyz.,:@?!\"()<>".toCharArray();
    private int desplazamiento;
    

    public CodificacionAlfabetica(int semilla) {
        Random generador=new Random(semilla*1000);
        desplazamiento=(int) (generador.nextDouble()*NUMERO_CARACTERES);
    }
    
    //MÉTODO codificar LLEVA A TÉRMINO LA OBTENCIÓN DEL CARACTER CODIFICADO
    //DEL CARACTER DADO POR PARÁMETRO
    public char codificar(char caracter) {
        if (valido(caracter)) {
            return ALFABETO[(posicion(caracter)+desplazamiento)%NUMERO_CARACTERES];
        }
        else {
            return caracter;
        }
        
    }

    //MÉTODOS FUNCIONALES
    //MÉTODO deCodificar LLEVA A TÉRMINO LA OBTENCIÓN DEL CARACTER DECODIFICADO
    //DEL CARACTER DADO POR PARÁMETRO
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
    //MÉTODO posicion OBTIENE LA POSICIÓN EN EL ARRAY ALFABETO DE UN CARACTER
    //DADO POR PARÁMETRO
    public int posicion(char caracter) {
        int indice;
        for (indice=0;caracter!=ALFABETO[indice];indice++) {}
        return indice;
    }
    
    //MÉTODO valido VERIFICA SI UN CARACTER DADO ES UN CARACTER QUE PUEDE
    //SER CODIFICADO O DECODIFICADO
    private boolean valido(char caracter) {
        for (int indice=0;indice<ALFABETO.length;indice++) {
            if (caracter==ALFABETO[indice]) {
                return true;
            }
        }
        return false;
    }
}
