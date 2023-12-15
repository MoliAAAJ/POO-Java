import java.util.Scanner;
import java.sql.Timestamp;
import java.awt.EventQueue; // Permite gestionar la cola de eventos en aplicaciones con interfaces gráficas de usuario.


public class App {

    public static void main(String[] args) throws Exception {

        Scanner escanear = new Scanner(System.in);

        limpiarPantalla();
        bienvenida();

        int opcion;

        do {

            menu();

            System.out.print("Por favor, ingrese un número correspondiente a la opción que desea ejecutar: ");
            opcion = Integer.parseInt(escanear.nextLine());

            selector(opcion);

        }while (opcion != 5);

        escanear.close();

    }

    public static void bienvenida() {

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";

        System.out.println(green + "\n\nBIENVENIDO AL PROGRAMA QUE RECREA EL JUEGO DE AJEDREZ SEGUN 'EL HACEDOR' de Jorge Luis Borges" + reset);
        System.out.println(red + "---------------------------------------------------------------------------------------------\n" + reset);
        System.out.println(green + "Usted dispone de tres opciones para conocer los diferentes elementos del juego.\n" + reset);
        System.out.println(red + "=======================================================================================" + reset);

    }

    public static void menu() {

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String blue = "\u001B[34m";

        System.out.println(green + " MENU DE OPCIONES " + reset);
        System.out.println(red + "==========================================================================================================================================" + reset);
        System.out.println(blue + " (1) - Texto literario " + "| (2) - El tablero y la filosofía " + "| (3) - Las piezas " + "| (4) - Mostrar las piezas de la BD " + "| (5) - Salir del programa " + reset);
        System.out.println(red + "==========================================================================================================================================\n" + reset);

    }

    public static void selector(int opcion) {
        
        switch(opcion) {
        
            case 1:
                limpiarPantalla();
                textoLiterario();
            break;

            case 2:
                limpiarPantalla();
                crearTablero();
                imprimirTablero();
                analisisPoema();
            break;
                
            case 3:
                limpiarPantalla();
                crearPiezas();
            break;

            case 4:
                limpiarPantalla();
                iPiezaDAO iPieza = new PiezaDAO();
                mostrarVentana(iPieza);
            break;
            
            case 5:
                salida();
            break;

            default:
                System.out.println("Usted ingresó un número de opción no válido. Por favor, intente nuevamente.\n");
            break;

        }
        
    }

    public static void textoLiterario() {

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";

        System.out.println(green + "\nFragmento de EL HACEDOR de Jorge Luis Borges" + reset);
        System.out.println(green + "                  AJEDREZ               " + reset);
        System.out.println(red + "--------------------------------------------" + reset);

        System.out.println(yellow + "\nEn su grave rincón, los jugadores\n" +
        "Rigen las lentas piezas\n" + 
        "Los demora hasta el alba en su severo\n" + 
        "Ámbito en qué se odian dos colores.\n\n" +
        "Adentro irradian mágicos rigores\n" + 
        "Las formas: torre homérica, ligero\n" + 
        "Caballo, armada reina, rey postrero,\n" + 
        "Oblícuo alfil y peones agresores\n\n" + 
        "Cuando los jugadores se hayan ido,\n" + 
        "Cuando el tiempo los haya consumido,\n" + 
        "Ciertamente no habrá cesado el rito.\n\n" + 
        "En el oriente, se encendió esta guerra\n" + 
        "Cuyo anfiteatro es hoy toda la tierra.\n" + 
        "Como el otro, este juego es infinito.\n\n" + 
        "Tenue rey, sesgo alfil, encarnizada\n" + 
        "Reina, torre directa y peón ladino\n" + 
        "Sobre lo negro y blanco del camino\n" + 
        "Buscan y libran su batalla armada.\n\n" + 
        "No saben que la mano señalada\n" + 
        "Del jugador gobierna su destino,\n" + 
        "No saben qué un rigor adamantino\n" + 
        "Sujeta su albedrío y su jornada.\n\n" + 
        "También el jugador es prisionero\n" + 
        "(La sentencia es de Omar) de otro tablero\n" + 
        "De negras noches y de blancos días.\n\n" + 
        "Dios mueve al jugador, y éste, la pieza.\n" + 
        "¿Qué dios detrás de Dios la trama empieza\n" + 
        "De polvo y tiempo y sueño y agonías?\n\n" + reset);

    }

    public static Tablero crearTablero() {

        Casillero[][] casilleros = new Casillero[8][8];
        
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                
                if ((i + j) % 2 == 0) {

                    casilleros[i][j] = new Casillero("blanco");

                } else {

                    casilleros[i][j] = new Casillero("negro");

                }

            }

        }
        
        Tablero tablero = new Tablero(casilleros);

        return tablero;

    }

    public static void imprimirTablero() {

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";

        System.out.println(green + "\n\n                  EL TABLERO                    " + reset);
        System.out.println(red + "----------------------------------------------------\n\n" + reset);

        char[][] tablero = new char[8][8];

        for (int fila = 0; fila < 8; fila++) {

            for (int columna = 0; columna < 8; columna++) {

                if ((fila + columna) % 2 == 0) {

                    tablero[fila][columna] = '■'; // Casillero negro

                } else {

                    tablero[fila][columna] = '□'; // Casillero blanco

                }

            }

        }

        System.out.println("  a b c d e f g h");

        for (int fila = 0; fila < 8; fila++) {

            System.out.print(8 - fila + " ");

            for (int columna = 0; columna < 8; columna++) {

                System.out.print("|" + tablero[fila][columna]);

            }

            System.out.println("| " + (8 - fila));

        }

        System.out.println("  a b c d e f g h\n\n");

    }

    public static void analisisPoema() {

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String italicaIn = "\u001B[3m";
        String italicaOut = "\u001B[0m";

        System.out.println(green + "\nINTERPRETACION FILOSOFICA" + reset);
        System.out.println(red + "-------------------------\n" + reset);

        // Definimos el texto que queremos en itálicas utilizando el código ANSI \u001B[3m al principio y \u001B[0m al final del texto.

        System.out.println(italicaIn + "En este poema, Borges explora el mundo del ajedrez como un microcosmos lleno de significado\n" +
        "y simbolismo. El poema presenta un tablero de ajedrez y las piezas como elementos que\n" + 
        "representan la vida y la muerte," +
        " el tiempo y el espacio, y los misterios del universo.\n\n" + italicaOut);

    }

    public static void crearPiezas() {

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";

        iPiezaDAO iPieza = new PiezaDAO();

        Peon[] peonesBlancos = new Peon[8];

        for (int i = 0; i < 8; i++) {

            Peon peon = new Peon();
            peon.setColor("blanco");
            peon.setMovimiento("agresor");
            peon.setComportamiento("ladino");
            peonesBlancos[i] = peon;
             
            Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());

            iPieza.insertarPieza(6, 1, peon.getMovimiento(), peon.getComportamiento(), fechaCreacion, 1, 1, "-");

        }

        Peon[] peonesNegros = new Peon[8];

        for (int i = 0; i < 8; i++) {

            Peon peon = new Peon();
            peon.setColor("negro");
            peon.setMovimiento("agresor");
            peon.setComportamiento("ladino");
            peonesNegros[i] = peon;

            Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());

            iPieza.insertarPieza(6, 2, peon.getMovimiento(), peon.getComportamiento(), fechaCreacion, 1, 1, "-");

        }

        Torre[] torresBlancas = new Torre[2];

        for (int i = 0; i < 2; i++) {

            Torre torre = new Torre();
            torre.setColor("blanca");
            torre.setMovimiento("directa");
            torre.setComportamiento("homerica");
            torresBlancas[i] = torre;

            Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());

            iPieza.insertarPieza(3, 1, torre.getMovimiento(), torre.getComportamiento(), fechaCreacion, 1, 1, "-");

        }

        Torre[] torresNegras = new Torre[2];
        
        for (int i = 0; i < 2; i++) {

            Torre torre = new Torre();
            torre.setColor("negra");
            torre.setMovimiento("directa");
            torre.setComportamiento("homerica");
            torresNegras[i] = torre;

            Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());

            iPieza.insertarPieza(3, 2, torre.getMovimiento(), torre.getComportamiento(), fechaCreacion, 1, 1, "-");

        } 

        Caballo[] caballosBlancos = new Caballo[2];

        for (int i = 0; i < 2; i++) {

            Caballo caballo = new Caballo();
            caballo.setColor("blanco");
            caballo.setComportamiento("ligero");
            caballosBlancos[i] = caballo;

            Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());

            iPieza.insertarPieza(5, 1, caballo.getMovimiento(), caballo.getComportamiento(), fechaCreacion, 1, 1, "-");

        }
        
        Caballo[] caballosNegros = new Caballo[2];

        for (int i = 0; i < 2; i++) {

            Caballo caballo = new Caballo();
            caballo.setColor("negro");
            caballo.setComportamiento("ligero");
            caballosNegros[i] = caballo;

            Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());

            iPieza.insertarPieza(5, 2, caballo.getMovimiento(), caballo.getComportamiento(), fechaCreacion, 1, 1, "-");

        }    

        Alfil[] alfilesBlancos = new Alfil[2];

        for (int i = 0; i < 2; i++) {
            
            Alfil alfil = new Alfil();
            alfil.setColor("blanco");
            alfil.setMovimiento("oblicuo");
            alfil.setComportamiento("sesgo");
            alfilesBlancos[i] = alfil;

            Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());

            iPieza.insertarPieza(4, 1, alfil.getMovimiento(), alfil.getComportamiento(), fechaCreacion, 1, 1, "-");

        }

        Alfil[] alfilesNegros = new Alfil[2];

        for (int i = 0; i < 2; i++) {
            
            Alfil alfil = new Alfil();
            alfil.setColor("negro");
            alfil.setMovimiento("oblicuo");
            alfil.setComportamiento("sesgo");
            alfilesNegros[i] = alfil;

            Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());

            iPieza.insertarPieza(4, 2, alfil.getMovimiento(), alfil.getComportamiento(), fechaCreacion, 1, 1, "-");

        }

        Timestamp fechaCreacion = new Timestamp(System.currentTimeMillis());
        
        Reina reinaBlanca = new Reina();
        reinaBlanca.setColor("blanca");
        reinaBlanca.setMovimiento("armada");
        reinaBlanca.setComportamiento("encarnizada");

        iPieza.insertarPieza(1, 1, reinaBlanca.getMovimiento(), reinaBlanca.getComportamiento(), fechaCreacion, 1, 1, "-");


        Reina reinaNegra = new Reina();
        reinaNegra.setColor("negra");
        reinaNegra.setMovimiento("armada");
        reinaNegra.setComportamiento("encarnizada");

        iPieza.insertarPieza(1, 2, reinaNegra.getMovimiento(), reinaNegra.getComportamiento(), fechaCreacion, 1, 1, "-");

        Rey reyBlanco = new Rey();
        reyBlanco.setColor("blanco");
        reyBlanco.setMovimiento("postrero");
        reyBlanco.setComportamiento("tenue");

        iPieza.insertarPieza(2, 1, reyBlanco.getMovimiento(), reyBlanco.getComportamiento(), fechaCreacion, 1, 1, "-");

        Rey reyNegro = new Rey();
        reyNegro.setColor("negro");
        reyNegro.setMovimiento("postrero");
        reyNegro.setComportamiento("tenue");
        
        iPieza.insertarPieza(2, 2, reyNegro.getMovimiento(), reyNegro.getComportamiento(), fechaCreacion, 1, 1, "-");

        System.out.println(green + "\nLAS PIEZAS Y SUS ATRIBUTOS" + reset);
        System.out.println(red + "--------------------------\n\n" + reset);
        System.out.println("                    PIEZAS BLANCAS");
        System.out.println("                    --------------\n");

        for (int i = 0; i < 8; i++) {

            peonesBlancos[i].mover();

        }

        System.out.print("\n");

        for (int i = 0; i < 2; i++) {

            torresBlancas[i].mover();

        }

        System.out.print("\n");

        for (int i = 0; i < 2; i++) {

            caballosBlancos[i].mover();

        }

        System.out.print("\n");

        for (int i = 0; i < 2; i++) {

            alfilesBlancos[i].mover();

        }

        System.out.print("\n");

        reinaBlanca.mover();
        reyBlanco.mover();

        System.out.print("\n\n");

        System.out.println("                    PIEZAS NEGRAS");
        System.out.println("                    -------------\n");

        for (int i = 0; i < 8; i++) {

            peonesNegros[i].mover();

        }

        System.out.print("\n");

        for (int i = 0; i < 2; i++) {

            torresNegras[i].mover();

        }

        System.out.print("\n");

        for (int i = 0; i < 2; i++) {

            caballosNegros[i].mover();

        }

        System.out.print("\n");

        for (int i = 0; i < 2; i++) {

            alfilesNegros[i].mover();

        }

        System.out.print("\n");

        reinaNegra.mover();
        reyNegro.mover();

        System.out.print("\n\n");

    }

    public static void salida() {

        String reset = "\u001B[0m";
        String green = "\u001B[32m";
        
        System.out.println(green + "\n\n--------------------------------------------------------------------------------------" + reset);
        System.out.println(green + "Gracias por utilizar el programa. ADIOS!!!" + reset);
        System.out.println(green + "--------------------------------------------------------------------------------------\n\n" + reset);
        
    }

    public static void limpiarPantalla() {
        
        try {
            // Verifica el sistema operativo para determinar el comando de limpieza adecuado
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                // Para Windows
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                pb.inheritIO().start().waitFor();

            } else {
                // Para sistemas Unix (Linux, macOS)
                ProcessBuilder pb = new ProcessBuilder("clear");
                pb.inheritIO().start().waitFor();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        
    }

    public static void mostrarVentana(iPiezaDAO iPieza) {

        // Invoca el código en el hilo de eventos de la interfaz de usuario
        EventQueue.invokeLater(new Runnable() {

            public void run() {

                try {

                    // Se crea una instancia de la interfaz 'Ventana' pasando 'iPieza' como argumento
                    Ventana frame = new Ventana(iPieza);
                    frame.setVisible(true); // Hace qué la ventana sea visible

                } catch (Exception e) {

                    // Si se produce una excepción, imprime el rastreo de la pila en la salida de error
                    e.printStackTrace();

                }

            }
            
        });

    }

}
