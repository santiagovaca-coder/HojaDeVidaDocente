package hojavida;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ListadoGeneral extends JFrame {

    JFrame padre;
    JTable tablaDocentes;
    DefaultTableModel modeloTabla;
    JButton btnActualizar = new JButton("Actualizar");
    JButton btnVolver     = new JButton("Volver al Menu");

    public ListadoGeneral(JFrame padre) {
        super("Listado General - Hoja de Vida Docente");
        this.padre = padre;
        setSize(900, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLayout(null);
        crearGUI();
        cargarTabla();
        setVisible(true);
    }

    private void crearGUI() {
        JLabel lblTitulo = new JLabel("Listado General de Docentes", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(0, 10, 900, 25);
        add(lblTitulo);

        String[] columnas = {
            "Cedula", "Nombre Completo", "Correo", "Universidad",
            "Nivel Formacion", "Estado", "Vinculacion", "Dedicacion",
            "Años Exp.", "Modalidades"
        };

        modeloTabla = new DefaultTableModel(columnas, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };

        tablaDocentes = new JTable(modeloTabla);
        tablaDocentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaDocentes.setRowHeight(22);
        tablaDocentes.setFont(new Font("Arial", Font.PLAIN, 11));
        tablaDocentes.getTableHeader().setFont(new Font("Arial", Font.BOLD, 11));

        JScrollPane scroll = new JScrollPane(tablaDocentes);
        scroll.setBounds(10, 45, 875, 360);
        add(scroll);

        ImageIcon icoVolver = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        btnVolver.setIcon(icoVolver);
        btnVolver.setHorizontalTextPosition(SwingConstants.RIGHT);

        btnActualizar.setBounds(300, 415, 120, 30);
        btnActualizar.addActionListener((e) -> evento_actualizar());
        add(btnActualizar);

        btnVolver.setBounds(450, 415, 170, 30);
        btnVolver.addActionListener((e) -> evento_volver());
        add(btnVolver);
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        ArrayList<DocenteHV> lista = GestorDocentes.getInstancia().getListaDocentes();
        if (lista.isEmpty()) {
            Dialogo.mostrarInfo(this, "No hay docentes registrados aun.", "Lista vacia");
            return;
        }
        for (DocenteHV d : lista) {
            modeloTabla.addRow(new Object[]{
                d.getCedula(), d.getNombreCompleto(), d.getCorreoInstitucional(),
                d.getUniversidad(), d.getNivelFormacion(), d.getEstadoLaboral(),
                d.getTipoVinculacion(), d.getDedicacion(),
                d.getAniosExperiencia() + " años", d.getModalidadesTexto()
            });
        }
    }

    private void evento_actualizar() { cargarTabla(); }

    private void evento_volver() {
        setVisible(false);
        dispose();
        padre.setVisible(true);
    }
}
