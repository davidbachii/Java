package es.uah.banco.PO;

import java.time.LocalDate;

public class PruebaBanco {

    public static void main(String[] args) {
        CarteraValores c1 = new CarteraValores("Cartera 1");
        LocalDate fv1 = LocalDate.of(2022, 1, 1);
        LocalDate fv2 = LocalDate.of(2022, 2, 1);
        LocalDate fv3 = LocalDate.of(2022, 4, 1);
        Valor v1 = new Valor("Telefonica", 10, 12.3, 150, fv1, c1);
        Valor v2 = new Valor("BBVA", 7, 9.4, 400, fv2, c1);
        Valor v3 = new Valor("Indra", 14, 10.7, 200, fv3, c1);
        
        LocalDate f1 = LocalDate.of(2021, 2, 1);
        LocalDate f2 = LocalDate.of(2022, 2, 1);
        FondoInversion fi = new FondoInversion("Fondo Moderado", f1, f2);
        Activo a1 = new Activo("Renta fija", 500, 650, fi);
        Activo a2 = new Activo("Renta variable", 1000, 1100, fi);
        Activo a3 = new Activo("Inmuebles", 1000, 900, fi);

        System.out.println("Rentabilidad cartera:");
        System.out.println(c1.calculaRentabilidad()+"%");
        System.out.println("Rentabilidad fondo:");
        System.out.println(fi.calculaRentabilidad()+"%");        
    }
    
}
