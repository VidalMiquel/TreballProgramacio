package projecteprogramacio;

import java.io.IOException;

public class ProjecteProgramacio {

    //Declarcions de variables globals.
    private String nombreFichero;
    private boolean sortir = false;

    public void ProgramaPrincipal() throws Exception {
        CodificacionAlfabetica cod;
        int semilla;
        PalabraServicio anal;

        System.out.println("PRÁCTICA PROGRAMACIÓN I: ANALIZADOR DE FICHEROS.");
        //Realitzam les comprovacions prèvies per poder tractar un fitxer.
        abrirArchivo();
        if (!sortir) {
            //Comprovam si el fitxer a tractar ésta codificat.
            comprovarCodificacio();
        }
        if (!sortir) {
            //Analitzam el fitxer, imprimim per pantalla les dades demenades.
            this.sortir = Analisis.analisis(nombreFichero);
        }

        while (!sortir) {
            //"Borram" la pantalla per fer còmodo la visualització dels
            //resultats i del menú d'opcions.
            borrarPantalla();
            //Mostram per pantalla el menú d'opcions.
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
                            + "pantalla la localización exacta de dos palabras "
                            + "seguidas iguales en el fichero. \n");
                    anal = new PalabraServicio();
                    anal.palabraSeguidas(nombreFichero);
                    break;

                case 7:
                    //Sèptima opció del menú.
                    System.out.println("La opción introducida es codificar el "
                            + "fichero tratado hasta el momento.");
                    System.out.println("Creamos un fichero con la extensión"
                            + "'.cod.txt' \n");
                    System.out.print("Introducir semilla: ");
                    semilla = LT.readInt();
                    System.out.println("");
                    cod = new CodificacionAlfabetica(semilla);
                    cod.codificarTexto(nombreFichero);
                    break;

                default:
                    //Codi a ejecutar en cas de que la opció introduïda no
                    //és correcte.
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

    //Mètode que engloba la opertura del fitxer i la comprovació de la seva
    //existència.
    private void abrirArchivo() throws Exception {
        PalabraServicio anal = new PalabraServicio();
        System.out.print("Nombre del fichero a analizar: ");
        nombreFichero = LT.readLine();

        try {
            PalabraFicheroIn palFicheroIn = new PalabraFicheroIn(nombreFichero);
            //Comprovam que el fitxer no sobrapassi el límit de 
            //paraules diferents.
            this.sortir = anal.comprovarParaulesDiferents(nombreFichero);
            palFicheroIn.cerrarFichero();
        } catch (IOException ex) {
            //Codi a executar en el cas de la no existència del fitxer.
            System.out.println("El fichero deseado no existe. Ninguna opción del menu es aplicable.");
            sortir = true;
        }
    }

    //Mètode que comprova si el fitxer a tractar està codificat o no.
    private void comprovarCodificacio() throws Exception {
        if (comprovarTerminacion()) {
            System.out.println("ATENCIÓN: El fichero introducido esta codificado.\n"
                    + "Quieres decodificarlo antes de entrar al menu?(s/n)");
            //Codi a executar si volem decodificar el fitxer a tractar.
            if ('s' == LT.readChar()) {
                System.out.print("Introduce la semilla: ");
                int semilla = LT.readInt();
                CodificacionAlfabetica cod = new CodificacionAlfabetica(semilla);
                //Decodificam el fitxer
                cod.deCodificarTexto(nombreFichero);
                //Nou nom del fitxer, actualment decodificat.
                nombreFichero += ".decod.txt";
            } else {
                //Codi a executar si volem  NO volem decodificar 
                //el fitxer a tractar.
                System.out.println("Continuando con el archivo codificado...");
            }
        }
    }

    //Mètode que comprova si el fitxer a tractar està codificat.
    private boolean comprovarTerminacion() {
        //Convertim els Strings a Char [] per poder tractarlos
        char[] cod = ".cod.txt".toCharArray();
        char[] nom = nombreFichero.toCharArray();
        //Comprovam que la longitud del nom sigui mes gran que 
        //la terminacio a comprovar
        if (cod.length <= nom.length) {
            int nomI = nom.length - 1;
            int codI = cod.length - 1;
            //Bucle que comprova si el final del nom del arxiu es igual 
            //a la terminacio
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

    //Mètode que duu a terme la cerca d'un text introduït per teclat
    //dins el fitxer que tractam.
    private void buscarTexto() throws Exception {

        boolean encontrado = false;
        System.out.print("Texto a buscar (máximo 250 caracteres): ");
        String texto = LT.readLine();
        System.out.println("");
        //Assignam a secuenciaBuscada el text a cercar al fitxer.
        Linia secuenciaBuscada = new Linia(texto);
        Linia secuenciaLeida;
        LiniaFicheroIn fich = new LiniaFicheroIn(nombreFichero);

        //Llegim linies del fitxer que tractam.
        while (fich.hayLineas()) {
            secuenciaLeida = fich.lectura();
            //Comprovam si la linia llegida, conté el text a cercar.
            if (secuenciaLeida.contienePalabra(secuenciaBuscada)) {
                encontrado = true;
                //Imprimim per pantalla el lloc exacte on es troba 
                //el text introduït per teclat.
                System.out.println("El texto: "
                        + secuenciaBuscada.toString()
                        + secuenciaLeida.imprimirLugarExacto());
            }
        }
        //En el cas de no haver trobat el text cercat, mostram 
        //per pantalla el següent codi.
        if (!encontrado) {
            System.out.println("El texto a buscar no aparece en el"
                    + "fichero.");
        }
    }

    public static void main(String[] args) throws Exception {
        new ProjecteProgramacio().ProgramaPrincipal();
    }
}
