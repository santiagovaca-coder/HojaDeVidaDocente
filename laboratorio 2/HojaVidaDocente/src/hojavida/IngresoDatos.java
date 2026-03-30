package hojavida;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class IngresoDatos extends JFrame {

    JFrame padre;

    JTextField txtCedula      = new JTextField();
    JTextField txtNombre      = new JTextField();
    JTextField txtCorreo      = new JTextField();
    JTextField txtTelefono    = new JTextField();
    JTextField txtUniversidad = new JTextField();
    JTextField txtAnioInicio  = new JTextField();
    JTextArea  areaDescripcion = new JTextArea(3, 30);

    JComboBox<String> cmbNivelFormacion  = new JComboBox<>();
    JComboBox<String> cmbTipoVinculacion = new JComboBox<>();

    JRadioButton rbActivo   = new JRadioButton("Activo");
    JRadioButton rbInactivo = new JRadioButton("Inactivo");
    JRadioButton rbOculto   = new JRadioButton();
    ButtonGroup  grupoEstado = new ButtonGroup();

    JToggleButton tglDedicacion = new JToggleButton("Medio Tiempo");

    JCheckBox chkInvestigacion = new JCheckBox("Investigacion");
    JCheckBox chkPublicaciones = new JCheckBox("Publicaciones Academicas");
    JCheckBox chkIngenieria    = new JCheckBox("Ingenieria y Tecnologia");
    JCheckBox chkCiencias      = new JCheckBox("Ciencias Basicas");
    JCheckBox chkPresencial    = new JCheckBox("Presencial");
    JCheckBox chkVirtual       = new JCheckBox("Virtual");
    JCheckBox chkMixto         = new JCheckBox("Mixto");

    JButton btnGuardar = new JButton("Guardar");
    JButton btnLimpiar = new JButton("Limpiar");
    JButton btnVolver  = new JButton("Volver al Menu");

    public IngresoDatos(JFrame padre) {
        super("Ingreso de Datos - Hoja de Vida Docente");
        this.padre = padre;
        setSize(700, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JPanel panelPersonal = new JPanel(new GridLayout(6, 2, 5, 5));
        panelPersonal.setBorder(new TitledBorder("Datos Personales"));
        panelPersonal.add(new JLabel("Cedula (PK) *:"));
        panelPersonal.add(txtCedula);
        panelPersonal.add(new JLabel("Nombre Completo *:"));
        panelPersonal.add(txtNombre);
        panelPersonal.add(new JLabel("Correo Institucional *:"));
        panelPersonal.add(txtCorreo);
        panelPersonal.add(new JLabel("Telefono:"));
        panelPersonal.add(txtTelefono);
        panelPersonal.add(new JLabel("Universidad / Institucion *:"));
        panelPersonal.add(txtUniversidad);
        panelPersonal.add(new JLabel("Año inicio docencia *:"));
        txtAnioInicio.setToolTipText("Ej: 2010 - se usa para calcular años de experiencia");
        panelPersonal.add(txtAnioInicio);

        JPanel panelDescripcion = new JPanel(new BorderLayout());
        panelDescripcion.setBorder(new TitledBorder("Descripcion del Perfil Profesional"));
        areaDescripcion.setLineWrap(true);
        areaDescripcion.setWrapStyleWord(true);
        panelDescripcion.add(new JScrollPane(areaDescripcion), BorderLayout.CENTER);

        JPanel panelFormacion = new JPanel(new GridLayout(2, 2, 5, 5));
        panelFormacion.setBorder(new TitledBorder("Formacion y Vinculacion"));
        panelFormacion.add(new JLabel("Nivel de Formacion:"));
        cmbNivelFormacion.addItem("Seleccione...");
        cmbNivelFormacion.addItem("Tecnologia");
        cmbNivelFormacion.addItem("Pregrado / Licenciatura");
        cmbNivelFormacion.addItem("Especializacion");
        cmbNivelFormacion.addItem("Maestria");
        cmbNivelFormacion.addItem("Doctorado");
        cmbNivelFormacion.addItem("Postdoctorado");
        panelFormacion.add(cmbNivelFormacion);
        panelFormacion.add(new JLabel("Tipo de Vinculacion:"));
        cmbTipoVinculacion.addItem("Seleccione...");
        cmbTipoVinculacion.addItem("Planta");
        cmbTipoVinculacion.addItem("Ocasional");
        cmbTipoVinculacion.addItem("Catedra");
        cmbTipoVinculacion.addItem("Contratista");
        panelFormacion.add(cmbTipoVinculacion);

        JPanel panelEstado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEstado.setBorder(new TitledBorder("Estado Laboral"));
        rbActivo.setSelected(true);
        grupoEstado.add(rbActivo);
        grupoEstado.add(rbInactivo);
        grupoEstado.add(rbOculto);
        panelEstado.add(rbActivo);
        panelEstado.add(rbInactivo);

        JPanel panelDedicacion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelDedicacion.setBorder(new TitledBorder("Dedicacion"));
        tglDedicacion.addActionListener((e) -> evento_toggle());
        panelDedicacion.add(new JLabel("Haga clic para cambiar:  "));
        panelDedicacion.add(tglDedicacion);

        JPanel panelHabilidades = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelHabilidades.setBorder(new TitledBorder("Habilidades Adicionales"));
        panelHabilidades.add(chkInvestigacion);
        panelHabilidades.add(chkPublicaciones);

        JPanel panelAreas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelAreas.setBorder(new TitledBorder("Area de Conocimiento"));
        panelAreas.add(chkIngenieria);
        panelAreas.add(chkCiencias);

        JPanel panelModalidad = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelModalidad.setBorder(new TitledBorder("Modalidad de Clase (puede elegir varias)"));
        panelModalidad.add(chkPresencial);
        panelModalidad.add(chkVirtual);
        panelModalidad.add(chkMixto);

        ImageIcon icoVolver = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        btnVolver.setIcon(icoVolver);
        btnVolver.setHorizontalTextPosition(SwingConstants.RIGHT);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnGuardar.setPreferredSize(new Dimension(120, 32));
        btnLimpiar.setPreferredSize(new Dimension(120, 32));
        btnVolver.setPreferredSize(new Dimension(170, 32));
        btnGuardar.addActionListener((e) -> evento_guardar());
        btnLimpiar.addActionListener((e) -> evento_limpiar());
        btnVolver.addActionListener((e) -> evento_volver());
        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnVolver);

        panelPrincipal.add(panelPersonal);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 5)));
        panelPrincipal.add(panelDescripcion);
        panelPrincipal.add(Box.createRigidArea(new Dimension(0, 5)));
        panelPrincipal.add(panelFormacion);
        panelPrincipal.add(panelEstado);
        panelPrincipal.add(panelDedicacion);
        panelPrincipal.add(panelHabilidades);
        panelPrincipal.add(panelAreas);
        panelPrincipal.add(panelModalidad);
        panelPrincipal.add(panelBotones);

        JScrollPane scroll = new JScrollPane(panelPrincipal);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setContentPane(scroll);
    }

    private void evento_toggle() {
        tglDedicacion.setText(tglDedicacion.isSelected() ? "Tiempo Completo" : "Medio Tiempo");
    }

    private void evento_guardar() {
        if (txtCedula.getText().trim().isEmpty()) {
            Dialogo.mostrarError(this, "La cedula es obligatoria.", "Campo requerido");
            txtCedula.requestFocus(); return;
        }
        if (txtNombre.getText().trim().isEmpty()) {
            Dialogo.mostrarError(this, "El nombre completo es obligatorio.", "Campo requerido");
            txtNombre.requestFocus(); return;
        }
        if (txtCorreo.getText().trim().isEmpty()) {
            Dialogo.mostrarError(this, "El correo institucional es obligatorio.", "Campo requerido");
            txtCorreo.requestFocus(); return;
        }
        if (txtUniversidad.getText().trim().isEmpty()) {
            Dialogo.mostrarError(this, "La universidad es obligatoria.", "Campo requerido");
            txtUniversidad.requestFocus(); return;
        }
        if (txtAnioInicio.getText().trim().isEmpty()) {
            Dialogo.mostrarError(this, "El año de inicio de docencia es obligatorio.", "Campo requerido");
            txtAnioInicio.requestFocus(); return;
        }

        int anioInicio;
        try {
            anioInicio = Integer.parseInt(txtAnioInicio.getText().trim());
            if (anioInicio < 1950 || anioInicio > 2026) {
                Dialogo.mostrarAdvertencia(this, "El año debe estar entre 1950 y 2026.", "Año invalido");
                return;
            }
        } catch (NumberFormatException ex) {
            Dialogo.mostrarError(this, "El año de inicio debe ser un numero valido.", "Formato incorrecto");
            return;
        }

        if (GestorDocentes.getInstancia().existeCedula(txtCedula.getText().trim())) {
            Dialogo.mostrarError(this, "Ya existe un docente con esa cedula.", "Cedula duplicada");
            return;
        }
        if (cmbNivelFormacion.getSelectedIndex() == 0) {
            Dialogo.mostrarAdvertencia(this, "Seleccione el nivel de formacion.", "Seleccion requerida");
            return;
        }
        if (cmbTipoVinculacion.getSelectedIndex() == 0) {
            Dialogo.mostrarAdvertencia(this, "Seleccione el tipo de vinculacion.", "Seleccion requerida");
            return;
        }

        String estado    = rbActivo.isSelected() ? "Activo" : "Inactivo";
        String dedicacion = tglDedicacion.isSelected() ? "Tiempo Completo" : "Medio Tiempo";

        ArrayList<String> habilidades = new ArrayList<>();
        if (chkInvestigacion.isSelected()) habilidades.add("Investigacion");
        if (chkPublicaciones.isSelected())  habilidades.add("Publicaciones Academicas");

        ArrayList<String> areas = new ArrayList<>();
        if (chkIngenieria.isSelected()) areas.add("Ingenieria y Tecnologia");
        if (chkCiencias.isSelected())   areas.add("Ciencias Basicas");

        ArrayList<String> modalidades = new ArrayList<>();
        if (chkPresencial.isSelected()) modalidades.add("Presencial");
        if (chkVirtual.isSelected())    modalidades.add("Virtual");
        if (chkMixto.isSelected())      modalidades.add("Mixto");

        if (modalidades.isEmpty()) {
            Dialogo.mostrarAdvertencia(this, "Seleccione al menos una modalidad de clase.", "Modalidad requerida");
            return;
        }

        DocenteHV nuevo = new DocenteHV(
                txtCedula.getText().trim(), txtNombre.getText().trim(),
                txtCorreo.getText().trim(), txtTelefono.getText().trim(),
                txtUniversidad.getText().trim(), areaDescripcion.getText().trim(),
                anioInicio, (String) cmbNivelFormacion.getSelectedItem(),
                estado, (String) cmbTipoVinculacion.getSelectedItem(),
                dedicacion, habilidades, areas, modalidades);

        GestorDocentes.getInstancia().agregarDocente(nuevo);

        Dialogo.mostrarInfo(this,
                "Docente guardado correctamente.\nAños de experiencia calculados: "
                + nuevo.getAniosExperiencia(), "Registro guardado");

        if (Dialogo.confirmar(this, "Desea ingresar otro docente?", "Nuevo registro"))
            evento_limpiar();
        else
            evento_volver();
    }

    private void evento_limpiar() {
        txtCedula.setText("");      txtNombre.setText("");
        txtCorreo.setText("");      txtTelefono.setText("");
        txtUniversidad.setText(""); txtAnioInicio.setText("");
        areaDescripcion.setText("");
        cmbNivelFormacion.setSelectedIndex(0);
        cmbTipoVinculacion.setSelectedIndex(0);
        rbOculto.setSelected(true);
        tglDedicacion.setSelected(false);
        tglDedicacion.setText("Medio Tiempo");
        chkInvestigacion.setSelected(false); chkPublicaciones.setSelected(false);
        chkIngenieria.setSelected(false);    chkCiencias.setSelected(false);
        chkPresencial.setSelected(false);    chkVirtual.setSelected(false);
        chkMixto.setSelected(false);
        txtCedula.requestFocus();
    }

    private void evento_volver() {
        setVisible(false);
        dispose();
        padre.setVisible(true);
    }
}
