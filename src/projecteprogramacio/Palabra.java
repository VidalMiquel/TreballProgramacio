package projecteprogramacio;

public class Palabra {

    
    //FALTA LECTURA DE PARAULES
    private final int NUMERO_MAXIMO_CARACTERES = 20;
    private int numeroCaracteres;
    private char[] caracteres = new char[NUMERO_MAXIMO_CARACTERES];
    private int linea=0;
    private int columna=0;


    public Palabra() {
        numeroCaracteres = 0;
    }

    public Palabra(String secuencia) {
        caracteres = secuencia.toCharArray();
        numeroCaracteres = secuencia.length();
    }

    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }
    
    
    public void añadirCaracter(char caracter){
        caracteres[numeroCaracteres]= caracter;
        numeroCaracteres++;
    }
    
    public char obtenerCaracter(int posicion){
        
        return caracteres[posicion];
    }
    
    
    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < numeroCaracteres; i++) {
            aux = aux + caracteres[i];
        }
        return aux;
    }
    
    
    //COSES NO REVISADES
     public int getLinea() {
        return linea;
    }

    public void putLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void putColumna(int columna) {
        this.columna = columna;
    }

}
