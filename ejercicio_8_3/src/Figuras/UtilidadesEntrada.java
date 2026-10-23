package Figuras;

import java.awt.Component;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Validacion compartida de campos numericos positivos (estilo ejercicio 8.2).
 */
final class UtilidadesEntrada {

    private UtilidadesEntrada() {
    }

    /**
     * Lee un double finito y positivo desde un campo.
     * @return el valor, o null si hubo alerta y no se debe calcular
     */
    static Double leerDimensionPositiva(Component padre, JTextField campo, String nombreCampo) {
        String texto = campo.getText().trim();
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(
                    padre,
                    "Debe completar todos los campos. Falta: " + nombreCampo + ".",
                    "Campo vacio",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }
        try {
            double valor = Double.parseDouble(texto);
            if (!Double.isFinite(valor)) {
                JOptionPane.showMessageDialog(
                        padre,
                        "El valor de \"" + nombreCampo + "\" no es numerico.",
                        "Dato no numerico",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }
            if (valor <= 0) {
                JOptionPane.showMessageDialog(
                        padre,
                        "La dimension \"" + nombreCampo + "\" debe ser mayor que cero.",
                        "Dimension no positiva",
                        JOptionPane.ERROR_MESSAGE);
                return null;
            }
            return valor;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    padre,
                    "El valor de \"" + nombreCampo + "\" no es numerico.",
                    "Dato no numerico",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private static final Locale LOCALE_ES = Locale.forLanguageTag("es-ES");

    static String formatearMedida(double valor) {
        return String.format(LOCALE_ES, "%.2f", valor);
    }
}
