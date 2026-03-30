package hojavida;

import javax.swing.*;
import java.awt.*;

public class Programadores extends JFrame {

    JFrame padre;
    JButton btnVolver = new JButton("Volver al Menu");

    public Programadores(JFrame padre) {
        super("Programadores - Hoja de Vida Docente");
        this.padre = padre;
        setSize(420, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        JLabel lblTitulo = new JLabel("Equipo de Desarrollo", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBounds(0, 12, 420, 25);
        add(lblTitulo);

        JSeparator sep = new JSeparator();
        sep.setBounds(20, 43, 380, 2);
        add(sep);

        agregarProgramador("Posada, Juan Jose",     "2463018-2724", "juan.posada.lodono@correounivalle.edu.co",  55);
        agregarProgramador("Vaca Bedoya, Santiago", "2463025-2724", "santiago.vaca@correounivalle.edu.co",      120);
        agregarProgramador("Londono, Juan Esteban", "2463027-2724", "juan.fori@correounivalle.edu.co",          185);

        JSeparator sep2 = new JSeparator();
        sep2.setBounds(20, 253, 380, 2);
        add(sep2);

        JLabel lblInfo = new JLabel(
                "750014C  |  Doc. Adrian Lasso C.  |  Univalle Buga  |  2026",
                SwingConstants.CENTER);
        lblInfo.setFont(new Font("Arial", Font.PLAIN, 10));
        lblInfo.setBounds(0, 258, 420, 16);
        add(lblInfo);

        ImageIcon icoVolver = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        btnVolver.setIcon(icoVolver);
        btnVolver.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnVolver.setBounds(120, 283, 180, 32);
        btnVolver.addActionListener((e) -> evento_volver());
        add(btnVolver);
    }

    private void agregarProgramador(String nombre, String codigo, String correo, int y) {
        ImageIcon iconoUsuario = new ImageIcon(getClass().getResource("/imagenes/usuario.png"));
        JLabel lblIcono = new JLabel(iconoUsuario);
        lblIcono.setBounds(20, y, 50, 50);
        add(lblIcono);

        JLabel lblNombre = new JLabel(nombre);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
        lblNombre.setBounds(80, y, 320, 18);
        add(lblNombre);

        JLabel lblCodigo = new JLabel("Codigo: " + codigo);
        lblCodigo.setFont(new Font("Arial", Font.PLAIN, 11));
        lblCodigo.setBounds(80, y + 20, 320, 16);
        add(lblCodigo);

        JLabel lblCorreo = new JLabel("Correo: " + correo);
        lblCorreo.setFont(new Font("Arial", Font.PLAIN, 11));
        lblCorreo.setBounds(80, y + 38, 320, 16);
        add(lblCorreo);

        JSeparator linea = new JSeparator();
        linea.setBounds(20, y + 58, 380, 1);
        add(linea);
    }

    private void evento_volver() {
        setVisible(false);
        dispose();
        padre.setVisible(true);
    }
}
