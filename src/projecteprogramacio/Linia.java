package projecteprogramacio;


public class Linia {
    

    private static final char FINAL_LINEA='\n';
    private static final int MAXIMO=250;
    private char [] caracteres=new char[MAXIMO];  
    private int numeroCaracteres;   
    private static char caracter;
    private int linia=0;
    private int columna=0;
    
    
    //MÉTODOS
    
    //Métodos Constructores
    public Linia() {
        numeroCaracteres=0;
    }
    
    public Linia(String texto){
        caracteres = texto.toCharArray();
        numeroCaracteres = texto.length();
    }
    
    //Métodos funcionales
    //método que lleva a cabo la verificación de si una objeto Linea ha sido
    //totalmente leido desde el teclado
    public static boolean hayLinea() throws Exception {
        caracter=LT.readCharacterLine();
        return (caracter!=FINAL_LINEA);
    }
    
    //método que lleva a cabo la lectura de una linea desde el teclado
    public void lectura() throws Exception {
        numeroCaracteres=0;
        while (caracter!=FINAL_LINEA) {
            caracteres[numeroCaracteres]=caracter;
            numeroCaracteres++;
            caracter=LT.readCharacterLine();    
        }
    }
    
    //método que lleva a cabo la conversión de un objeto Linea a String para su
    //visualización en pantalla

    @Override
    public String toString(){
        String salida="";
        for (int indice=0;indice<numeroCaracteres;indice++) {
            salida=salida+caracteres[indice];
        }
        return salida;
    }
          
    public void añadirCaracter(int cod) {
        caracteres[numeroCaracteres]=(char)cod;
        numeroCaracteres++;
    }

    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }
    
    public char obtenerCaracter(int pos) {
        return caracteres[pos];
    }
    
    public boolean vacia() {
        return (numeroCaracteres==0);
    }
    
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
                        columna=indice;
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
    
      public int getLinea() {
        return linia;
    }

    public void putLinea(int linea) {
        this.linia = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void putColumna(int columna) {
        this.columna = columna;
    }
}
