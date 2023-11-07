package es.uah.patronesestructurales.Bridge;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Clse que representa una oferta de empleo.
 */
public class OfertaEmp {

    /**
     * Nombre de la empresa que hace la oferta.
     */
    private String empresa;
    /**
     * Puesto que se oferta.
     */
    private String ocupacion;
    /**
     * Salario del puesto.
     */
    private int salario;
    /**
     * Ciudad de desempeño del puesto.
     */
    private String ciudad;
    /**
     * Fecha de alta de la oferta.
     */
    private LocalDate fechaAlta;

    /**
     * Constructor.
     *
     * @param empresa Nombre de la empresa que hace la oferta.
     * @param ocupacion Puesto que se oferta.
     * @param salario Salario del puesto.
     * @param ciudad Ciudad de desempeño del puesto.
     */
    public OfertaEmp(String empresa, String ocupacion, int salario, String ciudad) {
        this.empresa = empresa;
        this.ocupacion = ocupacion;
        this.salario = salario;
        this.ciudad = ciudad;
        fechaAlta = LocalDate.now();
    }

    /**
     * Constructor.
     *
     * @param empresa Nombre de la empresa que hace la oferta.
     * @param ocupacion Puesto que se oferta.
     * @param salario Salario del puesto.
     * @param ciudad Ciudad de desempeño del puesto.
     * @param fechaAlta Fecha de alta de la oferta.
     */
    public OfertaEmp(String empresa, String ocupacion, int salario, String ciudad, LocalDate fechaAlta) {
        this.empresa = empresa;
        this.ocupacion = ocupacion;
        this.salario = salario;
        this.ciudad = ciudad;
        this.fechaAlta = fechaAlta;
    }

    /**
     * Constructor.
     */
    public OfertaEmp() {
    }

    /**
     * Devuelve el nombre de la empresa que hace la oferta.
     *
     * @return Nombre de la empresa que hace la oferta.
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * Establece el nombre de la empresa que hace la oferta.
     *
     * @param empresa Nombre de la empresa que hace la oferta.
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Devuelve el puesto que se oferta.
     *
     * @return Puesto que se oferta.
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * Establece el puesto que se oferta.
     *
     * @param ocupacion Puesto que se oferta.
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    /**
     * Devuelve el salario del puesto.
     *
     * @return Salario del puesto.
     */
    public int getSalario() {
        return salario;
    }

    /**
     * Establece el salario del puesto.
     *
     * @param salario Salario del puesto.
     */
    public void setSalario(int salario) {
        this.salario = salario;
    }

    /**
     * Devuelve la ciudad de desempeño del puesto.
     *
     * @return Ciudad de desempeño del puesto.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad de desempeño del puesto.
     *
     * @param ciudad Ciudad de desempeño del puesto.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Devuelve la fecha de alta de la oferta.
     *
     * @return Fecha de alta de la oferta.
     */
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Establece la fecha de alta de la oferta.
     *
     * @param fechaAlta Fecha de alta de la oferta.
     */
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * Devuelve una cadena con la descripción de la oferta.
     *
     * @return Cadena con la descripción de la oferta.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("dd/MM/yyyy");        
        String fecha = fechaAlta.format(formatoCorto);

        return "OfertaEmp{" + "empresa=" + empresa + ", ocupacion=" + ocupacion + ", salario=" + salario + ", ciudad=" + ciudad + ", fechaAlta=" + fecha + '}';
    }
}
