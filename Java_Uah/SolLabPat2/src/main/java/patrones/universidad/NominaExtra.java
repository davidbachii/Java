package patrones.universidad;

import java.util.Random;

public class NominaExtra implements IntNomina {
    @Override
    public int calculaNomina(String tipo) {
        Random rand = new Random();
        if (tipo.equals("PDI")) {
            return rand.nextInt(1001) + 2000;
        } else {
            return rand.nextInt(501) + 2000;
        }
    }
}
