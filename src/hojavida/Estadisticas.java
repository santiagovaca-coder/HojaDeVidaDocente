package hojavida;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class Estadisticas extends JFrame {

    JFrame padre;
    JTextArea areaEst1 = new JTextArea(6, 40);
    JTextArea areaEst2 = new JTextArea(4, 40);
    JTextArea areaEst3 = new JTextArea(4, 40);
    JButton btnCalcular = new JButton("Calcular Estadisticas");
    JButton btnVolver   = new JButton("Volver al Menu");

    public Estadisticas(JFrame padre) {
        super("Estadisticas - Hoja de Vida Docente");
        this.padre = padre;
        setSize(620, 580);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        crearGUI();
        setVisible(true);
    }

    private void crearGUI() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 15, 5, 15));

        JLabel lblTitulo = new JLabel("Estadisticas del Sistema", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(8, 0, 12, 0));
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelEstadisticas = new JPanel();
        panelEstadisticas.setLayout(new BoxLayout(panelEstadisticas, BoxLayout.Y_AXIS));

        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBorder(new TitledBorder("Estadistica 1 - Conteo por Nivel de Formacion"));
        areaEst1.setEditable(false);
        areaEst1.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panel1.add(new JScrollPane(areaEst1), BorderLayout.CENTER);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(new TitledBorder("Estadistica 2 - Promedio de Años de Experiencia"));
        areaEst2.setEditable(false);
        areaEst2.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panel2.add(new JScrollPane(areaEst2), BorderLayout.CENTER);

        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBorder(new TitledBorder("Estadistica 3 - Distribucion por Dedicacion"));
        areaEst3.setEditable(false);
        areaEst3.setFont(new Font("Monospaced", Font.PLAIN, 12));
        panel3.add(new JScrollPane(areaEst3), BorderLayout.CENTER);

        panelEstadisticas.add(panel1);
        panelEstadisticas.add(Box.createRigidArea(new Dimension(0, 8)));
        panelEstadisticas.add(panel2);
        panelEstadisticas.add(Box.createRigidArea(new Dimension(0, 8)));
        panelEstadisticas.add(panel3);

        panelPrincipal.add(new JScrollPane(panelEstadisticas), BorderLayout.CENTER);

        ImageIcon icoVolver = new ImageIcon(getClass().getResource("/imagenes/volver.png"));
        btnVolver.setIcon(icoVolver);
        btnVolver.setHorizontalTextPosition(SwingConstants.RIGHT);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        btnCalcular.addActionListener((e) -> evento_calcular());
        btnVolver.addActionListener((e) -> evento_volver());
        panelBotones.add(btnCalcular);
        panelBotones.add(btnVolver);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);
    }

    private void evento_calcular() {
        ArrayList<DocenteHV> lista = GestorDocentes.getInstancia().getListaDocentes();
        int total = lista.size();

        if (total == 0) {
            Dialogo.mostrarAdvertencia(this, "No hay docentes registrados.", "Sin datos");
            return;
        }

        String[] niveles = {"Tecnologia", "Pregrado / Licenciatura", "Especializacion",
                            "Maestria", "Doctorado", "Postdoctorado"};
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Total docentes: ").append(total).append("\n\n");
        for (String nivel : niveles) {
            int conteo = 0;
            for (DocenteHV d : lista) if (d.getNivelFormacion().equals(nivel)) conteo++;
            double pct = ((double) conteo / total) * 100;
            sb1.append(String.format("  %-30s : %2d  (%.1f%%)\n", nivel, conteo, pct));
        }
        areaEst1.setText(sb1.toString());

        int suma = 0, minA = Integer.MAX_VALUE, maxA = Integer.MIN_VALUE;
        for (DocenteHV d : lista) {
            int a = d.getAniosExperiencia();
            suma += a;
            if (a < minA) minA = a;
            if (a > maxA) maxA = a;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("Suma total de años de experiencia : %d\n", suma));
        sb2.append(String.format("Promedio de años de experiencia   : %.2f\n", (double) suma / total));
        sb2.append(String.format("Minimo de años de experiencia     : %d\n", minA));
        sb2.append(String.format("Maximo de años de experiencia     : %d\n", maxA));
        areaEst2.setText(sb2.toString());

        int tc = 0, mt = 0;
        for (DocenteHV d : lista) {
            if ("Tiempo Completo".equals(d.getDedicacion())) tc++; else mt++;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(String.format("Tiempo Completo : %d docente(s)  (%.1f%%)\n", tc, ((double)tc/total)*100));
        sb3.append(String.format("Medio Tiempo    : %d docente(s)  (%.1f%%)\n", mt, ((double)mt/total)*100));
        sb3.append(String.format("\nTotal analizado : %d\n", total));
        areaEst3.setText(sb3.toString());

        Dialogo.mostrarInfo(this, "Estadisticas calculadas correctamente.", "Listo");
    }

    private void evento_volver() {
        setVisible(false);
        dispose();
        padre.setVisible(true);
    }
}
