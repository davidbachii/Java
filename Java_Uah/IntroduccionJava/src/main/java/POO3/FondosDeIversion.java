/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POO3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author david
 */
public class FondosDeIversion {
    String nombreFondo;
    LocalDate fechaSuscripcion;
    LocalDate fechaReembolso;
    ArrayList<Activos> activos;

    public FondosDeIversion(String nombreFondo, LocalDate fechaSuscripcion, LocalDate fechaReembolso, List<Activos> activos) {
        this.nombreFondo = nombreFondo;
        this.fechaSuscripcion = fechaSuscripcion;
        this.fechaReembolso = fechaReembolso;
        this.activos = new ArrayList<>();
    }

    public String getNombreFondo() {
        return nombreFondo;
    }

    public void setNombreFondo(String nombreFondo) {
        this.nombreFondo = nombreFondo;
    }

    public LocalDate getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(LocalDate fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public LocalDate getFechaReembolso() {
        return fechaReembolso;
    }

    public void setFechaReembolso(LocalDate fechaReembolso) {
        this.fechaReembolso = fechaReembolso;
    }

    public ArrayList<Activos> getActivos() {
        return activos;
    }

    public void setActivos(ArrayList<Activos> activos) {
        this.activos = activos;
    }

    
    
    
    
    public double rentabilidadAcumulado(){
        
       double rentabilidadAcumulada = 0.0;
       
        for (Activos activo : activos) {
            double valorInicial = activo.getValorInicial();
            double valorFinal = activo.getValorFinal();
            rentabilidadAcumulada += ((valorFinal - valorInicial) / valorInicial) * 100;
        }

        return rentabilidadAcumulada;
        
    }
    
    
}
