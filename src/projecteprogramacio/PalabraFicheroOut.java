package projecteprogramacio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
FUNCIONALITAT: escriptura de paraules dins el fitxer especificat.
*/

public class PalabraFicheroOut {
    
    //Declaracions dels atributs
    private BufferedWriter BufferedFicheroOut = null;
    private FileWriter FileFicheroOut = null;
    private static final int ESPACIO=(int) ' ';    
    private static final int SALTO_LINEA = (int)'\n';
    private static final int RETURN=(int) '\r';

    //Constructor que inicialtza el FileWriter i el BufferedWriter.
    public PalabraFicheroOut(String nombreFichero)throws Exception{
        
        FileFicheroOut = new FileWriter(nombreFichero);
        BufferedFicheroOut = new BufferedWriter(FileFicheroOut);
        
    }
     
    //Mètode que escriu una paraula dins el fitxer caràcter a caràcter.
    public void escrituraPalabra(Palabra palabra) throws IOException{
        for(int i = 0; i<palabra.getNumeroCaracteres(); i++){
            BufferedFicheroOut.write(palabra.obtenerCaracter(i));
        }
    }
    
    //Mètode que tancar l'enllaç amb el fitxer.
    public void cerrarFichero()throws Exception{
        BufferedFicheroOut.close();
    }
}
