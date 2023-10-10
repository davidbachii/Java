package patrones.universidad;

import java.util.ArrayList;
import java.util.Iterator;

public class Universidad {

    private String _nombre;
    private ArrayList<PAS> _personalPAS;
    private ArrayList<PDI> _personalPDI;

    public Universidad(String nombre) {
        _nombre = nombre;
        _personalPAS = new ArrayList<>();
        _personalPDI = new ArrayList<>();
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    } 

    public boolean contratarPAS(int identificador, String seccion, String cargo) {
        return _personalPAS.add(new PAS(identificador, seccion, cargo));
    }

    public boolean jubilarPAS(int identificador) {
        boolean ok = false;

        PAS pas = buscarPAS(identificador);
        if (pas != null) {
            _personalPAS.remove(pas);
            ok = true;
        } else {
            ok = false;
        }

        return ok;
    }

    public PAS buscarPAS(int identificador) {
        PAS pas = null;
        Iterator i;
        boolean encontrado = false;

        i = _personalPAS.iterator();
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

    public boolean modificarPAS(int identificador, String seccion, String cargo) {
        boolean ok = false;
        PAS pas = buscarPAS(identificador);
        if (pas != null) {
            pas.modificar(seccion, cargo);
            ok = true;
        } else {
            ok = false;
        }
        return ok;
    }

    public ArrayList<PAS> obtenerPASs() {
        return _personalPAS;
    }

    public boolean contratarPDI(int identificador, String departamento, String area) {
        return _personalPDI.add(new PDI(identificador, departamento, area));
    }

    public boolean jubilarPDI(int identificador) {          
        boolean ok = false;
        
        PDI pdi = buscarPDI(identificador);
        if (pdi != null) {
            _personalPDI.remove(pdi);
            ok = true;
        } else {
            ok = false;
        }
        return ok;
    }

    public PDI buscarPDI(int identificador) {
        PDI pdi = null;
        Iterator i;
        boolean encontrado = false;
        
        i = _personalPDI.iterator();
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

    public boolean modificarPDI(int identificador, String departamento, String area) {
        boolean ok = false;
        
        PDI pdi = buscarPDI(identificador);
        if (pdi != null) {
            pdi.modificar(departamento, area);
            ok = true;
        } else {
            ok = false;
        }
        return ok;
    }

    public ArrayList<PDI> obtenerPDIs() {        
        return _personalPDI;
    }

    public String generarNominas() {
        String nominas = "";
        for (Iterator i = _personalPAS.iterator(); i.hasNext();) {
            nominas += ((PAS) i.next()).generarNomina()+"\n";
        }
        for (Iterator i = _personalPDI.iterator(); i.hasNext();) {
            nominas += ((PDI) i.next()).generarNomina()+"\n";
        }
        return nominas;
    }


}
