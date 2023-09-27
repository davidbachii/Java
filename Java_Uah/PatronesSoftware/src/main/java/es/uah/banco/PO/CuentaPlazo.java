package es.uah.banco.PO;

class CuentaPlazo extends Cuenta {

    private int meses;

    public CuentaPlazo(int meses, double interes, String num, double saldo) {
        super(num, saldo, interes);
        this.meses = meses;
    }

}
