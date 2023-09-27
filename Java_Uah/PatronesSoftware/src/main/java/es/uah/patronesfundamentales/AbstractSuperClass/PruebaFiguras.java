package es.uah.patronesfundamentales.AbstractSuperClass;

/**
 * Clase de prueba que crea figuras geométricas de tipo Circulo y Cuadrado y las
 * dibuja y calcula su área.
 */
public class PruebaFiguras {

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        Punto p1 = new Punto(15, 20);
        Punto p2 = new Punto(50, 80);
        Punto p3 = new Punto(100, 150);

        FiguraGeometrica fig1 = new Circulo(p1, "rojo", 5);
        FiguraGeometrica fig2 = new Cuadrado(p2, "verde", 10);

        fig1.dibujar(); //polimorfismo
        fig2.dibujar();
        System.out.println("Área fig1: " + fig1.area());
        System.out.println("Área fig2: " + fig2.area());
        fig2.mover(p3);
    }

}
