package es.uah.patronesestructurales.Adapter;

//
import java.util.StringTokenizer;

/**
 * Clase para adaptar fechas en formato de USA (MM,DD,AAAA) a fechas en formato
 * de España (DD/MM/AAAA)
 */
public class AdaptadorFecha implements Fecha {

    /**
     * Fecha en formato USA que se va a adaptar.
     */
    private FechaUS fus;

    /**
     * Constructor
     *
     * @param fus Fecha en formato USA.
     */
    public AdaptadorFecha(FechaUS fus) {
        this.fus = fus;
    }

    @Override
    public String toString() {
        StringTokenizer st = new StringTokenizer(fus.toString(), ",");
        String mm = st.nextToken();
        String dd = st.nextToken();
        String aaaa = st.nextToken();

        return dd + "/" + mm + "/" + aaaa;
    }

    @Override
    public int getAño() {
        //Aqui adaptamos la fecha que ya tenemos de fechaUs no tenemos que crear fehca nueva en otra clase
        //Basicamente es un intermedio entre dos clases(practicamente iguales con mimos metodos) usando la interfaz para usar
        //los metodos de una clase adaptandolo en otras. De esta forma el cliente solo tiene que conocer la clase Fecha y ya si quiero
        //el la fecha en americono desde fecha inovoco esta clase y le paso un to String
        
        //Resumen:: SImplemente adapta valores similares con mismos metodos como dos fechas que solo tienen tres valores y un to string y
        //meto una interfaz.  Podemos usarlo en el codigo de java flix con las fehcas de lanzamiento en las peliculas y series para que se sepa
        //en formato americano y español
        return this.fus.getYear();
    }

    @Override
    public void setAño(int año) {
        this.fus.setYear(año);
    }

    @Override
    public int getDia() {
        return this.fus.getDay();
    }

    @Override
    public void setDia(int dia) {
        this.fus.setDay(dia);
    }

    @Override
    public int getMes() {
        return this.fus.getMonth();
    }

    @Override
    public void setMes(int mes) {
        this.fus.setMonth(mes);
    }
}
