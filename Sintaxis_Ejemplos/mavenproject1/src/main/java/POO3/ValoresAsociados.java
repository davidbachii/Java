/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO3;

import java.util.Date;

/**
 *
 * @author david
 */
public class ValoresAsociados {
    
    String nombreValorAsociado;
    int numeroTitulos;
    Date fechaCompra;
    double precioCompra;
    double precioCotizacion;

    public ValoresAsociados(String nombreValorAsociado, int numeroTitulos, Date fechaCompra, double precioCompra, double precioCotizacion) {
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

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
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
    
    
    
}
