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

    //Constructor que inicialtza el FileWriter i el BufferedWriter.
    public PalabraFicheroOut(String nombreFichero)throws Exception{
        FileFicheroOut = new FileWriter(nombreFichero);
        BufferedFicheroOut = new BufferedWriter(FileFicheroOut);
        
    }
     
    //Mètode que escriu una paraula dins el fitxer caràcter a caràcter.
    public void escrituraPalabra(Palabra palabra) throws IOException{
        //Recorrem la paraula passada per paràmetre.
        for(int i = 0; i<palabra.getNumeroCaracteres(); i++){
            //Escrivim al fitxer, caràcter a caràcter la paraula
            //passada per paràmetre.
            BufferedFicheroOut.write(palabra.obtenerCaracter(i));
        }
    }
    
    //Mètode que tancar l'enllaç amb el fitxer.
    public void cerrarFichero()throws Exception{
        BufferedFicheroOut.close();
    }
}
