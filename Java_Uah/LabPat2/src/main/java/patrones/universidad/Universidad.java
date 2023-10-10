package patrones.universidad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

    private String _nombre;
    private ArrayList _PAS;
    private ArrayList _PDI;

    public Universidad(String nombre) {
        _nombre = nombre;
        _PAS = new ArrayList();
        _PDI = new ArrayList();
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public boolean contratarPAS() throws IOException {
        BufferedReader _entrada = new BufferedReader(new InputStreamReader(System.in));
        int identificador;
        String seccion, cargo;

        System.out.println("Identificador del nuevo PAS:(numero) ");
        identificador = (new Integer(_entrada.readLine())).intValue();

        System.out.println("Seccion: ");
        seccion = _entrada.readLine();

        System.out.println("Cargo: ");
        cargo = _entrada.readLine();

        return _PAS.add((Object) new PAS(identificador, seccion, cargo));
    }

    public boolean jubilarPAS() throws IOException {
        BufferedReader _entrada = new BufferedReader(new InputStreamReader(System.in));
        PAS pas;
        int identificador;
        boolean ok;

        ok = false;
        System.out.println("Introduzca el numero identificador del PAS:");
        identificador = (new Integer(_entrada.readLine())).intValue();
        pas = buscarPAS(identificador);
        if (pas != null) {
            _PAS.remove(pas);
            System.out.println("PAS " + identificador
                    + " dado de baja en el sistema.");
        } else {
            System.out.println("Error: PAS " + identificador + " no existe");
        }

        return ok;
    }

    public PAS buscarPAS(int identificador) {
        PAS pas;
        Iterator i;
        boolean encontrado;

        encontrado = false;
        pas = null;
        i = _PAS.iterator();
        while (!encontrado && i.hasNext()) {
            pas = (PAS) i.next();
            if (pas.getIdentificador() == identificador) {
                encontrado = true;
            }
        }

        if (!encontrado) {
            pas = null;
        }

        return pas;
    }

    public boolean modificarPAS() throws IOException {
        BufferedReader _entrada = new BufferedReader(new InputStreamReader(System.in));
        PAS pas;
        int identificador;
        boolean ok;

        ok = false;

        System.out.println("Introduzca el numero identificador del PAS:");
        identificador = (new Integer(_entrada.readLine())).intValue();
        pas = buscarPAS(identificador);
        if (pas != null) {
            ok = pas.modificar();
        } else {
            System.out.println("Error: PAS " + identificador + " no existe");
        }
        return ok;
    }

    public void mostrarPASs() {
        System.out.println("PAS (Personal de Administracion y Servicios)");
        for (Iterator i = _PAS.iterator(); i.hasNext();) {
            System.out.println(((PAS) i.next()).toString() + "\n");
        }
    }

    public boolean contratarPDI() throws IOException {
        BufferedReader _entrada = new BufferedReader(new InputStreamReader(System.in));
        int identificador;
        String departamento, area;

        System.out.println("Identificador del nuevo PDI:(numero) ");
        identificador = (new Integer(_entrada.readLine())).intValue();

        System.out.println("Departamento: ");
        departamento = _entrada.readLine();

        System.out.println("Area: ");
        area = _entrada.readLine();

        return _PDI.add((Object) new PDI(identificador, departamento, area));
    }

    public boolean jubilarPDI() throws IOException {
        BufferedReader _entrada = new BufferedReader(new InputStreamReader(System.in));
        PDI pdi;
        int identificador;
        boolean ok;

        ok = false;
        System.out.println("Introduzca el numero identificador del PDI:");
        identificador = (new Integer(_entrada.readLine())).intValue();
        pdi = buscarPDI(identificador);
        if (pdi != null) {
            _PDI.remove(pdi);
            System.out.println("PDI " + identificador
                    + " dado de baja en el sistema.");
        } else {
            System.out.println("Error: PDI " + identificador + " no existe");
        }
        return ok;
    }

    public PDI buscarPDI(int identificador) {
        PDI pdi;
        Iterator i;
        boolean encontrado;

        encontrado = false;
        pdi = null;
        i = _PDI.iterator();
        while (!encontrado && i.hasNext()) {
            pdi = (PDI) i.next();
            if (pdi.getIdentificador() == identificador) {
                encontrado = true;
            }
        }

        if (!encontrado) {
            pdi = null;
        }

        return pdi;
    }

    public boolean modificarPDI() throws IOException {
        BufferedReader _entrada = new BufferedReader(new InputStreamReader(System.in));
        PDI pdi;
        int identificador;
        boolean ok;

        ok = false;
        System.out.println("Introduzca el numero identificador del PDI:");
        identificador = (new Integer(_entrada.readLine())).intValue();
        pdi = buscarPDI(identificador);
        if (pdi != null) {
            ok = pdi.modificar();
        } else {
            System.out.println("Error: PDI " + identificador + " no existe");
        }
        return ok;
    }

    public void mostrarPDIs() {
        System.out.println("PDI (Personal Docente e Investigador)");
        for (Iterator i = _PDI.iterator(); i.hasNext();) {
            System.out.println(((PDI) i.next()).toString() + "\n");
        }
    }

    public void generarNominas() {
        for (Iterator i = _PAS.iterator(); i.hasNext();) {
            ((PAS) i.next()).generarNomina();
        }
        for (Iterator i = _PDI.iterator(); i.hasNext();) {
            ((PDI) i.next()).generarNomina();
        }
    }

    public void mostrar() {
        System.out.println("--------------------------------------------");
        System.out.println("Universidad " + _nombre);
        System.out.println("--------------------------------------------");
        mostrarPASs();
        System.out.println("--------------------------------------------");
        mostrarPDIs();
        System.out.println("--------------------------------------------");
    }
}
