package hojavida;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("LookAndFeel no disponible.");
        }
        SwingUtilities.invokeLater(() -> new MenuPrincipal());
    }
}
