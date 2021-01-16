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
    
    
    
    
    //ACABAR DE FER FALTA SA LINIA I SA COLUMNA EXACTE, AIXO ES TEMA LLER LINIA
    public String imprimirLugarExacto(Linia linia) {

        String salida = "";
        salida = salida + "LA PALABRA " + linia+ " APARECE EN LA LINIA ";

        return salida;
    }


}