package projecteprogramacio;


public class Linia {
    
     //DECLARACIONES
    //Declaración atributo de clase constante entero que representa el final de
    //un fichero
    private static final char FINAL_LINEA='\n';
    //declaración atributo de clase constante entero que representa el máximo
    //número de caracteres que puede contener un objetoLinea
    private static final int MAXIMO=250;
    //declaración atributo de objeto variable array de caracteres que representa 
    //los caracteres de un objeto Linea 
    private char [] caracteres=new char[MAXIMO];  
    //declaración atributo de objeto variable entero que represente el número
    //de caracteres de un objeto Linea
    private int numeroCaracteres;   
    //declaración atributo de clase variable caracter que representa el último
    //caracter leido desde la secuencia de entrada por teclado
    private static char caracter;
    
    
    //MÉTODOS
    
    //Métodos Constructores
    public Linia() {
        numeroCaracteres=0;
    }
    
    //Métodos funcionales
    //método que lleva a cabo la verificación de si una objeto Linea ha sido
    //totalmente leido desde el teclado
    public static boolean hayLinea() throws Exception {
        //lectura primer caracter de la secuencia de entrada por teclado
        caracter=LT.readCharacterLine();
        //verificar final de linea
        return (caracter!=FINAL_LINEA);
    }
    
    //método que lleva a cabo la lectura de una linea desde el teclado
    public void lectura() throws Exception {
        //inicialización de numeroCaracteres
        numeroCaracteres=0;
        while (caracter!=FINAL_LINEA) {
            //almacenar el caracter leido en el array caracteres del objeto Linea
            caracteres[numeroCaracteres]=caracter;
            //incrementar numeroCaracteres
            numeroCaracteres++;
            //lectura del siguiente caracter de la secuencia
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
          
    //método que lleva a cabo la adición de un caracter dado por parámetro
    //al objeto Linea
    public void adicionCaracter(int cod) {
        caracteres[numeroCaracteres]=(char)cod;
        numeroCaracteres++;
    }
    
    //método que devuelve el número de caracteres que conforman un objeto Linea
    public int getNumCaracteres() {
        return numeroCaracteres;
    }
    
    //método que lleva a cabo la obtención del caracter del objeto Linea en función
    //de la posición dada por parámetro
    public char obtenerCaracter(int pos) {
        return caracteres[pos];
    }
    
    
    //MÉTODO vacia QUE TIENE COMO OBJETIVO EL DE VERIFICAR SI UN OBJETO Linea 
    //ESTÁ VACIO O NO
    public boolean vacia() {
        return (numeroCaracteres==0);
    }
}
