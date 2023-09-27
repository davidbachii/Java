/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO3;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author david
 */
public class ValoresAsociados {
    
    String nombreValorAsociado;
    int numeroTitulos;
    LocalDate fechaCompra;
    double precioCompra;
    double precioCotizacion;

    public ValoresAsociados(String nombreValorAsociado, int numeroTitulos, LocalDate fechaCompra, double precioCompra, double precioCotizacion) {
        this.nombreValorAsociado = nombreValorAsociado;
        this.numeroTitulos = numeroTitulos;
        this.fechaCompra = fechaCompra;
        this.precioCompra = precioCompra;
        this.precioCotizacion = precioCotizacion;
    }

    public String getNombreValorAsociado() {
        return nombreValorAsociado;
    }

    public void setNombreValorAsociado(String nombreValorAsociado) {
        this.nombreValorAsociado = nombreValorAsociado;
    }

    public int getNumeroTitulos() {
        return numeroTitulos;
    }

    public void setNumeroTitulos(int numeroTitulos) {
        this.numeroTitulos = numeroTitulos;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioCotizacion() {
        return precioCotizacion;
    }

    public void setPrecioCotizacion(double precioCotizacion) {
        this.precioCotizacion = precioCotizacion;
    }

    void add(ValoresAsociados v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
