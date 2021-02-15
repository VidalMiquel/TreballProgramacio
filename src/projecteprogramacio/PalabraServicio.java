package projecteprogramacio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PalabraServicio {

    //Declaracions dels atributs
    private static final int NUMERO_MAXIMO_PALABRAS = 500;
    private static final char[] alfabeto = "abcdefghijklmnopqrstuvwxyz.,:@?!\"()<> ".toCharArray();
    private Palabra[] Palabras;
    private int[] contadorCaracteres;
    private int[] contadorPalabras;
    private int numeroPalabras;
    private int numeroCaracteres;
    private boolean primeraColocada = false;

    //Constructor. Inicialitzam els atributs.
    public PalabraServicio() throws Exception {
        Palabras = new Palabra[NUMERO_MAXIMO_PALABRAS];
        inicilaitzarArrayPalabras();
        contadorCaracteres = new int[alfabeto.length];
        contadorPalabras = new int[NUMERO_MAXIMO_PALABRAS];
        numeroPalabras = 0;
        numeroCaracteres = 0;

    }

    //Mètode que inicializta l'array de Palabras.
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

    //Mètode que retorna el caràcter mès repetit dins el fitxer, dins un String.
    private String caracterMasRepetidotoString() {

        String salida = "";
        int caracterMasRepetido = 0;
        char letra = ' ';
        //Limitam a 26 perque nomes es tenguin en compte els caracters 
        //alfabetics, es a dir, les lletres.
        for (int i = 0; i < 26; i++) {  
          //Recorrem l'array contadorCaracteres cercant la posicio que té
          //assignat el valor més alt.
            if (caracterMasRepetido < contadorCaracteres[i]) {
                caracterMasRepetido = contadorCaracteres[i];
                //assignam a la varibale letra la lletra que té la major
                //freqüència d'aparició.
                letra = alfabeto[i];
            }
        }
        //Concatenam al String salida la lletra més repetida i les vegades
        //que apareix.
        salida = salida + "Caracter más repetido es '"
                + letra + "' con "
                + caracterMasRepetido + " apariciones.";

        return salida;
    }

    //Mètode que retorna dins un string la freqüència d'aparició de cada caràcter
    //alfàbetic.
    private String numeroAparcicionesCaractertoString() {

        String salida = "\n";
        //Recorrem l'array contadorCaracteres i alfabeto alhora.
        for (int i = 0; i < alfabeto.length; i++) {
            //Concatenam al String salida el caràcter corresponent i el número
            //d'aparicions.
            salida = salida + "El número de apariciones del caracter '"
                    + alfabeto[i] + "' es de " + contadorCaracteres[i] + ".\n";
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
        //Comparam la paraula pasada per paràmetre amb la paraula que ocupa
        //la posició i-èssima de l'array Palabras.
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
        //Recorrem l'array alfabeto cercant quina posició de l'array 
        //contadorCaracteres té assignat el valor més gran.
        for (int i = 0; i < alfabeto.length; i++) {
            if (palabraMasRepetida < contadorPalabras[i]) {
                palabraMasRepetida = contadorPalabras[i];
            }
        }
        //Concatenam al String salida, la paraula que apareix més vegades
        //al fitxer.
        for (int i = 0; i < alfabeto.length; i++) {
            if (palabraMasRepetida == contadorPalabras[i]) {
                salida = salida + "Palabra mas repetida es: '"
                        + Palabras[i].toString() + "' con "
                        + palabraMasRepetida + " apariciones."
                        + "\n";
            }
        }

        return salida;

    }

    //Incrementar l'array Palabas i l'atribut contadorPalabras.
    private void incrementarContadorPalabras(Palabra palabra) {

        boolean acabado = false;
        for (int i = 0; i < Palabras.length && !acabado; i++) {
            //Comprovam si la paraula passada per paràmetre és la primera 
            //llegida. Si es així, acabado serà true.
            if (!primeraColocada) {
                Palabras[i] = palabra;
                contadorPalabras[i]++;
                numeroPalabras++;
                primeraColocada = true;
                acabado = true;
            } else if (!(numeroPalabras < NUMERO_MAXIMO_PALABRAS)) {
                break;
            //Comprovam si la paraula passada per paràmetre ja ha estat llegida.    
            } else if (sonIguales(palabra, i)) {
                contadorPalabras[i]++;
                acabado = true;
            //Assignam a la posició i-èssima de l'arry Palabras la nova paraula,
            //que hem comporvat anteriorment, que no ha estat llegida.
            } else if (Palabras[i].vacia()) {
                Palabras[i] = palabra;
                contadorPalabras[i]++;
                numeroPalabras++;
                acabado = true;
            }
        }
    }

    //Mètode que comprova si dues paraules son iguals.
    private boolean sonPalabrasIguales(Palabra palabra, Palabra auxiliar) {
        //Comprova caràcter a caràcter si dues paraules passades per 
        //paràmentre son iguals.
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

    //Metode que retorna un String amb la localitzacio d'una paraula dins 
    //el fitxer.
    private String imprimirLugarExacto(Palabra palabra) {

        String salida = "";
        //Concatenam al String salida el lloc exacte al fitxer de la 
        //paraula passada per paràmetre.
        salida = salida + "La palabra " + palabra.toString() + " aparece en la "
                + "linia " + (palabra.getLinea() + 1) + " y la columna "
                + palabra.getColumna();

        return salida;
    }

    //Mètode que engloba el procés de trobar la lletra més repetida i imprimir-
    //per pantalla.
    public void letraMasRepetida(String fichero) throws Exception {
        lecturaCaracters(fichero);
        System.out.println(caracterMasRepetidotoString());
    }

    //Mètode que engloba el procés de calcular la freqüència d'aparició de
    //cada caràcter i imprimir-ho per pantalla.
    public void frecuenciaCaracteres(String fichero) throws Exception {
        lecturaCaracters(fichero);
        System.out.println(numeroAparcicionesCaractertoString());
    }

     //Mètode que engloba el procés de trobar quina paraula apareix més pics
     //repetida al fitxer i imprimir-ho per pantalla.
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

    //Mètode que engloba el procés de cercar la localització exacte d'una 
    //paraula al fitxer, introduïda per teclat.
    public void localizarPalabra(String fichero) throws Exception {
        PalabraFicheroIn fich = new PalabraFicheroIn(fichero);
        Palabra aux;
        Palabra pal;
        boolean trobada = false;
        System.out.print("Palabra a buscar (Máximo 20 caracteres): ");
        String palabra = LT.readLine();
        System.out.println("");
        aux = new Palabra(palabra);
        //Llegim paraules del fitxer especificat.
        while (fich.hayPalabras()) {
            pal = fich.lectura();
            //Comprovam si la paraula llegida i la cercada son iguals.
            if (sonPalabrasIguales(pal, aux)) {
                System.out.println(imprimirLugarExacto(pal));
                trobada = true;
            }
        }
        //Si hem acabat de llegir i no hem trobat la paraula dessitgada,
        //mostram per pantalla el següent missatge.
        if(!trobada){
            System.out.println("La palabra buscada no se encuentra "
                    + "en el fichero. \n");
        }
        fich.cerrarFichero();
    }
    //Mètode que engloba el procés de cercar la localització exacte d'una 
    //paraula al fitxer, seguida d'ella mateix.
    public void palabraSeguidas(String fichero) throws Exception {
        PalabraFicheroIn fich = new PalabraFicheroIn(fichero);
        Palabra pal;
        Palabra aux;
        boolean encontrado = false;
        //Lectura de la primera paraula.
        pal = fich.lectura();
        while (fich.hayPalabras()) {
            //Assignam a la paraula auxiliar, la lletgida.
            aux = pal;
            //Llegim la següent paraula.
            pal = fich.lectura();
            //Comparam si són iguals.
            if (sonPalabrasIguales(pal, aux)) {
                //Mostram per pantalla el lloc exacte on és troba la paraula
                //al fitxer.
                System.out.println(imprimirLugarExacto(aux));
                encontrado = true;
            }
        }
        //Si hem acabat de llegir i no hem trobat la paraula dessitgada,
        //mostram per pantalla el següent missatge.
        if(!encontrado){
            System.out.println("No hay palabras iguales seguidas en el fichero.");
        }

    }

    //Mètode que engloba el procés de contablilitar si el número de paraules
    //diferentes que hi ha dins el fitxer, no supera el límit establert.
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

    //Mètode que s'encarrega de llegir caràcters des del fitxer.
    private void lecturaCaracters(String fichero) throws IOException {
        FileReader input;

        input = new FileReader(fichero);
        BufferedReader bufIn = new BufferedReader(input);

        int lectura = bufIn.read();
        while (lectura != -1) {
            if (lectura >= ' ') { //Evitam contar els salts de linies com caracters
                incrementarContadorCaracteres((char) lectura);
            }
            lectura = bufIn.read();
        }
        bufIn.close();
        input.close();
    }

}
