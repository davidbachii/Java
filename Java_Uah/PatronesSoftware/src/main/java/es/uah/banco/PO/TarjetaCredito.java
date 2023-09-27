package es.uah.banco.PO;

import java.time.LocalDate;

public class TarjetaCredito {

    private LocalDate fechaCaducidad;
    private long num;
    private String tipo;
    private String titular;
    private CuentaCorriente cuenta;

    public TarjetaCredito(LocalDate fechaCaducidad, long num, String tipo, String titular, CuentaCorriente cuenta) {
        this.fechaCaducidad = fechaCaducidad;
        this.num = num;
        this.tipo = tipo;
        this.titular = titular;
        this.cuenta = cuenta;
    }

}
