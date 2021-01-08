package projecteprogramacio;

public class ProjecteProgramacio {

    public static void main(String[] args) throws Exception {
        new ProjecteProgramacio().ProgramaPrincipal();

    }

    public void ProgramaPrincipal() throws Exception {
        boolean sortir = false;

        Palabra pal = new Palabra();
        Buscador busca = new Buscador();
        System.out.println("NOMBRE DEL FICHERO A ANALIZAR: ");
        String nombreFichero = LT.readLine();
        PalabraFicheroIn palFicheroIn = new PalabraFicheroIn("fitxer.txt");
        Analisi anal = new Analisi();
        while (palFicheroIn.hayPalabras()) {
            pal = palFicheroIn.lectura();
            anal.incrementarNumeroPalabras();

            for (int i = 0; i < pal.getNumeroCaracteres(); i++) {
                char caracter = pal.obtenerCaracter(i);
                anal.incrementarContadorCaracteres(caracter);
                anal.incrementarNumeroCaracteres();

            }
            anal.prova(pal);
            System.out.println(pal.toString());
        }
        palFicheroIn.cerraFichero();
        System.out.println(anal.caracterMasRepetidotoString());
        System.out.println("EL NUMERO DE PALABRAS QUE HAY SON: " + anal.getNumeroPalabras());
        System.out.println("EL NUMERO DE CARACTERES QUE HAY SON: " + anal.getNumeroCaracteres());
        System.out.println(anal.palabraMasRepetidatoString());

        while (!sortir) {
            borrarPantalla();
            menu();
            System.out.print("INTRODUCE LA OPCION A RELAIZAR: ");
            int opcioMenu = LT.readInt();
            switch (opcioMenu) {

                case 0:
                    sortir = true;
                    break;
                case 1:
                    System.out.println("OPCIÓN 1");
                    anal.imprimirNumeroCaractersArrayparaula();
                    break;
                case 2:
                    System.out.println("OPCIÓN 2");
                    break;
                case 3:
                    System.out.println("OPCIÓN 3");
                    break;
                case 4:
                    Palabra aux;
                     PalabraFicheroIn palFicheroIn1 = new PalabraFicheroIn("fitxer.txt");
                    System.out.println("OPCION BUSCAR UNA PALABRA EN EL FICHERO:");
                    System.out.println("PALABRA A BUSCAR:");
                    String palabra = LT.readLine();
                    aux = new Palabra(palabra);
                      System.out.println("LA PALABRA BUSCADA ES: " + aux);
                    while (palFicheroIn1.hayPalabras()) {
                        pal = palFicheroIn1.lectura();
                        if(anal.sonIguales(pal, aux)){
                 System.out.println(busca.imprimirLugarExacto(pal));   
                        }

                    }
                    palFicheroIn.cerraFichero();
                    break;
                case 5:
                    System.out.println("OPCIÓN 5");
                    break;
                case 6:
                    System.out.println("OPCIÓN 6");
                    break;
                case 7:
                    System.out.println("OPCIÓN 7");
                    break;
                case 8:
                    System.out.println("OPCIÓN 8");

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
