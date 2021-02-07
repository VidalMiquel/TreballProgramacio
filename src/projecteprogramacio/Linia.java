package projecteprogramacio;


public class Linia {
    
    /*
    FUNCIONALITAT: gestionar el funcionament dels objecte Paraula.
    */

    //Declaracions dels atributs
    private static final char FINAL_LINEA='\n';
    private static final int MAXIMO=250;
    private char [] caracteres=new char[MAXIMO];  
    private int numeroCaracteres;   
    private static char caracter;
    private int linia=0;
    private int columna=0;
    
    
    //Constructor que inicialitza l'atribut numeroCaracteres.
    public Linia() {
        numeroCaracteres=0;
    }
    
    //Constructor que converteix un String passat per paràmetre a Char Array.
    public Linia(String texto){
        caracteres = texto.toCharArray();
        numeroCaracteres = texto.length();
    }
   
    //Mètode que converteix un Char array a String.
    @Override
    public String toString(){
        String salida="";
        for (int indice=0;indice<numeroCaracteres;indice++) {
            salida=salida+caracteres[indice];
        }
        return salida;
    }
          
    //Mètode que afageix a l'arrry caracteres el caràcter passat per paràmetre.
    public void añadirCaracter(int cod) {
        caracteres[numeroCaracteres]=(char)cod;
        numeroCaracteres++;
    }

    //Getter de l'atribut getNumeroCaracters
    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }
    
    //Mètode que retorna el caràcter que ocupa la posició passada per paràmetre
    //en l'array caracteres.
    public char obtenerCaracter(int pos) {
        return caracteres[pos];
    }
    
    //Mètode que comprova si una linia està formada per cap caràcter.
    public boolean vacia() {
        return (numeroCaracteres==0);
    }
    
    //Mètode que comprova si una linia passada per paràmetre es troba dins
    //la linia que crida el mètode.
    public boolean contienePalabra(Linia a) {
      
        if (numeroCaracteres>=a.numeroCaracteres) {
            for (int indice=0;indice<numeroCaracteres;indice++) {
                if ((numeroCaracteres-indice)>=a.numeroCaracteres) {
                    boolean contenida=true;
                    for (int indice2=0;indice2<a.numeroCaracteres;indice2++) {
                        if (caracteres[indice+indice2]!=a.caracteres[indice2]) {
                            contenida=false;
                        }
                    }
                    if (contenida) {
                        this.columna=indice;
                        return true;
                    }
                }
            }
            return false;
        }
        else {
            return false;
        }
    }
    
    //Getter de l'atribut linia.
    public int getLinea() {
        return linia;
    }

    //Setter de l'atribut linia.
    public void putLinea(int linea) {
        this.linia = linea;
    }

    //Getter de l'atribut Columna.
    public int getColumna() {
        return columna;
    }

    //Setter de l'objecte Columna.
    public void putColumna(int columna) {
        this.columna = columna;
    }
    
    
    //Mètode que retorna la posició exacte de la linia dins el fitxer
    public String imprimirLugarExacto() {
        
        if(this.linia!=0){
            this.linia++;
        }
        
        String salida = "";
        salida = salida + " APARECE EN LA LINIA " 
                + (this.linia+1) + " Y LA COLUMNA " + columna;

        return salida;
    }
}
