package patrones.universidad;

public class PAS extends Personal {

    private String _seccion;
    private String _cargo;

    public PAS(int identificador, String seccion, String cargo) {
        super(identificador);
        _seccion = seccion;
        _cargo = cargo;
    }

    @Override
    public String generarNomina() {
        IntNomina nomina = new Nomina();
        return "Generada nómina de PAS " + super.getIdentificador() + " # cantidad: " + nomina.calculaNomina("PAS");
    }

    public void modificar(String seccion, String cargo) {
        _seccion = seccion;
        _cargo = cargo;        
    }

    @Override
    public String toString() {
        return "PAS{" + "_identificador=" + super.getIdentificador() + ", _seccion=" + _seccion + ", _cargo=" + _cargo + '}';
    } 
}
