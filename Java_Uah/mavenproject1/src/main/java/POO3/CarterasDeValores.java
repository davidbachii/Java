/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO3;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author david
 */
public class CarterasDeValores {
    
    String nombreCatera;
    ArrayList<ValoresAsociados> valoresAsociados;

    public CarterasDeValores(String nombreCatera) {
        this.nombreCatera = nombreCatera;
        this.valoresAsociados = new ArrayList<>();
    }

    public String getNombreCatera() {
        return nombreCatera;
    }

    public void setNombreCatera(String nombreCatera) {
        this.nombreCatera = nombreCatera;
    }

    public ArrayList<ValoresAsociados> getValoresAsociados() {
        return valoresAsociados;
    }

    public void setValoresAsociados(ArrayList<ValoresAsociados> valoresAsociados) {
        this.valoresAsociados = valoresAsociados;
    }
    
    
     public void addValor(ValoresAsociados v) {
        valoresAsociados.add(v);
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
    
    
    private int calcularDiasTranscurridos(LocalDate fechaCompra) {
        // Convertir la Date a LocalDate
       
       // fechaCompraLocalDate = fechaCompra.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Obtener la fecha actual
      //  LocalDate fechaActual = LocalDate.now();

        // Calcular los días transcurridos
     //   long diasTranscurridos = ChronoUnit.DAYS.between(fechaCompraLocalDate, fechaActual);

     //   return (int) diasTranscurridos;
        return 0;
        // Convertir la Date a LocalDate
       
       // fechaCompraLocalDate = fechaCompra.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Obtener la fecha actual
      //  LocalDate fechaActual = LocalDate.now();

        // Calcular los días transcurridos
     //   long diasTranscurridos = ChronoUnit.DAYS.between(fechaCompraLocalDate, fechaActual);

     //   return (int) diasTranscurridos;
    }
    
    
    
}
