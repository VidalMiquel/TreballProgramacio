package projecteprogramacio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LiniaFicheroOut {
    
    private FileWriter FileFicheroOut = null;
    private BufferedWriter BufferedFicheroOut = null;
    private static final int RETURN = (int)'\n';
    private static final int SALTO_LINEA = (int)'\r';
    
    public LiniaFicheroOut(String nombre) throws IOException{
        FileFicheroOut = new FileWriter(nombre);
        BufferedFicheroOut = new BufferedWriter(FileFicheroOut);  
    }
    
    public void escrituraLinia(Linia linia)throws IOException{
        for(int i = 0; i<linia.getNumeroCaracteres(); i++){
            BufferedFicheroOut.write(linia.obtenerCaracter(i));
        }
    }
    
     public void nuevaLinea() throws Exception {
        BufferedFicheroOut.write(SALTO_LINEA);
    }
     
     public void cerrarFichero() throws Exception{
         BufferedFicheroOut.close();
     }
}
