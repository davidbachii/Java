package es.uah.patronescreacion.FactoryMethod;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Clase gráfica de tipo JFrame para dibujar los distintos tipos de figuras que
 * se crearán con la clase FactoriaDeFiguras.
 */
public class PruebaFactoria extends JFrame implements ActionListener {

    // Controles gráficos.
    private JLabel etiqueta1 = new JLabel("Introduce tipo figura:");
    private JTextField texto1 = new JTextField("0");
    private JLabel etiqueta2 = new JLabel("Introduce lado figura:");
    private JTextField texto2 = new JTextField("50");
    private JButton dibujar = new JButton("Dibujar");
    private JButton borrar = new JButton("Borrar");
    private JPanel panel1 = new JPanel(); // Panel para datos de entrada y acciones a realizar.
    private JPanel panel2 = new JPanel(); // Panel para dibujar las figuras.
    private FactoriaDeFiguras factoria = new FactoriaDeFiguras(); // Creador.

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String args[]) {
        // Instancia la clase gráfica PruebaFactoria.
        PruebaFactoria pf = new PruebaFactoria();
    }

    /**
     * Constructor
     */
    public PruebaFactoria() {
        super("Prueba Factoria");// Establece el título del JFrame.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Establece el método para cerrar el JFrame.
        this.setup(); // Configura los controles gráficos.
    }

    /**
     * Configura los controles gráficos.
     */
    private void setup() {
        getContentPane().setLayout(new BorderLayout()); // Establece el layout del JFrame.
        panel1.setLayout(new GridLayout(3, 2)); // Establece el layout del panel1: grid de 3x2.
        // Se añaden controles al panel1.
        panel1.add(etiqueta1);
        panel1.add(texto1);
        panel1.add(etiqueta2);
        panel1.add(texto2);
        panel1.add(dibujar);
        panel1.add(borrar);
        // Se añaden escuchadores a los botones.
        dibujar.addActionListener(this);
        borrar.addActionListener(this);
        // Se añaden los paneles panel1 y panel2 al JFrame.
        getContentPane().add("North", panel1);
        getContentPane().add("Center", panel2);
        this.setSize(450, 400); // Establece el tamaño del JFrame.
        this.setVisible(true); // Hace visible el JFrame.
    }

    /**
     * Establece las funciones a realizar en función de los eventos capturados.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Si se pulsó el botón dibujar...
        if (e.getSource() == dibujar) {
            Graphics g = panel2.getGraphics(); // Obtiene el contexto gráfico que permitirá dibujar en el componente en el control panel2.
            int t = Integer.parseInt(texto1.getText()); //Captura el tipo de figura.
            int l = Integer.parseInt(texto2.getText()); //Captura el lado de la figura.
            Figura figura = factoria.getFigura(t, l); // Crea la figura.
            figura.dibujar(g, 175, 20); // Dibuja la figura.
        }
        // Si se pulsó el botón borrar...
        if (e.getSource() == borrar) {
            repaint();
        }
    }
}
