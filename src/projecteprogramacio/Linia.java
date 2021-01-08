package projecteprogramacio;


public class Linia {
    
    int numeroCaracteres;
    private static final int NUMERO_MAXIMO_CARACTERES = 250;
    char [] caracteres = new char [NUMERO_MAXIMO_CARACTERES];
    
    
    public void Linia(){
        numeroCaracteres = 0;
    }

    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }
    
    public boolean vacia(){
        return numeroCaracteres==0;
    }    
    public void Linia(String linia){
        caracteres = linia.toCharArray();
        numeroCaracteres = linia.length();
    }
    
    public char obtenerCaracter(int posicion){
        return caracteres[posicion];
    }
    
    public void añadirCaracter(char caracter){
        caracteres[numeroCaracteres]= caracter;
        numeroCaracteres++;
    }
    @Override
    public String toString(){
        String salida = "";
        for(int  i = 0; i<numeroCaracteres; i++){
            salida = salida + caracteres[i];
        }
        return salida;
    }
    
}
