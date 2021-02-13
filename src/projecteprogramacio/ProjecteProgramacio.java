package projecteprogramacio;

import java.io.FileNotFoundException;

public class ProjecteProgramacio {
    
    public static void main(String[] args) throws Exception {
        new ProjecteProgramacio().ProgramaPrincipal();
        
    }
    
    public void ProgramaPrincipal() throws Exception {
        boolean sortir = false;
        int semilla;
        char caracter;
        
        Palabra pal;
        System.out.println("NOMBRE DEL FICHERO A ANALIZAR: ");
        String nombreFichero = LT.readLine();
        PalabraFicheroIn palFicheroIn;
        PalabraServicio anal;
        Analisis analisis = new Analisis();
        
        try {
            //Cmprovacions inicials del programa.
            //Miram que el fitxer tengui menys de 500 paraules repetides.
            //Recompte del numero de caràcters, paraules i lines.
            //Imprimim per pantalla el resultats.
            palFicheroIn = new PalabraFicheroIn(nombreFichero);
            anal = new PalabraServicio();
            while (palFicheroIn.hayPalabras()) {
                pal = palFicheroIn.lectura();
                //incrementarContadorPalabras(pal);
            }
            if (!(anal.getNumeroPalabras() < PalabraServicio.getNUMERO_MAXIMO_PALABRAS())) {
                System.out.println("El fichero contiene demasiadas palabras diferentes. Limite: " + PalabraServicio.getNUMERO_MAXIMO_PALABRAS());
                sortir = true;
            }
            analisis.analisis(nombreFichero);
            if (analisis.getCaracteres()==0){
                sortir = true;
                System.out.println("El fichero deseado esta vacio. Ninguna opción del menu es aplicable");
            }
            palFicheroIn.cerrarFichero();
        } catch (FileNotFoundException ex) {
            System.out.println("El fichero deseado no existe. Ninguna opción del menu es aplicable");
            sortir = true;
        }
        CodificacionAlfabetica cod;
        while (!sortir) {
            borrarPantalla();
            menu();
            System.out.print("INTRODUCE LA OPCION A REALIZAR: ");
            int opcioMenu = LT.readInt();
            switch (opcioMenu) {
                case 0:
                    //Sortir del while, fi del programa
                    sortir = true;
                    break;
                
                case 1:

                    anal = new PalabraServicio();
                    anal.letraMasRepetida(nombreFichero);
                    break;
                
                case 2:

                    anal = new PalabraServicio();
                    anal.frecuenciaCaracteres(nombreFichero);
                    break;
                
                case 3:

                    anal = new PalabraServicio();
                    anal.palabraMasFrecuente(nombreFichero);
                    break;
                
                case 4:

                    Palabra aux;
                    anal = new PalabraServicio();
                    anal.localizarPalabra(nombreFichero);
                    break;
                
                case 5:
                    //Llegim una linia des de teclat, i comprovam mitjançant 
                    //la lectura d'una altra linia des del fitxer si la
                    //llegida des del teclat també és troba al fitxer.
                    //Imprimim per pantalla, el lloc exacte on és troba la 
                    //linia cercada.
                    System.out.print("TEXTO A BUSCAR (MÁXIMO 250 CARACTERES): ");
                    String texto = LT.readLine();
                    Linia secuenciaBuscada = new Linia(texto);
                    Linia secuenciaLeida;
                    LiniaFicheroIn fich = new LiniaFicheroIn(nombreFichero);
                    
                    while (fich.hayLineas()) {
                        secuenciaLeida = fich.lectura();
                        if (secuenciaLeida.contienePalabra(secuenciaBuscada)) {
                            System.out.println("LA LINIA: "+
                                    secuenciaBuscada.toString() + 
                                    secuenciaLeida.imprimirLugarExacto());
                        }
                    }
                    break;
                
                case 6:
                    anal = new PalabraServicio();
                    anal.palabraSeguidas(nombreFichero);
                    break;
                
                case 7:
                    System.out.print("Introducir semilla: ");
                    semilla = LT.readInt();
                    cod = new CodificacionAlfabetica(semilla);
                    cod.codificarTexto(nombreFichero);
                    break;
                
                case 8:
                    System.out.print("Introducir semilla: ");
                    semilla = LT.readInt();
                    cod = new CodificacionAlfabetica(semilla);
                    cod.deCodificarTexto(nombreFichero);
            }
            
        }
    }
    
    //Mètode per imprimir per pantalla el menu.
    public void menu() {
        System.out.println("-------------------------------------------------");
        System.out.println("MENU DE OPCIONES: ");
        System.out.println("1.LETRA MÁS REPTIDA Y NÚMERO DE APARICIONES");
        System.out.println("2.NÚMERO DE APARICIONES DE CADA CARÁCTER");
        System.out.println("3.PALABRA MÁS REPETIDA Y NÚMERO DE APARICIONES");
        System.out.println("4.BUSCAR UNA PALABRA");
        System.out.println("5.BUSCAR UN TEXTO");
        System.out.println("6.BUSCAR PALABRAS REPETIDAS");
        System.out.println("7.CODIFICAR UN FICHERO");
        System.out.println("8.DECODIFICAR UN FICHERO");
        System.out.println("0.SALIR DEL PROGRAMA");
        System.out.println("-------------------------------------------------");
        
    }
    
    //Mètode duu a terme el borrat de la pantalla per clarificar el resultat
    //obtingut.
    public static void borrarPantalla() {
        System.out.print("\n\n\n\n\n\n\n\n\n");
    }
    
}
