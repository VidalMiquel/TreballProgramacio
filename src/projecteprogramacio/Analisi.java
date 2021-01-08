package projecteprogramacio;

public class Analisi {

    private static final int NUMERO_MAXIMO_PALABRAS = 500;
    private static final char[] alfabeto = "abcdefghijklmnñopqrstuvwxyz".toCharArray();
    Palabra[] Palabras;
    int[] contadorCaracteres;
    int[] contadorPalabras;
    int numeroLinias;
    int numeroPalabras;
    int numeroCaracteres;
    private boolean primeraColocada = false;

    public Analisi() throws Exception{
        Palabras = new Palabra[500];
        inicilaitzarArrayPalabras();
        contadorCaracteres = new int[alfabeto.length];
        contadorPalabras = new int[NUMERO_MAXIMO_PALABRAS];
        numeroLinias = 0;
        numeroPalabras = 0;
        numeroCaracteres = 0;

    }
    
    private void inicilaitzarArrayPalabras(){
        for(int i = 0; i<Palabras.length;i++){
            Palabras[i]= new Palabra();
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
                + letra + "CON"
                + caracterMasRepetido + "APARICIONES";

        return salida;
    }

    //IMPRIME LA FRECUENCIA DE LA APARICION DE LOS CARACTERES
    public String numeroAparcicionesCaractertoString() {

        String salida = "\n";
        for (int i = 0; i < alfabeto.length; i++) {
            salida = salida + "EL NUMERO DE APARICIONES DEL CARACTER :"
                    + alfabeto[i] + "ES " + contadorCaracteres[i] + ".\n";
        }
        return salida;
    }

    public void incrementarNumeroLinias() {
        numeroLinias++;
    }

    public void incrementarNumeroCaracteres() {
        numeroCaracteres++;
    }

    public void incrementarNumeroPalabras() {
        numeroPalabras++;
    }

    public int getNumeroLinias() {
        return numeroLinias;
    }

    public int getNumeroPalabras() {
        return numeroPalabras;
    }

    public int getNumeroCaracteres() {
        return numeroCaracteres;
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
        Palabra pal = new Palabra();
        for (int i = 0; i < alfabeto.length; i++) {
            if (palabraMasRepetida < contadorPalabras[i]) {
                palabraMasRepetida = contadorPalabras[i];
                pal = Palabras[i];
            }
        }

        salida = salida + "PALABRA MÁS REPETIDA ES: "
                + pal.toString() + "CON"
                + palabraMasRepetida + "APARICIONES";

        return salida;

    }
    
    public void imprimirNumeroCaractersArrayparaula(){
        for(int i = 0; i<Palabras.length;i++){
            System.out.println(Palabras[i].getNumeroCaracteres());
        }
    }
    
    public void prova(Palabra palabra){

        boolean acabat = false;
        for(int i = 0; i< Palabras.length&&!acabat;i++){
            
            if(!primeraColocada){
              Palabras[i] = palabra;
              contadorPalabras[i]++;
              primeraColocada = true;
              acabat = true;
            }else if(sonIguales(palabra, i)){
                contadorPalabras[i]++;
                acabat = true;
            }else if(Palabras[i].getNumeroCaracteres()==0){
                 Palabras[i] = palabra;
                 contadorPalabras[i]++;
                 acabat = true;
             }
            }
        }



    
    

    //rellenar array contadorPalabras
    public void incrementarContadorPalabras(Palabra palabra) {
        int j;

        for (int i = 0; i < Palabras.length; i++) {
            j = i + 1;
            if (!primeraColocada) {
                Palabras[i] = palabra;
                contadorPalabras[i]++;
                primeraColocada = true;
                break;
            } else if (sonIguales(palabra, i)) {
                contadorPalabras[i]++;
                break;
            } else {
                Palabras[j] = palabra;
                contadorPalabras[j]++;
                break;
            }
        }
    }
    
   

    
   
    //Compara si dos palabras pasadas por parametro son iguales
    public boolean sonIguales(Palabra palabra, Palabra auxiliar) {

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

}

