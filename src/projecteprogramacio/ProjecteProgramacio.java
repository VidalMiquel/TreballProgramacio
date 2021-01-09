package projecteprogramacio;

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
        PalabraFicheroIn palFicheroIn = new PalabraFicheroIn("fitxer.txt");
        PalabraServicio anal = new PalabraServicio();
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
                    while (palFicheroIn.hayPalabras()) {
                        pal = palFicheroIn.lectura();
                        for (int i = 0; i < pal.getNumeroCaracteres(); i++) {
                            caracter = pal.obtenerCaracter(i);
                            anal.incrementarContadorCaracteres(caracter);
                        }

                    }
                    palFicheroIn.cerraFichero();
                    System.out.println(anal.caracterMasRepetidotoString());
                    break;
                case 2:
                    while (palFicheroIn.hayPalabras()) {
                        pal = palFicheroIn.lectura();
                        for (int i = 0; i < pal.getNumeroCaracteres(); i++) {
                            caracter = pal.obtenerCaracter(i);
                            anal.incrementarContadorCaracteres(caracter);
                        }
                    }
                    palFicheroIn.cerraFichero();
                    System.out.println(anal.numeroAparcicionesCaractertoString());
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
                        if (anal.sonIguales(pal, aux)) {
                            System.out.println(anal.imprimirLugarExacto(pal));
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

                    LiniaFicheroIn fichero = new LiniaFicheroIn("fitxer.txt");
                    LiniaFicheroOut ficheroCod = new LiniaFicheroOut("fitxerCod.txt");
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
                    }
                    fichero.cerrarFichero();
                    ficheroCod.cerrarFichero();
                    break;
                case 8:
                    LiniaFicheroIn ficheroCodi = new LiniaFicheroIn("fitxerCod.txt");
                    LiniaFicheroOut ficheroDec = new LiniaFicheroOut("fitxerDecod.txt");
                    cod = new CodificacionAlfabetica(5);
                    Linia secuenciaCod;
                    Linia auxi;
                    int codi;
                    while(ficheroCodi.hayLineas()){
                        auxi = new Linia();
                        secuenciaCod = ficheroCodi.lectura();
                        for(int i = 0; i< secuenciaCod.getNumeroCaracteres();i++){
                            codi = (char)cod.deCodificar(secuenciaCod.obtenerCaracter(i));
                            auxi.añadirCaracter(codi);
                        }
                        ficheroDec.escrituraLinia(auxi);
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
