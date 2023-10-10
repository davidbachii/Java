package patrones.universidad;

import java.util.Random;

public class Nomina implements IntNomina {

    @Override
    public int calculaNomina(String tipo) {
        Random rand = new Random();
        if (tipo.equals("PDI")) {
            return rand.nextInt(1001) + 1000;
        } else {
            return rand.nextInt(501) + 1000;
        }
    }
}
