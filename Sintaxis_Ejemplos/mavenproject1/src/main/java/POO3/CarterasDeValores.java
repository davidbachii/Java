/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO3;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

/**
 *
 * @author david
 */
public class CarterasDeValores {
    
    String nombreCatera;
    List<ValoresAsociados> valoresAsociados;

    public CarterasDeValores(String nombreCatera, List<ValoresAsociados> valoresAsociados) {
        this.nombreCatera = nombreCatera;
        this.valoresAsociados = valoresAsociados;
    }

    public String getNombreCatera() {
        return nombreCatera;
    }

    public void setNombreCatera(String nombreCatera) {
        this.nombreCatera = nombreCatera;
    }

    public List<ValoresAsociados> getValoresAsociados() {
        return valoresAsociados;
    }

    public void setValoresAsociados(List<ValoresAsociados> valoresAsociados) {
        this.valoresAsociados = valoresAsociados;
    }

    public double calcularRentabilidadAnual(){
         double rentabilidadAcumulada = 0.0;
         
         for (ValoresAsociados valor : valoresAsociados) {
            double precioCompra = valor.getPrecioCompra();
            double precioCotizacion = valor.getPrecioCotizacion();
            int diasTranscurridos = calcularDiasTranscurridos(valor.getFechaCompra());
            int numTitulos = valor.getNumeroTitulos();

            rentabilidadAcumulada += ((precioCotizacion - precioCompra) / precioCompra) * (365 / diasTranscurridos) * numTitulos;
        }

        return rentabilidadAcumulada;
         
    }
    
    
    private int calcularDiasTranscurridos(Date fechaCompra) {
        // Convertir la Date a LocalDate
        LocalDate fechaCompraLocalDate = fechaCompra.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Calcular los días transcurridos
        long diasTranscurridos = ChronoUnit.DAYS.between(fechaCompraLocalDate, fechaActual);

        return (int) diasTranscurridos;
    }
    
    
    
}
