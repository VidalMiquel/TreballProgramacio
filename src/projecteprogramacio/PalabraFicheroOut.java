package projecteprogramacio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class PalabraFicheroOut {
    private BufferedWriter BufferedFicheroOut = null;
    private FileWriter FileFicheroOut = null;
    private static final int ESPACIO=(int) ' ';    
    private static final int SALTO_LINEA = (int)'\n';
    private static final int RETURN=(int) '\r';

    
    public PalabraFicheroOut(String nombreFichero)throws Exception{
        
        FileFicheroOut = new FileWriter(nombreFichero);
        BufferedFicheroOut = new BufferedWriter(FileFicheroOut);
        
    }
    
    //crec que no es necesari però per si acaso
    public PalabraFicheroOut (String nombreFichero, boolean estat)throws Exception{
        FileFicheroOut = new FileWriter(nombreFichero, estat);
        BufferedFicheroOut = new BufferedWriter(FileFicheroOut);
    }
    
    public void escrituraEspacio() throws IOException{
        BufferedFicheroOut.write(ESPACIO);
    }
    
    public void nuevaLinea() throws Exception {
        BufferedFicheroOut.write(RETURN);
        BufferedFicheroOut.write(SALTO_LINEA);
    }

    public void escrituraPalabra(Palabra palabra) throws IOException{
        for(int i = 0; i<palabra.getNumeroCaracteres(); i++){
            BufferedFicheroOut.write(palabra.obtenerCaracter(i));
        }
    }
    public void cerrarFichero()throws Exception{
        BufferedFicheroOut.close();
    }
}
