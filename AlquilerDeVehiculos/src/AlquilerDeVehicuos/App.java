package AlquilerDeVehicuos;

import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {

        limpiarPantalla();

        Scanner escanear = new Scanner(System.in);

        bienvenida();

        int opcion;

        do {

            menu();

            System.out.print("Por favor, ingrese un número correspondiente al tipo de vehículo seleccionado por el cliente: ");
            opcion = Integer.parseInt(escanear.nextLine());

            selector(opcion);

        } while (opcion != 7);

        escanear.close();
        
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

    public static void bienvenida() {

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";        

        System.out.println(green + "\n\nBIENVENIDO AL PROGRAMA QUE CALCULA EL VALOR DE ALQUILER DE UN VEHICULO" + reset);
        System.out.println(red + "----------------------------------------------------------------------\n" + reset);
        System.out.println(green + "El cliente dispone de dos opciones, puede cotizar por consola o por medio de una GUI." + reset);
        System.out.println(red + "-------------------------------------------------------------------------------------\n" + reset);

    }

    public static void menu() {

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String blue = "\u001B[34m";        

        System.out.println(green + " MENU DE OPCIONES " + reset);
        System.out.println(red + "=============================================================================================================================" + reset);
        System.out.println(blue + " (1) - Auto " + "| (2) - Minibus " + "| (3) - Furgoneta |" + " (4) - Camión |" + " (5) - Cotizador Gráfico |" + " (6) - Ver Cotizaciones |" + " (7) - Salir " + reset);
        System.out.println(red + "=============================================================================================================================\n" + reset);

    }

    public static void selector(int opcion) {

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String blue = "\u001B[34m";
        String yellow = "\u001B[33m";        
        
        switch(opcion) {

            case 1:

                limpiarPantalla();

                System.out.println(red + "\n============================================" + reset + blue + "AUTO" + reset + red + "============================================" + reset);

                int cantA = cantidadDias();

                Auto auto = new Auto("AC 175 VF");

                System.out.printf("\n\nEl precio de alquiler del auto patente " + yellow +  "%s" + reset +  " por %s dia/s es " + yellow + "$ %s" + reset, auto.getPatente(), cantA, auto.calcularPrecioAlquiler(cantA));


                System.out.println(red + "\n\n\n============================================================================================\n\n" + reset);

            break;

            case 2:

                limpiarPantalla();

                System.out.println(red + "\n============================================" + reset + blue + "MINIBUS" + reset + red + "============================================" + reset);

                int cantM = cantidadDias();

                Minibus minibus = new Minibus("AB 112 HY");

                System.out.printf("\n\nEl precio de alquiler de el minibus patente " + yellow +  "%s" + reset +  " por %s dia/s es " + yellow + "$ %s" + reset, minibus.getPatente(), cantM, minibus.calcularPrecioAlquiler(cantM));

                System.out.println(red + "\n\n\n==============================================================================================\n\n" + reset);
                 
            break;
                
            case 3:

                limpiarPantalla();

                System.out.println(red + "\n============================================" + reset + blue + "FURGONETA" + reset + red + "============================================" + reset);

                int cantF = cantidadDias();

                Furgoneta furgoneta = new Furgoneta("AE 458 BD");

                System.out.printf("\n\nEl precio de alquiler de la furgoneta patente " + yellow +  "%s" + reset +  " por %s dia/s es " + yellow + "$ %s" + reset, furgoneta.getPatente(), cantF, furgoneta.calcularPrecioAlquiler(cantF));

                System.out.println(red + "\n\n\n==============================================================================================\n\n" + reset);
                
            break;

            case 4:

                limpiarPantalla();

                System.out.println(red + "\n============================================" + reset + blue + "CAMION" + reset + red + "============================================" + reset);

                int cantC = cantidadDias();

                Camion camion = new Camion("AD 458 UI");

                System.out.printf("\n\nEl precio de alquiler de el camión patente " + yellow +  "%s" + reset +  " por %s dia/s es " + yellow + "$ %s" + reset, camion.getPatente(), cantC, camion.calcularPrecioAlquiler(cantC));

                System.out.println(red + "\n\n\n==============================================================================================\n\n" + reset);
                
            break;

            case 5:

                limpiarPantalla();
                List<Vehiculo> vehiculos = new VehiculoDAO().imprimirListadoVehiculos();
                iniciarGUI(vehiculos);

            break;

            case 6:

                limpiarPantalla();
                SwingUtilities.invokeLater(HistorialGUI::new);

            break;

            case 7:

                limpiarPantalla();
                salida();

            break;

            default:

                System.out.println("Usted ingresó un número de opción no válido. Por favor, intente nuevamente.\n");

            break;

        }
        
    }

    public static int cantidadDias() { 

        Scanner escanear = new Scanner(System.in);

        System.out.print("\n\nPor favor, ingresar la cantidad de días que desea alquilar el tipo de vehículo seleccionado: ");
        int dias = Integer.parseInt(escanear.nextLine());

        return dias;

    }

    public static void salida() {

        String reset = "\u001B[0m";
        String green = "\u001B[32m";
        
        System.out.println(green + "\n\n--------------------------------------------------------------------------------------" + reset);
        System.out.println(green + "Gracias por utilizar el programa. ADIOS!!!" + reset);
        System.out.println(green + "--------------------------------------------------------------------------------------\n\n" + reset);
        
    }

    public static void iniciarGUI(List<Vehiculo> vehiculos) {

        SwingUtilities.invokeLater(() -> {

            VehiculoGUI gui = new VehiculoGUI(vehiculos);
            gui.setVisible(true);

         });
    }

}
