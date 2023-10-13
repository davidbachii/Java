/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFD_MaquinaEstados;


import java.util.Scanner;

/**
 *
 * @author david
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        AFD primerER = new AFD(true);
        AFD segundaER = new AFD(false);
        MaquinaEstados me = new MaquinaEstados(primerER);
        Scanner scanner = new Scanner(System.in);
        boolean cadenaSeleccionada1 = false;
        boolean cadenaSeleccionada2 = false;
        int opcion;
        do {
            System.out.println("=== Menú del Analizador Léxico ===");
            System.out.println("Opcion 1: Seleccionar Expresión Regular");
            System.out.println("Opcion 2: Analizar una cadena");
            System.out.println("Opcion 3: Mostrar posibles cadenas configurable");
            System.out.println("Opcion 4: Mostrar posibles cadenas hasta un numero maximo");
            System.out.println("Opcion 5: Salir");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del teclado

            switch (opcion) {
                case 1:
                    int num = 0;
                    System.out.println("ER 1 --> b(aa*)c(hi|i*)ller? ");
                    System.out.println("");
                    System.out.println("ER 2 -->d(a+)v(id|i*)d? ");
                    System.out.println("");
                    System.out.println("Elija la expresion regular: ");
                    try {
                        num = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Por favor elija una de las dos ERS mostradas \n");
                    }
                    if (num == 1) {
                        me.setAutomata(primerER);
                        System.out.println("El automata a sido seleccionado y actualizado.");
                        cadenaSeleccionada1 = true;
                        cadenaSeleccionada2 = false;
                    } else if (num == 2) {
                        me.setAutomata(segundaER);
                        System.out.println("El automata a sido seleccionado y actualizado.");
                        cadenaSeleccionada2 = true;
                        cadenaSeleccionada1 = false;
                    } else {
                        System.out.println("Por favor elija una de las dos ERS mostradas.");
                    }

                    break;

                case 2:

                    if (cadenaSeleccionada1 == true || cadenaSeleccionada2 == true) {
                        String cadena = "";
                        System.out.println("Escriba la cadena que quiera analizar:");
                        cadena = scanner.next();
                        if (me.compruebaCadena(cadena) == true) {
                            System.out.println("LA CADENA " + cadena + " ES VALIDA");
                        } else {
                            System.out.println("LA CADENA " + cadena + " NO ES VALIDA");
                        }
                        break;

                    } else {
                        System.out.println("Todavia no se ha seleccionado ninguna cadena.");
                        break;
                    }

                case 3:

                    if (cadenaSeleccionada1 == true) {

                        System.out.println("Ingrese la cantidad de 'b':");
                        int bCount = scanner.nextInt();

                        System.out.println("Ingrese la cantidad de 'a':");
                        int aCount = scanner.nextInt();

                        System.out.println("Ingrese la cantidad de 'c':");
                        int cCount = scanner.nextInt();

                        System.out.println("Ingrese la cantidad de 'h':");
                        int hCount = scanner.nextInt();

                        System.out.println("Ingrese la cantidad de 'i':");
                        int iCount = scanner.nextInt();

                        System.out.println("¿Desea incluir 'ller?' (1 para Sí, 0 para No):");
                        int llerOption = scanner.nextInt();

                        primerER.generarCadenas(bCount, aCount, cCount, hCount, iCount, llerOption, me);

                        break;
                    } else if (cadenaSeleccionada2 == true) {
                        System.out.println("Ingrese la cantidad de 'd':");
                        int dCount = scanner.nextInt();

                        System.out.println("Ingrese la cantidad de 'a':");
                        int aCount = scanner.nextInt();

                        System.out.println("Ingrese la cantidad de 'v':");
                        int vCount = scanner.nextInt();

                        System.out.println("Ingrese la cantidad de 'i':");
                        int iCount = scanner.nextInt();

                        segundaER.generarCadenas2(dCount, aCount, vCount, iCount, me);

                        break;

                    } else {
                        System.out.println("Todavid no se ha seleccionado ninguna cadena.");
                        break;

                    }

                case 4:
                    if (cadenaSeleccionada1 == true) {
                        System.out.println("Ingrese el número máximo de cadenas (máx. 100):");
                        int maxCadenas = scanner.nextInt();

                        System.out.println("Ingrese la longitud máxima (máx. 10 caracteres):");
                        int maxLongitud = scanner.nextInt();

                        if (maxCadenas > 100 || maxLongitud > 10) {
                            System.out.println("Valores fuera de rango. Intente de nuevo.");
                            break;
                        }

                        primerER.generarTodasPosiblesCadenasPrimerER(maxCadenas, maxLongitud, me);
                    } else if (cadenaSeleccionada2 == true) {
                        System.out.println("Ingrese el número máximo de cadenas (máx. 100):");
                        int maxCadenas = scanner.nextInt();

                        System.out.println("Ingrese la longitud máxima (máx. 10 caracteres):");
                        int maxLongitud = scanner.nextInt();

                        if (maxCadenas > 100 || maxLongitud > 10) {
                            System.out.println("Valores fuera de rango. Intente de nuevo.");
                            break;
                        }
                        segundaER.generarTodasPosiblesCadenasSegundaER(maxCadenas, maxLongitud, me);
                    } else {
                        System.out.println("Todavid no se ha seleccionado ninguna cadena.");
                    }
                    break;

                case 5:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
            }

        } while (opcion != 5);
    }

}
