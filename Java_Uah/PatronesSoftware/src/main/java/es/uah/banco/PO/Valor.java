package es.uah.banco.PO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Valor implements Rentabilidad {

    private String nombre;
    private double compra;
    private double cotizacion;
    private int titulos;
    private LocalDate fechaCompra;
    private CarteraValores cartera;

    public Valor(String nombre, double compra, double cotizacion, int titulos, CarteraValores cartera) {
        this.compra = compra;
        this.cotizacion = cotizacion;
        this.nombre = nombre;
        this.titulos = titulos;
        this.cartera = cartera;
        this.fechaCompra = LocalDate.now();
        this.cartera.addValor(this);
    }

    public Valor(String nombre, double compra, double cotizacion, int titulos, LocalDate fechaCompra, CarteraValores cartera) {
        this.nombre = nombre;
        this.compra = compra;
        this.cotizacion = cotizacion;
        this.titulos = titulos;
        this.fechaCompra = fechaCompra;
        this.cartera = cartera;
        this.cartera.addValor(this);
    }

    @Override
    public double calculaRentabilidad() {
        long dias = numDias();        
        return ((cotizacion - compra) / compra) * (365 / dias) * titulos;
    }

    private long numDias() {
        LocalDate hoy = LocalDate.now();
        long dias = ChronoUnit.DAYS.between(fechaCompra, hoy);
        return dias;
    }

}
