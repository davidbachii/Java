package es.uah.patronesestructurales.Decorator;

/**
 * Clase para manejar los datos del cliente.
 */
public class Cliente {

    /**
     * DNI del cliente.
     */
    private String dni;
    /**
     * Nombre del cliente.
     */
    private String nombre;
    /**
     * Fecha de nacimiento del cliente.
     */
    private Fecha fechaNac;
    /**
     * Dirección del cliente.
     */
    private String direccion;
    /**
     * Teléfono del cliente.
     */
    private String tfno;

    /**
     * Constructor.
     *
     * @param p_dni DNI del cliente.
     * @param p_nombre Nombre del cliente.
     * @param p_fecnac Fecha de nacimiento del cliente.
     * @param p_direccion Dirección del cliente.
     * @param p_tfno Teléfono del cliente.
     */
    public Cliente(String p_dni, String p_nombre, Fecha p_fecnac, String p_direccion, String p_tfno) {
        dni = p_dni;
        nombre = p_nombre;
        fechaNac = p_fecnac;
        direccion = p_direccion;
        tfno = p_tfno;
    }

    /**
     * Devuelve el DNI del cliente.
     *
     * @return DNI del cliente.
     */
    public String getDni() {
        return this.dni;
    }

    /**
     * Establece el DNI del cliente.
     *
     * @param dni DNI del cliente.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el nombre del cliente.
     *
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre Nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la fecha de nacimiento del cliente.
     *
     * @return Fecha de nacimiento del cliente.
     */
    public Fecha getFechaNac() {
        return this.fechaNac;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     *
     * @param fechaNac Fecha de nacimiento del cliente.
     */
    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * Devuelve la drección del cliente.
     *
     * @return Dirección del cliente.
     */
    public String getDireccion() {
        return this.direccion;
    }

    /**
     * Establece la dirección del cliente.
     *
     * @param direccion Dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el teléfono del cliente.
     *
     * @return Teléfono del cliente.
     */
    public String getTfno() {
        return this.tfno;
    }

    /**
     * Establece el teléfono del cliente.
     *
     * @param tfno Teléfono del cliente.
     */
    public void setTfno(String tfno) {
        this.tfno = tfno;
    }

    /**
     * Devuelve una cadena con la descripción del cliente.
     *
     * @return Cadena con la descripción del cliente.
     */
    @Override
    public String toString() {
        return dni + " " + nombre;
    }
}
