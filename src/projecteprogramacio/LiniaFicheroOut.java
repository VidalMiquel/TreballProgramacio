package projecteprogramacio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LiniaFicheroOut {
    
    /*
    FUNCIONALITAT: escriptura d'una linia al fitxer especificat
    */
    
    //Declaraions dels atributs
    private FileWriter FileFicheroOut = null;
    private BufferedWriter BufferedFicheroOut = null;
    private static final int SALTO_LINEA = (int)'\r';
    
    //Constructor que incialitza el FileWriter i el BufferedWriter.
    public LiniaFicheroOut(String nombre) throws IOException{
        FileFicheroOut = new FileWriter(nombre);
        BufferedFicheroOut = new BufferedWriter(FileFicheroOut);  
    }
    
    //Mètode que duu e terme l'escriptura d'una linia al fitxer especificat.
    public void escrituraLinia(Linia linia)throws IOException{
        for(int i = 0; i<linia.getNumeroCaracteres(); i++){
            BufferedFicheroOut.write(linia.obtenerCaracter(i));
        }
    }
    
    //Mètode que duu a terme l'escritpura d'un salt de linia dins el fitxer.
    public void nuevaLinea() throws Exception {
        BufferedFicheroOut.write(SALTO_LINEA);
    }
     
    //Mètode que tanca l'enllaç amb el fitxer especificat
    public void cerrarFichero() throws Exception{
         BufferedFicheroOut.close();
    }
}
