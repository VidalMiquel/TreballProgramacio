package projecteprogramacio;

import java.io.IOException;

public class ProjecteProgramacio {

    private String nombreFichero;
    private boolean sortir = false;

    public void ProgramaPrincipal() throws Exception {
        CodificacionAlfabetica cod;
        int semilla;
        PalabraServicio anal;

        abrirArchivo();
        if (!sortir) {
            comprovarCodificacio();
        }
        if (!sortir) {
            this.sortir = Analisis.analisis(nombreFichero);
        }

        while (!sortir) {
            borrarPantalla();
            menu();
            System.out.print("Introduce la opción ha realizar: ");
            int opcioMenu = LT.readInt();
            System.out.println(" ");
            switch (opcioMenu) {
                case 0:
                    //Sortir del while, fi del programa.
                    sortir = true;
                    break;

                case 1:
                    //Primera opció del menú.
                    anal = new PalabraServicio();
                    System.out.println("La opción introducida es mostrar por "
                            + "pantalla la letra más repetida y su frecuecnia de "
                            + "aparición. \n");
                    anal.letraMasRepetida(nombreFichero);
                    break;

                case 2:
                    //Segona opció del menú.
                    anal = new PalabraServicio();
                    System.out.println("La opción introducida es mostrar por "
                            + "pantalla la frecuencia de aparición de los "
                            + "caracteres que forman el fichero. ");
                    anal.frecuenciaCaracteres(nombreFichero);
                    break;

                case 3:
                    //Tercera opció del menú.
                    System.out.println("La opción introducida es mostrar por "
                            + "pantalla la(s) palabra(s) que más se reptie "
                            + "en el fichero. \n");
                    anal = new PalabraServicio();
                    anal.palabraMasFrecuente(nombreFichero);
                    break;

                case 4:
                    //Quarta opció del menú.
                    System.out.println("La opción introducia es mostrar por "
                            + "pantalla la localización exacta de la palabra "
                            + "introducida por teclado en el fichero. \n");
                    anal = new PalabraServicio();
                    anal.localizarPalabra(nombreFichero);
                    break;

                case 5:
                    System.out.println("La opción introducida es mostrar por "
                            + "pantalla la localización exacta del texto "
                            + "introducido por teclado en el fichero. \n");
                    buscarTexto();
                    
                    break;

                case 6:
                    //Sexta opció del menú.
                    System.out.println("La opción introducida es mostar por "
                            + "pantalla la localización exacte de dos palabras "
                            + "seguidas iguales en el fichero. \n");
                    anal = new PalabraServicio();
                    anal.palabraSeguidas(nombreFichero);
                    break;

                case 7:
                    //Sèptima opció del menú.
                    System.out.println("La opción introducida es codiifcar el "
                            + "fichero tractado hasta el momento.");
                    System.out.println("Creamos un fichero con la extensión"
                            + "'.cod.txt' \n");
                    System.out.print("Introducir semilla: ");
                    semilla = LT.readInt();
                    System.out.println("\n");
                    cod = new CodificacionAlfabetica(semilla);
                    cod.codificarTexto(nombreFichero);
                    break;

                default:
                    System.out.println("Opción introducida incorrecta.");
                    
                    
            }

        }
    }

    //Mètode per imprimir per pantalla el menu.
    public void menu() {
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
        System.out.println("MENU DE OPCIONES: ");
        System.out.println("0.SALIR DEL PROGRAMA");
        System.out.println("1.LETRA MÁS REPTIDA Y NÚMERO DE APARICIONES");
        System.out.println("2.NÚMERO DE APARICIONES DE CADA CARÁCTER");
        System.out.println("3.PALABRA MÁS REPETIDA Y NÚMERO DE APARICIONES");
        System.out.println("4.BUSCAR UNA PALABRA");
        System.out.println("5.BUSCAR UN TEXTO");
        System.out.println("6.BUSCAR PALABRAS REPETIDAS");
        System.out.println("7.CODIFICAR UN FICHERO");
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");

    }

    //Mètode duu a terme el borrat de la pantalla per clarificar el resultat
    //obtingut.
    public static void borrarPantalla() {
        System.out.print("\n\n\n\n\n\n\n\n\n");
    }

    private void abrirArchivo() throws Exception {
        PalabraServicio anal = new PalabraServicio();
        System.out.println("NOMBRE DEL FICHERO A ANALIZAR: ");
        nombreFichero = LT.readLine();

        try {
            PalabraFicheroIn palFicheroIn = new PalabraFicheroIn(nombreFichero);
            this.sortir = anal.comprovarParaulesDiferents(nombreFichero);
            palFicheroIn.cerrarFichero();
        } catch (IOException ex) {
            System.out.println("El fichero deseado no existe. Ninguna opción del menu es aplicable");
            sortir = true;
        }
    }

    private void comprovarCodificacio() throws Exception {
        if (comprovarTerminacion()) {
            System.out.println("ATENCIÓN: El fichero introducido esta codificado.\n"
                    + "Quieres decodificarlo antes de entrar al menu?(s/n)");
            if ('s' == LT.readChar()) {
                System.out.println("Introduce la semilla: ");
                CodificacionAlfabetica cod = new CodificacionAlfabetica(LT.readInt());
                cod.deCodificarTexto(nombreFichero);
                nombreFichero += ".decod.txt";
            } else {
                System.out.println("Continuando con el archivo codificado...");
            }
        }
    }

    //Metode que comprova si el nom del fitxer ens diu que esta codificat
    private boolean comprovarTerminacion() {
        char[] cod = ".cod.txt".toCharArray();
        char[] nom = nombreFichero.toCharArray();

        if (cod.length <= nom.length) {
            int nomI = nom.length - 1;
            int codI = cod.length - 1;

            for (; (codI >= 0); codI--) {
                if (cod[codI] != nom[nomI]) {
                    return false;
                }
                nomI--;
            }
            return true;
        } else {
            return false;
        }
    }
    
    
    private void buscarTexto()throws Exception{
        
        boolean encontrado = false;
        System.out.print("Texto a buscar (máximo 250 caracteres): ");
                    String texto = LT.readLine();
                    System.out.println("");
                    Linia secuenciaBuscada = new Linia(texto);
                    Linia secuenciaLeida;
                    LiniaFicheroIn fich = new LiniaFicheroIn(nombreFichero);

                    while (fich.hayLineas()) {
                        secuenciaLeida = fich.lectura();
                        if (secuenciaLeida.contienePalabra(secuenciaBuscada)) {
                            encontrado = true;
                            System.out.println("El texto: "
                                    + secuenciaBuscada.toString()
                                    + secuenciaLeida.imprimirLugarExacto());
                        }
                    }
                    if(!encontrado){
                        System.out.println("El texto a buscar no aparece en el"
                                + "fichero.");
                    }
    }

    public static void main(String[] args) throws Exception {
        new ProjecteProgramacio().ProgramaPrincipal();
    }
}
