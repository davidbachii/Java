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
public class TarjetaCredito {
    String tipo;
    String mumero;
    String titular;
    Date fechaCaducidad;

    public TarjetaCredito(String tipo, String mumero, String titular, Date fechaCaducidad) {
        this.tipo = tipo;
        this.mumero = mumero;
        this.titular = titular;
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMumero() {
        return mumero;
    }

    public void setMumero(String mumero) {
        this.mumero = mumero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

   

   

   
    
    
    
}
