package Tigre; // Se importa el paquete de la clase.
import java.util.Scanner; // Se importa el paquete que permite utilizar el comando Scanner.

public class App {
    public static void main(String[] args) throws Exception {
        
        menu();

        try (Scanner escanear = new Scanner(System.in)) { // Se utiliza el comando Scanner dentro de un TRY para evita tener que cerrarlo.

            System.out.print("Por favor, ingrese un número correspondiente a la opción que desea ejecutar: ");
            int opcion = Integer.parseInt(escanear.nextLine());

            if (validarOpcion(opcion)) {

                selector(opcion);

            } else {

                System.out.println("\nUsted ha ingresado un número no válido. El sistema se cerrará.\n");

            }

        } catch (Exception e) {

            System.out.println("\nUsted ingresó un caracter no válido. El sistema se cerrará.\n");

        }

        salida();

    }

    //* FUNCIÓN QUE MUESTRA EL MENÚ PRINCIPAL EN PANTALLA */
    public static void menu() {

        String reset = "\u001B[0m";
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String blue = "\u001B[34m";

        System.out.println(green + "\n\nBIENVENIDO AL PROGRAMA QUE INTERACTÚA CON 'EL ORO DE LOS TIGRES' de Jorge Luis Borges" + reset);
        System.out.println(red + "-------------------------------------------------------------------------------------\n" + reset);
        System.out.println(green + "Usted dispone de tres opciones para versionar el fragmento del libro.\n" + reset);
        System.out.println(red + "======================================================================================" + reset);
        System.out.println(green + " MENÚ DE OPCIONES " + reset);
        System.out.println(red + "======================================================================================" + reset);
        System.out.println(blue + " (1) - Versión original de Jorge Luis Borges " + reset);
        System.out.println(blue + " (2) - Versión de José Luis " + reset);
        System.out.println(blue + " (3) - Versión personalizada por usted " + reset);
        System.out.println(red + "=====================================================================================\n" + reset);
        
    }

    //* FUNCIÓN QUE VALIDA SI LA OPCIÓN INGRESADA POR EL USUARIO ESTÁ DENTRO DE LOS PARÁMETROS CORRECTOS */    
    public static boolean validarOpcion(int numero) {
        
        if (numero < 1 || numero > 3) {
        
            return false;
        } else {
        
            return true;
        
        }
        
    }

    //* FUNCIÓN QUE DIRECCIONA EL FLUJO DEL PROGRAMA SEGÚN LA SELECCIÓN DEL USUARIO */    
    public static void selector(int opcion) {
        
        switch(opcion) {
        
            case 1:
                tigreBorges();
            break;
            case 2:
                tigreJose();
            break;
            case 3:
                tigreUsuario();
            break;

        }
        
    }

    //* SE CREA LA INSTANCIA SEGÚN EL FRAGMENTO ORIGINAL DE BORGES */    
    public static void tigreBorges() {

        String reset = "\u001B[0m";
        String green = "\u001B[32m"; 
        
        Tigre tigrePalermo = new Tigre("hermoso", "delicado", "sanguinario", "fatal", "infinito");
        System.out.println(green + "\n\nVersión original de Jorge Luis Borges" + reset);
        System.out.println(green + "=====================================\n" + reset);
        imprimir(tigrePalermo);
        System.out.println("\n\n");
        
    }

    //* SE CREA LA INSTANCIA SEGÚN LOS ATRIBUTOS ELEGIDOS POR EL PROGRAMADOR */    
    public static void tigreJose(){

        String reset = "\u001B[0m";
        String green = "\u001B[32m"; 
        
        Tigre tigrePropio = new Tigre("feo", "bruto", "cruel", "peligroso", "inestable");
        System.out.println(green + "\n\nVersión de José Luis" + reset);
        System.out.println(green + "====================\n" + reset);
        imprimir(tigrePropio);
        System.out.println("\n\n");
        
    }

    //* SE CREA LA INSTANCIA SEGÚN LOS ATRIBUTOS INGRESADOS POR EL USUARIO */    
    public static void tigreUsuario() {

        String reset = "\u001B[0m";
        String green = "\u001B[32m";        
        
        try (Scanner escanear = new Scanner(System.in)) {

            System.out.println("\nIngrese su nombre: ");
            String nombreUsuario = escanear.nextLine();
        
            System.out.println(green + "\nAHORA TENDRÁ QUE ELEGIR LOS ATRIBUTOS PARA EL TIGRE" + reset);
            System.out.println(green + "----------------------------------------------------" + reset);
            System.out.print("\nIngrese el comportamiento: ");
            String comportamiento = escanear.nextLine();
        
            System.out.print("\nIngrese la peligrosidad: ");
            String peligrosidad = escanear.nextLine();
        
            System.out.print("\nIngrese la vitalidad: ");
            String vitalidad = escanear.nextLine();
        
            System.out.print("\nIngrese el instinto: ");
            String instinto = escanear.nextLine();
            System.out.print("\nIngrese la apariencia: ");
            String apariencia = escanear.nextLine();
        
            Tigre tigreUsuario = new Tigre(comportamiento, peligrosidad, vitalidad, instinto, apariencia);
        
            System.out.println(green + "\n\nVersión de " + nombreUsuario + reset);
            System.out.println("====================\n");
            imprimir(tigreUsuario); 
            System.out.println("\n\n");
        
        }
        
    }

    //* FUNCIÓN QUE IMPRIME EL FRAGMENTO CON LOS ATRIBUTOS ANTERIORMENTE SELECCIONADOS */    
    public static void imprimir(Tigre elTigre) {

        String reset = "\u001B[0m";
        String yellow = "\u001B[33m";
        
        System.out.println(yellow + "Iba y venía, " + 
        elTigre.getComportamiento().toUpperCase() + " y " + elTigre.getPeligrosidad().toUpperCase() + 
        ", cargado de " + elTigre.getVitalidad().toUpperCase() + " energía, del otro lado de los firmes barrotes y todos lo mirábamos.\nEra" + 
        " el tigre de esa mañana, en Palermo, y el tigre del Oriente y el tigre de Blake y de Hugo y Shere Khan," + 
        " y los tigres que fueron\ny que serán y asimismo el tigre arquetipo, ya que el individuo, en su caso, es toda la especie." + 
        " Pensamos que era " + elTigre.getInstinto().toUpperCase() + " y " + elTigre.getApariencia().toUpperCase() + 
        ".\nNorah, una niña, dijo: Está hecho para el amor." + reset);

    }

    //* FUNCIÓN QUE MUESTRA EN PANTALLA UN MENSAJE DE SALIDA PARA EL USUARIO */    
    public static void salida() {

        String reset = "\u001B[0m";
        String green = "\u001B[32m";
        
        System.out.println(green + "--------------------------------------------------------------------------------------" + reset);
        System.out.println(green + "Gracias por utilizar el programa. ADIÓS!!!" + reset);
        System.out.println(green + "--------------------------------------------------------------------------------------\n\n" + reset);
        
    }

}
