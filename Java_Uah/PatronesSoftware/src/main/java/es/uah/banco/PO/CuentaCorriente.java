package es.uah.banco.PO;

import java.util.ArrayList;

public class CuentaCorriente extends Cuenta {

    private ArrayList<CarteraValores> carteras;
    private ArrayList<FondoInversion> fondos;

    public CuentaCorriente(double interes, String num, double saldo) {
        super(num, saldo, interes);
        this.carteras = new ArrayList<>();
        this.fondos = new ArrayList<>();
    }

}
