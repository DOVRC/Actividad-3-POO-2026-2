package Notas;

import javax.swing.SwingUtilities;

/**
 * Punto de entrada del programa de operaciones sobre notas.
 */
public class Principal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
            miVentanaPrincipal.setVisible(true);
        });
    }
}
