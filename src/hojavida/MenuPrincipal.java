package hojavida;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    JButton btnIngreso       = new JButton("Ingresar Docente");
    JButton btnListado       = new JButton("Listado General");
    JButton btnEstadisticas  = new JButton("Estadisticas");
    JButton btnProgramadores = new JButton("Programadores");

    public MenuPrincipal() {
        super("Hoja de Vida Docente - Menu Principal");
        setSize(480, 380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        JLabel lblTitulo = new JLabel("Hoja de Vida Docente", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setBounds(0, 20, 480, 30);
        add(lblTitulo);

        JLabel lblSubtitulo = new JLabel("Sistema de Registro - Colombia", SwingConstants.CENTER);
        lblSubtitulo.setFont(new Font("Arial", Font.PLAIN, 12));
        lblSubtitulo.setBounds(0, 55, 480, 20);
        add(lblSubtitulo);

        JSeparator sep = new JSeparator();
        sep.setBounds(30, 82, 420, 2);
        add(sep);

        btnIngreso.setBounds(90, 105, 300, 40);
        btnIngreso.setFont(new Font("Arial", Font.PLAIN, 14));
        btnIngreso.setIcon(new ImageIcon(getClass().getResource("/imagenes/docente.png")));
        btnIngreso.addActionListener((e) -> evento_ingreso());
        add(btnIngreso);

        btnListado.setBounds(90, 160, 300, 40);
        btnListado.setFont(new Font("Arial", Font.PLAIN, 14));
        btnListado.setIcon(new ImageIcon(getClass().getResource("/imagenes/listado.png")));
        btnListado.addActionListener((e) -> evento_listado());
        add(btnListado);

        btnEstadisticas.setBounds(90, 215, 300, 40);
        btnEstadisticas.setFont(new Font("Arial", Font.PLAIN, 14));
        btnEstadisticas.setIcon(new ImageIcon(getClass().getResource("/imagenes/estadisticas.png")));
        btnEstadisticas.addActionListener((e) -> evento_estadisticas());
        add(btnEstadisticas);

        btnProgramadores.setBounds(90, 270, 300, 40);
        btnProgramadores.setFont(new Font("Arial", Font.PLAIN, 14));
        btnProgramadores.setIcon(new ImageIcon(getClass().getResource("/imagenes/programadores.png")));
        btnProgramadores.addActionListener((e) -> evento_programadores());
        add(btnProgramadores);
    }

    private void evento_ingreso()      { setVisible(false); new IngresoDatos(this); }
    private void evento_listado()      { setVisible(false); new ListadoGeneral(this); }
    private void evento_estadisticas() { setVisible(false); new Estadisticas(this); }
    private void evento_programadores(){ setVisible(false); new Programadores(this); }
}
