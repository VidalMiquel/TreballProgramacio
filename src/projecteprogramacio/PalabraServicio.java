package projecteprogramacio;

public class PalabraServicio {

    private static final int NUMERO_MAXIMO_PALABRAS = 500;
    private static final char[] alfabeto = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    Palabra[] Palabras;
    private int[] contadorCaracteres;
    private int[] contadorPalabras;
    private int numeroPalabras;
    private int numeroCaracteres;
    private boolean primeraColocada = false;
    //Metode Constructor
    public PalabraServicio() throws Exception {
        Palabras = new Palabra[500];
        inicilaitzarArrayPalabras();
        contadorCaracteres = new int[alfabeto.length];
        contadorPalabras = new int[NUMERO_MAXIMO_PALABRAS];
        numeroPalabras = 0;
        numeroCaracteres = 0;

    }
    //Metode que inicializta l'array de paraules
    private void inicilaitzarArrayPalabras() {
        for (int i = 0; i < Palabras.length; i++) {
            Palabras[i] = new Palabra();
        }
    }

    //INCREMENTAR ARRAY CONTADOR CARACTER PARA SABER CUAL ES EL MAS REPETIDO
    public void incrementarContadorCaracteres(char caracter) {
        for (int i = 0; i < alfabeto.length; i++) {
            if (alfabeto[i] == caracter) {
                contadorCaracteres[i]++;
            }
        }
    }

    //RIMPRIME EL CARACTER MAS REPETIDO 
    public String caracterMasRepetidotoString() {

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

    //IMPRIME LA FRECUENCIA DE LA APARICION DE LOS CARACTERES
    public String numeroAparcicionesCaractertoString() {

        String salida = "\n";
        for (int i = 0; i < alfabeto.length; i++) {
            salida = salida + "EL NUMERO DE APARICIONES DEL CARACTER : "
                    + alfabeto[i] + " ES " + contadorCaracteres[i] + ".\n";
        }
        return salida;
    }
    //GETTERS i SETTERS
    public void incrementarNumeroCaracteres() {
        numeroCaracteres++;
    }

    public void incrementarNumeroPalabras() {
        numeroPalabras++;
    }

    public int getNumeroPalabras() {
        return numeroPalabras;
    }

    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }

    public static int getNUMERO_MAXIMO_PALABRAS() {
        return NUMERO_MAXIMO_PALABRAS;
    }

    //Comprovar que la palabra leida no esta en la array Palabras
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

    //Imprimir por pantalla la palabra que aparece mas veces en el fichero
    public String palabraMasRepetidatoString() {

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

    //incrementar Arry Palabrs y contadorPalabras
    public void incrementarContadorPalabras(Palabra palabra) {

        boolean acabat = false;
        for (int i = 0; i < Palabras.length && !acabat; i++) {

            if (!primeraColocada) {
                Palabras[i] = palabra;
                contadorPalabras[i]++;
                numeroPalabras++;
                primeraColocada = true;
                acabat = true;
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

    //Compara si dos palabras pasadas por parametro son iguales
    public boolean sonPalabrasIguales(Palabra palabra, Palabra auxiliar) {

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
    public String imprimirLugarExacto(Palabra palabra) {

        String salida = "";
        salida = salida + "LA PALABRA " + palabra.toString() + " APARECE EN LA LINIA "
                + palabra.getLinea() + " Y LA COLUMNA " + palabra.getColumna();

        return salida;
    }

}
