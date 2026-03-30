package hojavida;

import java.util.ArrayList;

public class DocenteHV {

    private String cedula;

    private String nombreCompleto;
    private String correoInstitucional;
    private String telefono;
    private String universidad;
    private String descripcionPerfil;

    private int aniosExperiencia;

    private String nivelFormacion;

    private String estadoLaboral;

    private String tipoVinculacion;

    private String dedicacion;

    private ArrayList<String> habilidades;

    private ArrayList<String> areasConocimiento;

    private ArrayList<String> modalidades;

    private int anioInicioDocencia;

    public DocenteHV(String cedula, String nombreCompleto, String correoInstitucional,
            String telefono, String universidad, String descripcionPerfil,
            int anioInicioDocencia, String nivelFormacion, String estadoLaboral,
            String tipoVinculacion, String dedicacion,
            ArrayList<String> habilidades, ArrayList<String> areasConocimiento,
            ArrayList<String> modalidades) {

        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.correoInstitucional = correoInstitucional;
        this.telefono = telefono;
        this.universidad = universidad;
        this.descripcionPerfil = descripcionPerfil;
        this.anioInicioDocencia = anioInicioDocencia;
        this.nivelFormacion = nivelFormacion;
        this.estadoLaboral = estadoLaboral;
        this.tipoVinculacion = tipoVinculacion;
        this.dedicacion = dedicacion;
        this.habilidades = habilidades;
        this.areasConocimiento = areasConocimiento;
        this.modalidades = modalidades;

        int anioActual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        this.aniosExperiencia = anioActual - anioInicioDocencia;
        if (this.aniosExperiencia < 0) {
            this.aniosExperiencia = 0;
        }
    }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getCorreoInstitucional() { return correoInstitucional; }
    public void setCorreoInstitucional(String correoInstitucional) { this.correoInstitucional = correoInstitucional; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getUniversidad() { return universidad; }
    public void setUniversidad(String universidad) { this.universidad = universidad; }

    public String getDescripcionPerfil() { return descripcionPerfil; }
    public void setDescripcionPerfil(String descripcionPerfil) { this.descripcionPerfil = descripcionPerfil; }

    public int getAniosExperiencia() { return aniosExperiencia; }

    public String getNivelFormacion() { return nivelFormacion; }
    public void setNivelFormacion(String nivelFormacion) { this.nivelFormacion = nivelFormacion; }

    public String getEstadoLaboral() { return estadoLaboral; }
    public void setEstadoLaboral(String estadoLaboral) { this.estadoLaboral = estadoLaboral; }

    public String getTipoVinculacion() { return tipoVinculacion; }
    public void setTipoVinculacion(String tipoVinculacion) { this.tipoVinculacion = tipoVinculacion; }

    public String getDedicacion() { return dedicacion; }
    public void setDedicacion(String dedicacion) { this.dedicacion = dedicacion; }

    public ArrayList<String> getHabilidades() { return habilidades; }
    public void setHabilidades(ArrayList<String> habilidades) { this.habilidades = habilidades; }

    public ArrayList<String> getAreasConocimiento() { return areasConocimiento; }
    public void setAreasConocimiento(ArrayList<String> areasConocimiento) { this.areasConocimiento = areasConocimiento; }

    public ArrayList<String> getModalidades() { return modalidades; }
    public void setModalidades(ArrayList<String> modalidades) { this.modalidades = modalidades; }

    public int getAnioInicioDocencia() { return anioInicioDocencia; }
    public void setAnioInicioDocencia(int anioInicioDocencia) { this.anioInicioDocencia = anioInicioDocencia; }

    public String getHabilidadesTexto() {
        if (habilidades == null || habilidades.isEmpty()) return "Ninguna";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < habilidades.size(); i++) {
            sb.append(habilidades.get(i));
            if (i < habilidades.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

    public String getAreasTexto() {
        if (areasConocimiento == null || areasConocimiento.isEmpty()) return "Ninguna";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < areasConocimiento.size(); i++) {
            sb.append(areasConocimiento.get(i));
            if (i < areasConocimiento.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

    public String getModalidadesTexto() {
        if (modalidades == null || modalidades.isEmpty()) return "No especificada";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < modalidades.size(); i++) {
            sb.append(modalidades.get(i));
            if (i < modalidades.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

    public String toString() {
        return cedula + " - " + nombreCompleto;
    }
}
