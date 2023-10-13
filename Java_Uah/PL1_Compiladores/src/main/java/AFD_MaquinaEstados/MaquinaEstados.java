/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFD_MaquinaEstados;

/**
 *
 * @author david
 */
public class MaquinaEstados {

    private int estadoActual;
    private AFD automata;

    public MaquinaEstados(AFD automata) {

        this.automata = automata;
        inicializar();
    }

    public void inicializar() {
        estadoActual = automata.getEstadoInicial();
    }

    public void acepta(Character c) {
        int estTemporal = -1; //Creamos un estado temporal con un valor que no concida con los valores que hemos creado
        try {
            estTemporal = automata.getSigienteEstado(estadoActual, c);
        } catch (NullPointerException npe) {
            npe.toString();
        }
        estadoActual = estTemporal;

    }

    public boolean isFinal() {
        return automata.isFinal(estadoActual);
    }

    public boolean compruebaCadena(String cadena) {
        inicializar();  // Inicializa el estado actual al estado inicial del autómata.
        boolean esValida = true;  // Inicializa esValida como verdadero (asumimos que la cadena es válida hasta que se demuestre lo contrario).

        // Comprueba si la cadena es vacía.
        if (cadena.length() == 0) {
            esValida = false;  // Si la cadena es vacía, no puede ser válida.
        } else {
            for (int i = 0; i < cadena.length(); i++) {
                acepta(cadena.charAt(i));  // Procesa el siguiente carácter de la cadena.

                // Verifica si estamos en un estado inválido o si no estamos en un estado final al final de la cadena.
                if (estadoActual == -1 || (this.isFinal() == false && i == cadena.length() - 1)) {
                    esValida = false;  // La cadena no es válida en esta situación.
                }
            }
        }

        return esValida;  // Devuelve true si la cadena es válida, de lo contrario, false.
    }

    public AFD getAutomata() {
        return automata;
    }

    public void setAutomata(AFD automata) {
        this.automata = automata;
    }
}
