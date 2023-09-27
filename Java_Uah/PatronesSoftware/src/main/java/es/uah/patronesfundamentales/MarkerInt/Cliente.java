package es.uah.patronesfundamentales.MarkerInt;

import java.util.ArrayList;

/**
 * Clase cliente.
 */
public class Cliente {

    /**
     * Método de arranque del programa.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Lista de vehículos
        ArrayList vehiculos = new ArrayList();
        //Lista de vehículos con motor
        ArrayList<MotorInt> vehiculosConMotor = new ArrayList<>();

        MotorInt c1 = new Coche(5);
        MotorInt c2 = new Coche(2);
        MotorInt m1 = new Moto(250);
        MotorInt m2 = new Moto(650);
        Bicicleta b1 = new Bicicleta("montaña");
        Bicicleta b2 = new Bicicleta("carretera");

        //Añadimos los vehículos a la lista
        vehiculos.add(c1);
        vehiculos.add(c2);
        vehiculos.add(m1);
        vehiculos.add(m2);
        vehiculos.add(b1);
        vehiculos.add(b2);

        //Recorremos la lista de vehiculos y aquellos que son de motor los añadimos a la lista vehiculosConMotor. 
        for (Object vehiculo : vehiculos) {
            if (vehiculo instanceof MotorInt) {// Devuelve true si el objeto es de tipo MotorInt (marcador o bandera)
                vehiculosConMotor.add((MotorInt) vehiculo);
            }
        }

        // Mostramos la lista de vehículos con motor.
        System.out.println(vehiculosConMotor.toString());

    }
}
