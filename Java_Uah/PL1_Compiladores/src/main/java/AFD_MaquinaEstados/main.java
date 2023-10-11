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
        AFD primerER = new AFD();
        MaquinaEstados me = new MaquinaEstados(primerER);
        Scanner scanner = new Scanner(System.in);
        boolean cadenaSeleccionada = false;
        int opcion;
        do {
            System.out.println("=== Menú del Analizador Léxico ===");
            System.out.println("Opcion 1: Seleccionar Expresión Regular");
            System.out.println("Opcion 2: Analizar una cadena");
            System.out.println("Opcion 3: Mostrar posibles cadenas");
            System.out.println("Opcion 4: Salir");
            

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del teclado

            switch (opcion) {
                case 1:
                    int num = 0;
                    System.out.println("ER 1 --> b(aa*)c(hi|i*)ller? ");
                    System.out.println("");
                    System.out.println("ER 2 -->(!+d)i(va+a)*");
                    System.out.println("");
                    System.out.println("Elija la expresion regular: ");
                    try{
                        num = scanner.nextInt();
                    }catch(Exception e){
                        System.out.println("Por favor elija una de las dos ERS mostradas \n");
                    }
                    if(num==1){
                        me.setAutomata(primerER);
                        System.out.println("El automata a sido seleccionado y actualizado.");
                        cadenaSeleccionada = true;
                    }else if(num==2){
                        me.setAutomata(primerER);
                        System.out.println("El automata a sido seleccionado y actualizado.");
                        cadenaSeleccionada = true;
                    }else{
                        System.out.println("Por favor elija una de las dos ERS mostradas.");
                    }
                    
                    break;

                case 2:
                    
                    if(cadenaSeleccionada == true){
                        String cadena="";
                        System.out.println("Escriba la cadena que quiera analizar:");
                        cadena = scanner.next();
                            if(me.compruebaCadena(cadena)==true){
                                System.out.println("LA CADENA "+cadena+ " ES VALIDA");
                            }else{
                                System.out.println("LA CADENA "+ cadena+ " NO ES VALIDA");
                            }
                            break;
                        
                    }else{
                        System.out.println("Todavid no se ha seleccionado ninguna cadena.");
                        break;
                    }
                        
                    

                case 3:
                    
                    
                    break;

                case 4:
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
            }

        } while (opcion != 4);
    }
    
}
