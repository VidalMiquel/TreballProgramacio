package projecteprogramacio;

public class LiniaServicio {
int numeroLinias;


public LiniaServicio(){
    numeroLinias = 0;
}

    public int getNumeroLinias() {
        return numeroLinias;
    }

    public void incrementarNumerolinias() {
        numeroLinias++;
    }
    
    
    
    /*
    public String imprimirLugarExacto(Linia linia) {

        String salida = "";
        salida = salida + "LA PALABRA " + linia+ " APARECE EN LA LINIA "
                + linia.getLinia() " Y LA COLUMNA " + palabra.getColumna();

        return salida;
    }

*/
}