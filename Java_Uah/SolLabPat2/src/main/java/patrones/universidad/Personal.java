package patrones.universidad;

public abstract class Personal {

    private int _identificador;

    public Personal(int _identificador) {
        this._identificador = _identificador;
    }

    public int getIdentificador() {
        return _identificador;
    }

    public abstract String generarNomina();
}
