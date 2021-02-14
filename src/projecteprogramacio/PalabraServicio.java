package projecteprogramacio;

import java.io.IOException;

public class PalabraServicio {

    //Declaracions dels atributs
    private static final int NUMERO_MAXIMO_PALABRAS = 500;
    private static final char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    Palabra[] Palabras;
    private int[] contadorCaracteres;
    private int[] contadorPalabras;
    private int numeroPalabras;
    private int numeroCaracteres;
    private boolean primeraColocada = false;

    //Constructor
    public PalabraServicio() throws Exception {
        Palabras = new Palabra[NUMERO_MAXIMO_PALABRAS];
        inicilaitzarArrayPalabras();
        contadorCaracteres = new int[alfabeto.length];
        contadorPalabras = new int[NUMERO_MAXIMO_PALABRAS];
        numeroPalabras = 0;
        numeroCaracteres = 0;

    }

    //Mètode que inicializta l'array de paraules
    private void inicilaitzarArrayPalabras() {
        for (int i = 0; i < Palabras.length; i++) {
            Palabras[i] = new Palabra();
        }
    }

    //Incrementar l'array contadorCaracteres per saber quin es el més repetit.
    private void incrementarContadorCaracteres(char caracter) {
        for (int i = 0; i < alfabeto.length; i++) {
            if (alfabeto[i] == caracter) {
                contadorCaracteres[i]++;
            }
        }
    }

    //Mètode que retorna el caràcter mès repetit dins un String.
    private String caracterMasRepetidotoString() {

        String salida = "";
        int caracterMasRepetido = 0;
        char letra = ' ';
        for (int i = 0; i < alfabeto.length; i++) {

            if (caracterMasRepetido < contadorCaracteres[i]) {
                caracterMasRepetido = contadorCaracteres[i];
                letra = alfabeto[i];
            }
        }

        salida = salida + "CARACTER MÁS REPETIDO ES: "
                + letra + " CON "
                + caracterMasRepetido + " APARICIONES";

        return salida;
    }

    //Mètode que retorna dins un string la freqüència d'aparició de cada caràcter
    //alfàbetic.
    private String numeroAparcicionesCaractertoString() {

        String salida = "\n";
        for (int i = 0; i < alfabeto.length; i++) {
            salida = salida + "EL NUMERO DE APARICIONES DEL CARACTER : "
                    + alfabeto[i] + " ES " + contadorCaracteres[i] + ".\n";
        }
        return salida;
    }

    //Getter de l'atribut numeroPalabras.
    public int getNumeroPalabras() {
        return numeroPalabras;
    }

    //Getter de l'atribut constant NUMERO_MAXIMO_PALABRAS.
    public static int getNUMERO_MAXIMO_PALABRAS() {
        return NUMERO_MAXIMO_PALABRAS;
    }

    //Mètode que comprova si la paraula llegida és troba dins l'array Palabras.
    private boolean sonIguales(Palabra palabra, int i) {

        if (palabra.getNumeroCaracteres() == Palabras[i].getNumeroCaracteres()) {
            for (int j = 0; j < palabra.getNumeroCaracteres(); j++) {
                if (palabra.obtenerCaracter(j) != Palabras[i].obtenerCaracter(j)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }

    //Mètode que retorna un String amb la paraula més repetida.
    private String palabraMasRepetidatoString() {

        String salida = "";
        int palabraMasRepetida = 0;
        for (int i = 0; i < alfabeto.length; i++) {
            if (palabraMasRepetida < contadorPalabras[i]) {
                palabraMasRepetida = contadorPalabras[i];
            }
        }
        for (int i = 0; i < alfabeto.length; i++) {
            if (palabraMasRepetida == contadorPalabras[i]) {
                salida = salida + "PALABRA MÁS REPETIDA ES: '"
                        + Palabras[i].toString() + "' CON "
                        + palabraMasRepetida + " APARICIONES"
                        + "\n";
            }
        }

        return salida;

    }

    //Incrementar l'array Palabas i l'atribut contadorPalabras.
    private void incrementarContadorPalabras(Palabra palabra) {

        boolean acabat = false;
        for (int i = 0; i < Palabras.length && !acabat; i++) {

            if (!primeraColocada) {
                Palabras[i] = palabra;
                contadorPalabras[i]++;
                numeroPalabras++;
                primeraColocada = true;
                acabat = true;
            } else if (!(numeroPalabras<NUMERO_MAXIMO_PALABRAS)) {
                break;
            } else if (sonIguales(palabra, i)) {
                contadorPalabras[i]++;
                acabat = true;
            } else if (Palabras[i].vacia()) {
                Palabras[i] = palabra;
                contadorPalabras[i]++;
                numeroPalabras++;
                acabat = true;
            }
        }
    }

    //Mètode que comprova si dues paraules son iguals.
    private boolean sonPalabrasIguales(Palabra palabra, Palabra auxiliar) {

        if (palabra.getNumeroCaracteres() == auxiliar.getNumeroCaracteres()) {
            for (int j = 0; j < palabra.getNumeroCaracteres(); j++) {
                if (palabra.obtenerCaracter(j) != auxiliar.obtenerCaracter(j)) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }

    //Metode que retorna un String amb la localitzacio d'una paraula dins el fitxer
    private String imprimirLugarExacto(Palabra palabra) {

        String salida = "";
        salida = salida + "La palabra " + palabra.toString() + " aparece en la "
                + "linia " + (palabra.getLinea() + 1) + " y la columna "
                + palabra.getColumna();

        return salida;
    }

    public void letraMasRepetida(String fichero) throws Exception {
        PalabraFicheroIn fich = new PalabraFicheroIn(fichero);
        Palabra pal;
        char caracter;
        while (fich.hayPalabras()) {
            pal = fich.lectura();
            for (int i = 0; i < pal.getNumeroCaracteres(); i++) {
                caracter = pal.obtenerCaracter(i);
                incrementarContadorCaracteres(caracter);
            }

        }
        fich.cerrarFichero();
        System.out.println(caracterMasRepetidotoString());
    }

    public void frecuenciaCaracteres(String fichero) throws Exception {
        PalabraFicheroIn fich = new PalabraFicheroIn(fichero);
        Palabra pal;
        char caracter;

        while (fich.hayPalabras()) {
            pal = fich.lectura();
            for (int i = 0; i < pal.getNumeroCaracteres(); i++) {
                caracter = pal.obtenerCaracter(i);
                incrementarContadorCaracteres(caracter);
            }
        }
        fich.cerrarFichero();
        System.out.println(numeroAparcicionesCaractertoString());
    }

    public void palabraMasFrecuente(String fichero) throws Exception {
        PalabraFicheroIn fich = new PalabraFicheroIn(fichero);
        Palabra pal;
        while (fich.hayPalabras()) {
            pal = fich.lectura();
            incrementarContadorPalabras(pal);
        }
        fich.cerrarFichero();
        System.out.println(palabraMasRepetidatoString());
    }

    public void localizarPalabra(String fichero) throws Exception {
        PalabraFicheroIn fich = new PalabraFicheroIn(fichero);
        Palabra aux;
        Palabra pal;
        System.out.println("Opción buscar una palabra en el fichero");
        System.out.print("Palabra a buscar (Máximo 20 caracteres): ");
        String palabra = LT.readLine();
        aux = new Palabra(palabra);
        System.out.println("La palabra buscada es: " + aux);
        while (fich.hayPalabras()) {
            pal = fich.lectura();
            if (sonPalabrasIguales(pal, aux)) {
                System.out.println(imprimirLugarExacto(pal));
            }
        }
        fich.cerrarFichero();
    }

    public void palabraSeguidas(String fichero) throws Exception {
        PalabraFicheroIn fich = new PalabraFicheroIn(fichero);
        Palabra pal;
        Palabra aux;
        pal = fich.lectura();
        while (fich.hayPalabras()) {
            aux = pal;
            pal = fich.lectura();
            if (sonPalabrasIguales(pal, aux)) {
                System.out.println(imprimirLugarExacto(aux));
            }
        }

    }

    public boolean comprovarParaulesDiferents(String fichero) throws IOException {
        PalabraFicheroIn fich = new PalabraFicheroIn(fichero);
        Palabra pal;

        while (fich.hayPalabras()) {
            pal = fich.lectura();
            incrementarContadorPalabras(pal);
        }
        fich.cerrarFichero();
        if (!(numeroPalabras < NUMERO_MAXIMO_PALABRAS)) {
            System.out.println("El fichero contiene demasiadas palabras diferentes. Limite: " + NUMERO_MAXIMO_PALABRAS);
            return true;
        } else {
            return false;
        }
    }

}
