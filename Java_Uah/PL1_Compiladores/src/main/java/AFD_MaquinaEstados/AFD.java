/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFD_MaquinaEstados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author david
 */
public class AFD {

    //Declaracion de atributos
    private ArrayList<Character> alfabeto;
    private ArrayList<Integer> estados;
    private int estadoInicial;
    private ArrayList<Integer> estadosFinales;
    private HashMap<Integer, HashMap<Character, Integer>> matriz;
    boolean elecionER;

    public AFD(boolean ellecionER) {
        this.elecionER = ellecionER;
        this.alfabeto = new ArrayList<>();
        this.estados = new ArrayList<>();
        this.estadosFinales = new ArrayList<>();
        this.matriz = new HashMap<>();
        arrancarAutomata();

    }

    public void cargarAlfabeto() {
        List<Character> letrasDadas = List.of('b', 'a', 'c', 'h', 'i', 'l', 'e', 'r');
        List<Character> letrasDadas2 = List.of('d', 'a', 'v', 'i');
        if (elecionER) {
            for (Character letra : letrasDadas) {
                alfabeto.add(letra);
            }

        } else {
            for (Character letra2 : letrasDadas2) {
                alfabeto.add(letra2);
            }

        }

    }

    public void cargarEstados() {
        if (elecionER) {
            for (int i = 0; i < 11; i++) {
                estados.add(i);
            }

        } else {
            for (int i = 0; i < 8; i++) {
                estados.add(i);
            }

        }

    }

    public void establecerEstadoInicial() {
        if (elecionER) {
            estadoInicial = 3;
        } else {
            estadoInicial = 0;
        }

    }

    public void establecerEstadosFinales() {
        List<Integer> estadosF = List.of(7, 8, 9, 10);
        List<Integer> estadosF2 = List.of(3, 4, 5, 6, 7);
        if (elecionER) {
            for (Integer estado : estadosF) {
                estadosFinales.add(estado);
            }
        } else {
            for (Integer estado2 : estadosF2) {
                estadosFinales.add(estado2);
            }

        }

    }

    public void iniMatriz() {

        for (int x : estados) {
            matriz.put(x, new HashMap<Character, Integer>());
        }
    }

    public void cargarMatriz() {

        if (elecionER) {

            matriz.get(0).put('i', 8); //Para cuando este en el estado 0 si viene una I, salta al estado 8
            matriz.get(1).put('l', 2); //Para cuando este en el estado 1 si viene una L, salta al estado 2
            matriz.get(2).put('e', 6); //Para cuando este en el estado 2 si viene una E, salta al estado 6
            matriz.get(3).put('b', 4); //Para cuando este en el estado 3 si viene una B, salta al estado 4
            matriz.get(4).put('a', 5); //Para cuando este en el estado 4 si viene una A, salta al estado 5
            matriz.get(5).put('a', 5); //Para cuando este en el estado 5 si viene una B, salta al estado 5
            matriz.get(5).put('c', 10); //Para cuando este en el estado 5 si viene una C, salta al estado 10
            matriz.get(6).put('r', 7); //Para cuando este en el estado 6 si viene una R, salta al estado 7
            matriz.get(8).put('l', 1);  //Para cuando este en el estado 8 si viene una L, salta al estado 1
            matriz.get(9).put('l', 1); //Para cuando este en el estado 9 si viene una B, salta al estado 1
            matriz.get(9).put('i', 9); //Para cuando este en el estado 9 si viene una I, salta al estado 9
            matriz.get(10).put('h', 0); //Para cuando este en el estado 10 si viene una H, salta al estado 0
            matriz.get(10).put('i', 9); //Para cuando este en el estado 10 si viene una I, salta al estado 9
            matriz.get(10).put('l', 1); //Para cuando este en el estado 10 si viene una L, salta al estado 1

        } else {

            matriz.get(0).put('d', 1); //Para cuando este en el estado 0 si viene una D, salta al estado 1
            matriz.get(1).put('a', 2); //Para cuando este en el estado 1 si viene una A, salta al estado 2
            matriz.get(2).put('a', 2); //Para cuando este en el estado 2 si viene una A, salta al estado 2
            matriz.get(2).put('v', 6); //Para cuando este en el estado 3 si viene una V, salta al estado 6
            matriz.get(6).put('d', 3); //Para cuando este en el estado 6 si viene una D, salta al estado 3
            matriz.get(6).put('i', 7); //Para cuando este en el estado 6 si viene una I, salta al estado 7
            matriz.get(7).put('d', 4);  //Para cuando este en el estado 8 si viene una D, salta al estado 4
            matriz.get(7).put('i', 5);  //Para cuando este en el estado 8 si viene una D, salta al estado 4
            matriz.get(4).put('d', 3); //Para cuando este en el estado 4 si viene una D, salta al estado 3
            matriz.get(5).put('i', 5); //Para cuando este en el estado 5 si viene una I, salta al estado 5
            matriz.get(5).put('d', 3); //Para cuando este en el estado 5 si viene una D, salta al estado 3

        }

    }

    public Integer getSigienteEstado(Integer estado, Character siguiente) {
        return matriz.get(estado).get(siguiente);
    }

    public boolean isFinal(Integer estado) {
        return estadosFinales.contains(estado);
    }

    public int getEstadoInicial() {
        return estadoInicial;
    }

    private void arrancarAutomata() {
        cargarAlfabeto();
        cargarEstados();
        establecerEstadoInicial();
        establecerEstadosFinales();
        iniMatriz();
        cargarMatriz();
    }

    public void generarCadenas(int bCount, int aCount, int cCount, int hCount, int iCount, int ller, MaquinaEstados me) {

        // Generar cadenas válidas según las cantidades proporcionadas
        for (int i = 0; i <= bCount; i++) {
            for (int j = 0; j <= aCount; j++) {
                for (int k = 0; k <= cCount; k++) {
                    for (int l = 0; l <= hCount; l++) {
                        for (int m = 0; m <= iCount; m++) {
                            for (int n = 0; n <= ller; n++) { // 0 representa la ausencia de "ller?", 1 representa su presencia
                                String cadena = generarCadena(i, j, k, l, m, n);
                                if (me.compruebaCadena(cadena)) {
                                    System.out.println("Cadena válida: " + cadena);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void generarCadenas2(int dCount, int aCount, int vCount, int iCount, MaquinaEstados me) {
        // Generar cadenas válidas según la expresión regular

        String cadena = generarCadena2(dCount, aCount, vCount, iCount);
        if (me.compruebaCadena(cadena)) {
            System.out.println("Cadena válida: " + cadena);
        }

    }

    public String generarCadena(int bCount, int aCount, int cCount, int hCount, int iCount, int ller) {
        StringBuilder cadena = new StringBuilder();

        // Agregar 'b' y 'a'
        for (int i = 0; i < bCount; i++) {
            cadena.append("b");
        }
        for (int i = 0; i < aCount; i++) {
            cadena.append("a");
        }

        // Agregar 'c', 'h' o 'i'
        for (int i = 0; i < cCount; i++) {
            cadena.append("c");
        }
        for (int i = 0; i < hCount; i++) {
            cadena.append("h");
        }
        for (int i = 0; i < iCount; i++) {
            cadena.append("i");
        }

        // Agregar 'l', 'l', 'e', 'r' y '?'
        if (ller == 1) {
            cadena.append("ller");
        }

        return cadena.toString();
    }

    public String generarCadena2(int dCount, int aCount, int vCount, int iCount) {
        StringBuilder cadena = new StringBuilder();

        // Agregar 'd' y 'a+'
        cadena.append("d");
        for (int i = 0; i < aCount; i++) {
            cadena.append("a");
        }

        // Agregar 'v', 'i' o 'i*'
        for (int i = 0; i < vCount; i++) {
            cadena.append("v");
        }

        for (int i = 0; i < iCount; i++) {
            cadena.append("i");
        }

        // Agregar 'd?'
        if (dCount > 1) {
            cadena.append("d");
        }

        return cadena.toString();
    }

    public void generarTodasPosiblesCadenasPrimerER(int maxCadenas, int maxLongitud, MaquinaEstados automata) {
        int contador = 0;

        for (int length = 1; length <= maxLongitud && contador < maxCadenas; length++) {
            for (int i = 0; i <= length && contador < maxCadenas; i++) {
                for (int j = 0; j <= length - i && contador < maxCadenas; j++) {
                    for (int k = 0; k <= length - i - j && contador < maxCadenas; k++) {
                        for (int l = 0; l <= length - i - j - k && contador < maxCadenas; l++) {
                            if (i + j + k + l <= length) {
                                String cadenaSinLler = generarCadena(i, j, k, l, length - i - j - k - l, 0);

                                if (automata.compruebaCadena(cadenaSinLler)) {
                                    System.out.println(cadenaSinLler);

                                    contador++;
                                }

                                if (l > 0 && contador < maxCadenas) {
                                    String cadenaConLler = generarCadena(i, j, k, l - 1, length - i - j - k - l + 1, 1);

                                    if (automata.compruebaCadena(cadenaConLler)) {
                                        System.out.println(cadenaConLler);

                                        contador++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void generarTodasPosiblesCadenasSegundaER(int maxCadenas, int maxLongitud, MaquinaEstados automata) {
        int contador = 0;

        for (int length = 1; length <= maxLongitud; length++) {
            for (int i = 0; i <= length; i++) {
                for (int j = 0; j <= length - i; j++) {
                    for (int k = 0; k <= length - i - j; k++) {
                        if (contador < maxCadenas) {
                            String cadena = generarCadena2(i, j, k, length - i - j - k);

                            if (automata.compruebaCadena(cadena)) {

                                System.out.println(cadena);
                                contador++;

                            }
                        }
                    }
                }
            }
        }
    }

}
