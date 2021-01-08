package projecteprogramacio;

public class Buscador {
    
    
    public void Buscador(){
        
    }
    
    
    public String imprimirLugarExacto(Palabra palabra){
        
        String salida = "";
        salida = salida + "LA PALABRA " + palabra.toString() + " APARECE EN LA LINIA " +
                palabra.getLinea() + " Y LA COLUMNA " + palabra.getColumna();
        
        return salida;
    }
    
    
}
