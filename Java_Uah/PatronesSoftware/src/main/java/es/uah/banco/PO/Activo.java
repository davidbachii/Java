package es.uah.banco.PO;

public class Activo implements Rentabilidad {

    private String nombre;
    private double vinicial;
    private double vfinal;
    private FondoInversion fondo;

    public Activo(String nombre, double vinicial, double vfinal, FondoInversion fondo) {
        this.nombre = nombre;
        this.vinicial = vinicial;
        this.vfinal = vfinal;
        this.fondo = fondo;
        this.fondo.addActivo(this);
    }

    @Override
    public double calculaRentabilidad() {
        return ((vfinal - vinicial) / vinicial) * 100;
    }

}
