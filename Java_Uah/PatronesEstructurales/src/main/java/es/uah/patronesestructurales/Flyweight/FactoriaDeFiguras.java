package es.uah.patronesestructurales.Flyweight;

import java.awt.Color;
import java.util.HashMap;

/**
 * Fábrica de pesos ligeros.
 */
public class FactoriaDeFiguras {

    /**
     * Constantes
     */
    public static final int CUADRADO = 0;
    public static final int CIRCULO = 1;

    /**
     * Tabla hash para almacenar círculos por color.
     */
    private static final HashMap circulosPorColor = new HashMap();
    /**
     * Tabla hash para almacenar cuadrados por color.
     */
    private static final HashMap cuadradosPorColor = new HashMap();
    /**
     * Referencia a Figura.
     */
    Figura fig;

    /**
     * Devuelve un peso ligero concreto. Si el peso ligero no existe, se crea y
     * se añade a la tabla hash correspondiente. Si el peso ligero existe, se
     * devuelve.
     *
     * @param tipo Tipo de figura.
     * @param color Color de la figura.
     * @return Peso ligero concreto.
     */
    public Figura getFigura(int tipo, Color color) {
        if (tipo == CUADRADO) {
            fig = (Cuadrado) cuadradosPorColor.get(color);
            if (fig == null) {
                fig = new Cuadrado(color);
                cuadradosPorColor.put(color, fig);
                System.out.println("Creamos un cuadrado de color: " + color);
            }
            return fig;
        } else {
            fig = (Circulo) circulosPorColor.get(color);
            if (fig == null) {
                fig = new Circulo(color);
                circulosPorColor.put(color, fig);
                System.out.println("Creamos un circulo de color: " + color);
            }
            return fig;
        }
    }
}
