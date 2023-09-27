package es.uah.banco.PO;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cuenta {

    private String num;
    private double saldo;
    private double interes;
    private LocalDate fechaApertura;
    private ArrayList<Cliente> clientes;

    public Cuenta(String num, double saldo, double interes) {
        this.num = num;
        this.saldo = saldo;
        this.interes = interes;
        this.fechaApertura = LocalDate.now();
        this.clientes = new ArrayList<>();
    }

}
