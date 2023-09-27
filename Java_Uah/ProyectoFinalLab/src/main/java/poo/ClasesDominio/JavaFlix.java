/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.ClasesDominio;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import poo.Interfaces.PanelInicioSesion;

/**
 *
 * @author RiCh_LiKe
 */
public class JavaFlix {

    private static ArrayList <Pelicula> peliculas = new ArrayList<>();      // Declaramos el array donde se van a guardar los objetos tipo pelicula
    private static ArrayList <Serie> series = new ArrayList<>();            // Declaramos el array donde se van a guardar los objetos tipo serie
    private static ArrayList <Cliente> clientes = new ArrayList<>();        // Declaramos el array donde se van a guardar los objetos tipo cliente

    public static void main(String[] args) {
        
        PanelInicioSesion pis = new PanelInicioSesion();                    // Creamos el panel de inicio de sesión
        pis.setVisible(true);                                               // Lo ponemos visible
        
        verificarFicheros();        // Verifica que los ficheros necesarios esten creados y si no lo estan los crea para evitar errores de IO.
        
        
        peliculas = GuardarLeerFicheros.obtenerArrayPeliculas();            // Guardamos en el array declarado en esta clase el array declarado en la clase donde se encuentran las funciones que operan con los datos de los ficheros
        series = GuardarLeerFicheros.obtenerArraySeries();                  // Guardamos en el array declarado en esta clase el array declarado en la clase donde se encuentran las funciones que operan con los datos de los ficheros
        clientes = GuardarLeerFicheros.obtenerArrayClientes();
        
        // Creamos las peliculas de prueba
        
            // Crear las imagenes necesarias para crear las peliculas y series

        ImageIcon icon1 = new ImageIcon("imagenes/aladdin.jpg");
        ImageIcon icon2 = new ImageIcon("imagenes/avatar.jpg");
        ImageIcon icon3 = new ImageIcon("imagenes/nemo.jpg");
        ImageIcon icon4 = new ImageIcon("imagenes/faf.jpg");
        ImageIcon icon5 = new ImageIcon("imagenes/joker.jpg");
        ImageIcon icon6 = new ImageIcon("imagenes/kingkong.jpg");
        ImageIcon icon7 = new ImageIcon("imagenes/toystory.jpg");
        ImageIcon icon8 = new ImageIcon("imagenes/laqueseavecina.jpg");
        ImageIcon icon9 = new ImageIcon("imagenes/lucifer.jpg");
        ImageIcon icon10 = new ImageIcon("imagenes/naruto.jpg");
        
            // Creamos las peliculas
            
        Pelicula p1 = new Pelicula("111", "Pedro Almodovar", "Aladdin", "Aladdin es un ladronzuelo que se enamora de la hija del Sultán, la princesa Jasmine. "
                + "Para poder conquistarla aceptará un desafío de Jafar. Aladdín tendrá que entrar en una cueva en mitad del desierto y conseguir una lámpara mágica "
                + "que contiene al Genio que será el encargado de concederle todos sus deseos.", "Fantasia y Ciencia Ficcion", "2019", "Naomi Scott, Will Smith, ...", icon1, "");
        Pelicula p2 = new Pelicula("122", "Woody Allen", "Avatar", "Jake Sully es un ex-marine confinado en una silla de ruedas que, a pesar de su cuerpo tullido, "
                + "todavía es un guerrero de corazón. Jake ha sido reclutado para viajar a Pandora, donde las corporaciones están extrayendo un mineral extraño que es"
                + " la clave para resolver los problemas de la crisis energética de la Tierra.", "Ciencia Ficción", "2009", "Sam Worthington, Zoe Saldana, Sigourney Weaver, ...", icon2, "");
        Pelicula p3 = new Pelicula("98", "Quentin Tarantino", "Buscando a nemo", "Nemo, un pequeño pececillo, muy querido y protegido por su padre, se pierde fuera de la "
                + "gran barrera del arrecife australiano, después de ser capturado por este arrecife, Nemo terminará en una pecera en Sidney. Su padre, un pez payaso, parte en "
                + "su búsqueda y se embarca en una peligrosa aventura con Dory, un pez con muy poca memoria. Al mismo tiempo, Nemo y sus nuevos amigos ya traman un plan para escapar "
                + "de la pecera.", "Animacion y Aventura", "2003", "Nemo, dory, ...", icon3, "");
        Pelicula p4 = new Pelicula("98", "Steven Spielgber", "Fast and Furious", "Desde las playas de Cuba a las calles de Nueva York, pasando por las llanuras árticas bañadas por el Mar "
                + "de Barents, los amigos cruzarán el globo en un desesperado intento por detener a unos anarquistas dispuestos a convertir el mundo en un caos... y para llevar a casa al "
                + "hombre que les hizo ser una familia.", "Aventura y Accion", "2017", "Vin Diesel, Dwayne Johnson, Jason Statham, ... ", icon4, "");
        Pelicula p5 = new Pelicula("112", "Steven Spielberg", "Joker", "La pasión de Arthur Fleck, un hombre ignorado por la sociedad, es hacer reír a la gente. Sin embargo, una serie de "
                + "trágicos sucesos harán que su visión del mundo se distorsione considerablemente convirtiéndolo en un brillante criminal.", "Drama Social y Accion ", "2019", "Joaquin Phoenix, "
                        + "Robert De Niro, Zazie Beetz, ...", icon5, "");
        Pelicula p6 = new Pelicula("109", "Woody Allen", "Godzilla vs Kingkong", "Godzilla y Kong, dos de las fuerzas más poderosas de un planeta habitado por aterradoras criaturas, se "
                + "enfrentan en un espectacular combate que sacude los cimientos de la humanidad.", "Accion y Ciencia Ficcion", "2021", "Kyle Chandler, Millie Bobby Brown, ...", icon6, "");
        Pelicula p7 = new Pelicula("114", "Federico Fellini", "Toy Story", "Woody siempre ha tenido claro cuál es su labor en el mundo y cuál es su prioridad: cuidar a su dueño, ya sea Andy "
                + "o Bonnie. Sin embargo, Woody descubrirá lo grande que puede ser el mundo para un juguete cuando Forky se convierta en su nuevo compañero de habitación. Los juguetes "
                + "se embarcarán en una aventura de la que no se olvidarán jamás.", "Animacion, Ficcion y Aventura", "1995", "Woody, Buz, ...", icon7, "");
        
            // Se añaden al array de peliculas
            
        peliculas.add(p1);
        peliculas.add(p2);
        peliculas.add(p3);
        peliculas.add(p4);
        peliculas.add(p5);
        peliculas.add(p6);
        peliculas.add(p7);
        
        GuardarLeerFicheros.guardarDatosPeliculas();
        GuardarLeerFicheros.cargarDatosPeliculas();
        
        
        
        // Creamos los capitulos de las series 
        ArrayList <Capitulo> capitulosSerie1 = new ArrayList<>();
        Capitulo s1cap1 = new Capitulo("T1 Capitulo 1", "23");
        Capitulo s1cap2 = new Capitulo("T1 Capitulo 2", "32");
        Capitulo s1cap3 = new Capitulo("T1 Capitulo 3", "12");
        Capitulo s1cap4 = new Capitulo("T1 Capitulo 4", "65");
        Capitulo s1cap5 = new Capitulo("T2 Capitulo 1", "45");
        Capitulo s1cap6 = new Capitulo("T2 Capitulo 2", "43");
        Capitulo s1cap7 = new Capitulo("T2 Capitulo 3", "53");
        Capitulo s1cap8 = new Capitulo("T2 Capitulo 4", "44");
        capitulosSerie1.add(s1cap1);
        capitulosSerie1.add(s1cap2);
        capitulosSerie1.add(s1cap3);
        capitulosSerie1.add(s1cap4);
        capitulosSerie1.add(s1cap5);
        capitulosSerie1.add(s1cap6);
        capitulosSerie1.add(s1cap7);
        capitulosSerie1.add(s1cap8);
        
        ArrayList <Capitulo> capitulosSerie2 = new ArrayList<>();
        Capitulo s2cap1 = new Capitulo("Capitulo 1", "49");
        Capitulo s2cap2 = new Capitulo("Capitulo 2", "50");
        Capitulo s2cap3 = new Capitulo("Capitulo 3", "47");
        Capitulo s2cap4 = new Capitulo("Capitulo 4", "51");
        capitulosSerie2.add(s2cap1);
        capitulosSerie2.add(s2cap2);
        capitulosSerie2.add(s2cap3);
        capitulosSerie2.add(s2cap4);
        
        ArrayList <Capitulo> capitulosSerie3 = new ArrayList<>();
        Capitulo s3cap1 = new Capitulo("Titulo1", "49");
        Capitulo s3cap2 = new Capitulo("Titulo2", "50");
        Capitulo s3cap3 = new Capitulo("Titulo3", "47");
        Capitulo s3cap4 = new Capitulo("Titulo4", "51");
        capitulosSerie3.add(s3cap1);
        capitulosSerie3.add(s3cap2);
        capitulosSerie3.add(s3cap3);
        capitulosSerie3.add(s3cap4);
        
        Serie serie1 = new Serie("13", capitulosSerie1, "La Que Se Avecina", "Sinopsis1", "Genero1", "2002", "Actores1", icon8, "");
        Serie serie2 = new Serie("4", capitulosSerie2, "Lucifer", "Sinopsis2", "Genero2", "2001", "Actores2", icon9, "");
        Serie serie3 = new Serie("1", capitulosSerie3, "Naruto", "Sinopsis2", "Genero2", "2001", "Actores2", icon10, "");
        
        series.add(serie1);
        series.add(serie2);
        series.add(serie3);
        
        GuardarLeerFicheros.guardarDatosSeries();
        GuardarLeerFicheros.cargarDatosSeries();
        
        // Creamos los usuarios
        
        LocalDate fechaCadT1 = LocalDate.of(2022, Month.MARCH, 22);
        LocalDate fechaCadT2 = LocalDate.of(2023, Month.APRIL, 23);
        LocalDate fechaCadT3 = LocalDate.of(2021, Month.MAY, 10);
        LocalDate fechaCadT4 = LocalDate.of(2023, Month.NOVEMBER, 23);
        LocalDate fechaCadT5 = LocalDate.of(2023, Month.JANUARY, 23);
        
        Tarjeta t1 = new Tarjeta("987573733645", fechaCadT1, 3122);
        Tarjeta t2 = new Tarjeta("364237455437", fechaCadT2, 21335);
        Tarjeta t3 = new Tarjeta("394732743478", fechaCadT3, 432);
        Tarjeta t4 = new Tarjeta("231893633535", fechaCadT4, 2123);
        Tarjeta t5 = new Tarjeta("193836432311", fechaCadT5, 654);
        
        LocalDateTime time = LocalDateTime.now();
        
        LocalDate fechaSus1 = LocalDate.of(time.getYear(), time.getMonth(), time.getDayOfMonth());
        LocalDate fechaSus2 = LocalDate.of(time.getYear(), time.getMonth(), time.getDayOfMonth());
        LocalDate fechaSus3 = LocalDate.of(time.getYear(), time.getMonth(), time.getDayOfMonth());
        LocalDate fechaSus4 = LocalDate.of(time.getYear(), time.getMonth(), time.getDayOfMonth());
        LocalDate fechaSus5 = LocalDate.of(time.getYear(), time.getMonth(), time.getDayOfMonth());
        
        Cliente c1 = new Cliente("5346243O", "Ricardo", "ricardo@uni.com", "ricardo1", t1);
        Cliente c2 = new Cliente("2443245F", "Alejandro", "alejandro@uni.com", "alejandro1", t2);
        Cliente c3 = new Cliente("2736745E", "Alvaro", "Alvaro@uni.com", "alvaro1", t3);
        Cliente c4 = new Cliente("8574364U", "Maria", "maria@uni.com", "maria1", t4);
        Cliente c5 = new Cliente("1287362Y", "Lucia", "lucia@uni.com", "lucia1", t5);
        
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);
        clientes.add(c5);
        
        GuardarLeerFicheros.guardarDatosClientes();
        GuardarLeerFicheros.cargarDatosClientes();
        
        Suscripcion sus1 = new Suscripcion(fechaSus1, c1, 8.99);
        Suscripcion sus2 = new Suscripcion(fechaSus2, c2, 11.99);
        Suscripcion sus3 = new Suscripcion(fechaSus3, c3, 8.99);
        Suscripcion sus4 = new Suscripcion(fechaSus4, c4, 8.99);
        Suscripcion sus5 = new Suscripcion(fechaSus5, c5, 15.99);
        
        GuardarLeerFicheros.guardarDatosSuscripcion(c1.getDni(), sus1);
        GuardarLeerFicheros.guardarDatosSuscripcion(c2.getDni(), sus2);
        GuardarLeerFicheros.guardarDatosSuscripcion(c3.getDni(), sus3);
        GuardarLeerFicheros.guardarDatosSuscripcion(c4.getDni(), sus4);
        GuardarLeerFicheros.guardarDatosSuscripcion(c5.getDni(), sus5); 
        
        
    }
    
    public static void verificarFicheros() {
        try {
            
            File file1 = new File("ficheros/listaClientes.dat");
            File file2 = new File("ficheros/listaPeliculas.dat");
            File file3 = new File("ficheros/listaSeries.dat");
            File file4 = new File("ficheros/archivoTemporal.dat");
            
            // Si los archivos no existen se crean
            if (!file1.exists()) {
                file1.createNewFile();
            } if (!file2.exists()) {
                file2.createNewFile();
            } if (!file3.exists()) {
                file3.createNewFile();
            } if (!file4.exists()) {
                file4.createNewFile();
            } if (file4.exists()) {
                file4.delete();
                file4.createNewFile();
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
    
}
