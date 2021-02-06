package projecteprogramacio;

public class Palabra {

    /*
    FUNCIONALITAT: gestionar el funcionament dels objecte Paraula.
    */
    
    //Declaracions d'atributs
    private final int NUMERO_MAXIMO_CARACTERES = 20;
    private int numeroCaracteres;
    private char[] caracteres = new char[NUMERO_MAXIMO_CARACTERES];
    private int linea=0;
    private int columna=0;

    //Constructor inicialitza atribut numeroCaracteres a 0.
    public Palabra() {
        numeroCaracteres = 0;
    }

    //Constructor que converteix un String passat per paràmetre a Char Array.
    public Palabra(String secuencia) {
        caracteres = secuencia.toCharArray();
        numeroCaracteres = secuencia.length();
    }
    
    //Getter de l'atribut numeroCaracteres
    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }
    
    //Mètode que comprova si un paraula està formada per cap caràcter.
    public boolean vacia(){
        return numeroCaracteres == 0;
    }
    
    //Mètode que afageix a l'arrry caracteres el caràcter passat per paràmetre.
    public void añadirCaracter(int codigo){
        caracteres[numeroCaracteres]= (char)codigo;
        numeroCaracteres++;
    }
    
    //Mètode que retorna el caràcter que ocupa la posició passada per paràmetre
    //en l'array caracteres.
    public char obtenerCaracter(int posicion){
        return caracteres[posicion];
    }
    
    //Mètode que converteix un Char Array a un String.
    @Override
    public String toString() {
        String aux = "";
        for (int i = 0; i < numeroCaracteres; i++) {
            aux = aux + caracteres[i];
        }
        return aux;
    }
    
    //Getter de l'atribut linea.
    public int getLinea() {
        return linea;
    }
    
    //Setter de l'atribut linea.
    public void putLinea(int linea) {
        this.linea = linea;
    }

    //Getter de l'atribut columna.
    public int getColumna() {
        return columna;
    }

    //Setter de l'atribut columna.
    public void putColumna(int columna) {
        this.columna = columna;
    }

}
