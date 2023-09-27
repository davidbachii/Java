package es.uah.banco.PO;

import java.time.LocalDate;
import java.util.ArrayList;

public class FondoInversion implements Rentabilidad {

    private String nombre;
    private LocalDate fechaSuscripcion;
    private LocalDate fechaReembolso;
    private ArrayList<Activo> activos;

    public FondoInversion(String nombre, LocalDate fechaSuscripcion, LocalDate fechaReembolso) {
        this.nombre = nombre;
        this.fechaSuscripcion = fechaSuscripcion;
        this.fechaReembolso = fechaReembolso;
        this.activos = new ArrayList<>();
    }

    @Override
    public double calculaRentabilidad() {
        double rentabilidad = 0;
        for (Activo activo : activos) {
            rentabilidad += activo.calculaRentabilidad();
        }
        return rentabilidad;
    }

    public void addActivo(Activo a) {
        activos.add(a);
    }
}
