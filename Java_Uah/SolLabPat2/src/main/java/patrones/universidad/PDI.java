package patrones.universidad;

public class PDI extends Personal {

    private String _departamento;
    private String _area;

    public PDI(int identificador, String departamento, String area) {
        super(identificador);
        _departamento = departamento;
        _area = area;
    }

    @Override
    public String generarNomina() {
        IntNomina nomina = new Nomina();
        return "Generada nómina de PDI " + super.getIdentificador() + " # cantidad: " + nomina.calculaNomina("PDI");
    }

    public void modificar(String departamento, String area) {
        _departamento = departamento;
        _area = area;
    }

    @Override
    public String toString() {
        return "PDI{" + "_identificador=" + super.getIdentificador() + ", _departamento=" + _departamento + ", _area=" + _area + '}';
    }

}
