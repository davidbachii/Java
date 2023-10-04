package es.uah.patronescreacion.FactoryMethod;

/**
 * Creador: clase para crear distintas figuras.
 */
public class FactoriaDeFiguras {

    /**
     * Constantes
     */
    public static final int CUADRADO = 0;
    public static final int CIRCULO = 1;

    /**
     * Crea un objeto de tipo Figura.
     *
     * @param tipo Tipo de la figura que se desea crear.
     * @param lado Lado de la figura en pixels.
     * @return Objeto de tipo Figura.
     */
    public Figura getFigura(int tipo, int lado) {
        if (tipo == CUADRADO) {
            return (new Cuadrado(lado));
        } else {
            return (new Circulo(lado));
        }
    }
}
