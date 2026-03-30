package hojavida;

import java.util.ArrayList;

public class GestorDocentes {

    private ArrayList<DocenteHV> listaDocentes;

    private static GestorDocentes instancia;

    private GestorDocentes() {
        listaDocentes = new ArrayList<>();
    }

    public static GestorDocentes getInstancia() {
        if (instancia == null) {
            instancia = new GestorDocentes();
        }
        return instancia;
    }

    public void agregarDocente(DocenteHV docente) {
        listaDocentes.add(docente);
    }

    public ArrayList<DocenteHV> getListaDocentes() {
        return listaDocentes;
    }

    public boolean existeCedula(String cedula) {
        for (DocenteHV d : listaDocentes) {
            if (d.getCedula().equals(cedula)) return true;
        }
        return false;
    }

    public int getTotalDocentes() {
        return listaDocentes.size();
    }

    public int contarPorNivelFormacion(String nivel) {
        int contador = 0;
        for (DocenteHV d : listaDocentes) {
            if (d.getNivelFormacion().equals(nivel)) contador++;
        }
        return contador;
    }

    public double promedioAniosExperiencia() {
        if (listaDocentes.isEmpty()) return 0;
        int suma = 0;
        for (DocenteHV d : listaDocentes) {
            suma += d.getAniosExperiencia();
        }
        return (double) suma / listaDocentes.size();
    }

    public int contarTiempoCompleto() {
        int contador = 0;
        for (DocenteHV d : listaDocentes) {
            if ("Tiempo Completo".equals(d.getDedicacion())) contador++;
        }
        return contador;
    }
}
