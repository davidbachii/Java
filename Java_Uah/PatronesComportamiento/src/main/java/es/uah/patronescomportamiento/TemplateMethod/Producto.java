package es.uah.patronescomportamiento.TemplateMethod;

/**
 * Clase abstracta Producto.
 *
 * @author Salvador Oton
 */
public abstract class Producto {

    private String titulo; // Título del producto.

    /**
     * Método Plantilla. Llama al método concreto de cada clase.
     *
     * @param horas
     * @return cadena
     */
    public final String procesarInformacion(int horas) {
        StringBuilder informacion = new StringBuilder("Información sobre el producto alquilado:\n");

        /*Estos métodos seran implementados por todas las clases hijas de Producto
         *para mostrar la información de cada producto concreto.*/
        informacion.append(getPresentacionProducto());
        informacion.append("\n").append(getPrecio(horas));

        return informacion.toString();
    }

    /**
     * Devuelve el título del producto.
     *
     * @param nomTit Título del producto.
     */
    public final void setNombreTitulo(String nomTit) {
        this.titulo = nomTit;
    }

    /**
     * Establece el título del producto.
     *
     * @return Título del producto.
     */
    public final String getNombreTitulo() {
        return this.titulo;
    }

    /**
     * Método abstracto. Presenta el producto concreto.
     *
     * @return
     */
    public abstract String getPresentacionProducto();

    /**
     * Método abstracto. Devuelve el precio del alquiler del producto según las
     * horas de alquiler.
     *
     * @param horas Horas de alquiler.
     * @return Precio del alquiler del producto.
     */
    public abstract String getPrecio(int horas);
}
