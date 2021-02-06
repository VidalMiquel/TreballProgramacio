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
            palFicheroIn = new PalabraFicheroIn(nombreFichero);
            anal = new PalabraServicio();
            //Comprovamos que el fichero no exceda el limite de palabras diferentes
            while (palFicheroIn.hayPalabras()) {
                pal = palFicheroIn.lectura();
                anal.incrementarContadorPalabras(pal);
            }
            if (!(anal.getNumeroPalabras() < PalabraServicio.getNUMERO_MAXIMO_PALABRAS())) {
                System.out.println("El fichero contiene demasiadas palabras diferentes. Limite: " + PalabraServicio.getNUMERO_MAXIMO_PALABRAS());
                sortir = true;
            }
            analisis.analisis(nombreFichero);
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
                    
                    sortir = true;
                    break;
                
                case 1:
                    
                    anal = new PalabraServicio();
                    palFicheroIn = new PalabraFicheroIn(nombreFichero);
                    while (palFicheroIn.hayPalabras()) {
                        pal = palFicheroIn.lectura();
                        for (int i = 0; i < pal.getNumeroCaracteres(); i++) {
                            caracter = pal.obtenerCaracter(i);
                            anal.incrementarContadorCaracteres(caracter);
                        }
                        
                    }
                    palFicheroIn.cerrarFichero();
                    System.out.println(anal.caracterMasRepetidotoString());
                    break;
                
                case 2:
                    
                    anal = new PalabraServicio();
                    palFicheroIn = new PalabraFicheroIn(nombreFichero);
                    while (palFicheroIn.hayPalabras()) {
                        pal = palFicheroIn.lectura();
                        for (int i = 0; i < pal.getNumeroCaracteres(); i++) {
                            caracter = pal.obtenerCaracter(i);
                            anal.incrementarContadorCaracteres(caracter);
                        }
                    }
                    palFicheroIn.cerrarFichero();
                    System.out.println(anal.numeroAparcicionesCaractertoString());
                    break;
                
                case 3:
                    
                    anal = new PalabraServicio();
                    palFicheroIn = new PalabraFicheroIn(nombreFichero);
                    while (palFicheroIn.hayPalabras()) {
                        pal = palFicheroIn.lectura();
                        anal.incrementarContadorPalabras(pal);
                    }
                    palFicheroIn.cerrarFichero();
                    System.out.println(anal.palabraMasRepetidatoString());
                    break;
                
                case 4:
                    
                    Palabra aux;
                    anal = new PalabraServicio();
                    palFicheroIn = new PalabraFicheroIn(nombreFichero);
                    System.out.println("OPCION BUSCAR UNA PALABRA EN EL FICHERO:");
                    System.out.println("PALABRA A BUSCAR:");
                    String palabra = LT.readLine();
                    aux = new Palabra(palabra);
                    System.out.println("LA PALABRA BUSCADA ES: " + aux);
                    while (palFicheroIn.hayPalabras()) {
                        pal = palFicheroIn.lectura();
                        if (anal.sonPalabrasIguales(pal, aux)) {
                            System.out.println(anal.imprimirLugarExacto(pal));
                        }
                    }
                    palFicheroIn.cerrarFichero();
                    break;
                
                case 5:
                    
                    System.out.println("TEXT A CERCAR: MAXIM 250 CARACTERS");
                    String texto = LT.readLine();
                    Linia secuenciaBuscada = new Linia(texto);
                    Linia secuenciaLeida;
                    LiniaFicheroIn fich = new LiniaFicheroIn(nombreFichero);
                    
                    while (fich.hayLineas()) {
                        secuenciaLeida = fich.lectura();
                        if (secuenciaLeida.contienePalabra(secuenciaBuscada)) {
                            System.out.println("LA LINIA: "+
                                    secuenciaBuscada.toString() + 
                                    secuenciaBuscada.imprimirLugarExacto());
                        }
                    }
                    break;
                
                case 6:
                    
                    anal = new PalabraServicio();
                    palFicheroIn = new PalabraFicheroIn(nombreFichero);
                    pal = palFicheroIn.lectura();
                    while (palFicheroIn.hayPalabras()) {
                        aux = pal;
                        pal = palFicheroIn.lectura();
                        if (anal.sonPalabrasIguales(pal, aux)) {
                            System.out.println(anal.imprimirLugarExacto(aux));
                        }
                    }
                    break;
                
                case 7:
                    
                    LiniaFicheroIn fichero = new LiniaFicheroIn(nombreFichero);
                    LiniaFicheroOut ficheroCod = new LiniaFicheroOut(nombreFichero+".cod.txt");
                    System.out.print("SEMILLA: ");
                    semilla = LT.readInt();
                    cod = new CodificacionAlfabetica(semilla);
                    Linia secuencia;
                    Linia auxiliar;
                    int codigo;
                    while (fichero.hayLineas()) {
                        auxiliar = new Linia();
                        secuencia = fichero.lectura();
                        for (int i = 0; i < secuencia.getNumeroCaracteres(); i++) {
                            codigo = (char) cod.codificar(secuencia.obtenerCaracter(i));
                            auxiliar.añadirCaracter(codigo);
                        }
                        ficheroCod.escrituraLinia(auxiliar);
                        ficheroCod.nuevaLinea();
                    }
                    fichero.cerrarFichero();
                    ficheroCod.cerrarFichero();
                    break;
                
                case 8:
                    
                    LiniaFicheroIn ficheroCodi = new LiniaFicheroIn(nombreFichero+".cod.txt");
                    LiniaFicheroOut ficheroDec = new LiniaFicheroOut(nombreFichero+".decod.txt");
                    System.out.print("SEMILLA: ");
                    semilla = LT.readInt();
                    cod = new CodificacionAlfabetica(semilla);
                    Linia secuenciaCod;
                    Linia ayuda;
                    int codi;
                    while (ficheroCodi.hayLineas()) {
                        ayuda = new Linia();
                        secuenciaCod = ficheroCodi.lectura();
                        for (int i = 0; i < secuenciaCod.getNumeroCaracteres(); i++) {
                            codi = (char) cod.deCodificar(secuenciaCod.obtenerCaracter(i));
                            ayuda.añadirCaracter(codi);
                        }
                        ficheroDec.escrituraLinia(ayuda);
                        
                    }
                    ficheroCodi.cerrarFichero();
                    ficheroDec.cerrarFichero();
            }
            
        }
    }
    
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
    
    public static void borrarPantalla() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
}
