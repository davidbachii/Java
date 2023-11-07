package es.uah.patronesestructurales.Flyweight;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Cliente gráfico para la prueba del patrón Flyweight.
 */
public class ClienteFW extends JFrame implements ActionListener {

    /**
     * Constante que define un array de colores.
     */
    private static final Color colores[] = {Color.red, Color.blue,
        Color.yellow, Color.orange,
        Color.black, Color.gray};
    /**
     * Constante que define el número de figuras que se dibujan cada vez.
     */
    private static final int NUMERO_FIGURAS = 100;
    /**
     * Componnetes gráficos
     */
    JLabel etiqueta1 = new JLabel("Introduce tipo figura:");
    JTextField texto1 = new JTextField("0");
    JButton dibujar = new JButton("Dibujar");
    JButton borrar = new JButton("Borrar");
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    FactoriaDeFiguras factoria = new FactoriaDeFiguras();

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String args[]) {
        ClienteFW cliente = new ClienteFW();
    }

    /**
     * Constructor.
     */
    public ClienteFW() {
        super("Cliente FW");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setup();
    }

    /**
     * Establece la configuración gráfica del JFrame.
     */
    private void setup() {
        getContentPane().setLayout(new BorderLayout());
        panel1.setLayout(new GridLayout(3, 2));
        panel1.add(etiqueta1);
        panel1.add(texto1);
        panel1.add(dibujar);
        panel1.add(borrar);
        dibujar.addActionListener(this);
        borrar.addActionListener(this);
        getContentPane().add("North", panel1);
        getContentPane().add("Center", panel2);
        this.setSize(600, 400);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dibujar) {// Si se pulsó el botón Dibujar...
            Graphics g = panel2.getGraphics();
            int t = Integer.parseInt(texto1.getText()); //Captura tipo de figura

            // Dibuja en el panel2 un total de NUMERO_FIGURAS de tipo t, cuyas coordenadas x e y, y su color y lado
            // son generados de manera aleatoria.
            for (int i = 0; i < NUMERO_FIGURAS; ++i) {
                // Como tenemos 6 colores, solo creamos 6 objetos.
                Figura figura = factoria.getFigura(t, getRandomColor());
                figura.dibujar(g, getRandomX(), getRandomY(), getRandomLado());
            }
        }

        if (e.getSource() == borrar) {// Si se pulsó el botón Borrar...
            repaint();// Limpia el JFrame.
        }
    }

    /**
     * Devuelve coordenada x generada de forma aleatoria.
     *
     * @return Coordenada x generada de forma aleatoria.
     */
    private int getRandomX() {
        return (int) (Math.random() * this.getWidth());
    }

    /**
     * Devuelve coordenada y generada de forma aleatoria.
     *
     * @return Coordenada y generada de forma aleatoria.
     */
    private int getRandomY() {
        return (int) (Math.random() * this.getHeight());
    }

    /**
     * Devuelve lado generado de forma aleatoria.
     *
     * @return Lado generado de forma aleatoria.
     */
    private int getRandomLado() {
        return (int) (Math.random() * (this.getHeight() / 10));
    }

    /**
     * Devuelve color generado de forma aleatoria.
     *
     * @return Color generado de forma aleatoria.
     */
    private Color getRandomColor() {
        return colores[(int) (Math.random() * colores.length)];
    }
}
