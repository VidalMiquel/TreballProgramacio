package projecteprogramacio;

import java.io.IOException;

public class ProjecteProgramacio {

    private String nombreFichero;
    private boolean sortir = false;

    public void ProgramaPrincipal() throws Exception {
        CodificacionAlfabetica cod;
        int semilla;
        PalabraServicio anal = new PalabraServicio();

        abrirArchivo();
        comprovarCodificacio();
        Analisis.analisis(nombreFichero);

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
                            System.out.println("LA LINIA: "
                                    + secuenciaBuscada.toString()
                                    + secuenciaLeida.imprimirLugarExacto());
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
        System.out.println("0.SALIR DEL PROGRAMA");
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

    public static void main(String[] args) throws Exception {
        new ProjecteProgramacio().ProgramaPrincipal();
    }
}
