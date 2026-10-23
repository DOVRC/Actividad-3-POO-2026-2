package Figuras;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Ventana para calcular volumen y superficie de un cubo (propuesto).
 */
public class VentanaCubo extends JFrame implements ActionListener {

    private JTextField campoLado;
    private JLabel volumen;
    private JLabel superficie;
    private JButton calcular;

    public VentanaCubo() {
        inicio();
        setTitle("Cubo");
        setSize(520, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        JPanel formulario = new JPanel(new GridBagLayout());
        formulario.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 8));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 4, 6, 4);
        c.anchor = GridBagConstraints.WEST;

        c.gridx = 0;
        c.gridy = 0;
        formulario.add(new JLabel("Lado (cms):"), c);
        campoLado = new JTextField(12);
        c.gridx = 1;
        formulario.add(campoLado, c);

        calcular = new JButton("Calcular");
        calcular.addActionListener(this);
        c.gridx = 1;
        c.gridy = 1;
        formulario.add(calcular, c);

        volumen = new JLabel("Volumen (cm3): ");
        superficie = new JLabel("Superficie (cm2): ");
        volumen.setPreferredSize(new java.awt.Dimension(280, 22));
        superficie.setPreferredSize(new java.awt.Dimension(280, 22));
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        formulario.add(volumen, c);
        c.gridy = 3;
        formulario.add(superficie, c);

        JLabel imagen = CargadorImagen.crearEtiquetaFigura("cubo.png");
        imagen.setBorder(BorderFactory.createEmptyBorder(16, 8, 16, 16));

        setLayout(new BorderLayout());
        add(formulario, BorderLayout.CENTER);
        add(imagen, BorderLayout.EAST);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() != calcular) {
            return;
        }
        restablecerResultados();
        Double lado = UtilidadesEntrada.leerDimensionPositiva(this, campoLado, "Lado");
        if (lado == null) {
            return;
        }
        Cubo cubo = new Cubo(lado);
        mostrarResultados(cubo.getVolumen(), cubo.getSuperficie());
    }

    private void mostrarResultados(double vol, double sup) {
        if (!Double.isFinite(vol) || !Double.isFinite(sup)) {
            restablecerResultados();
            JOptionPane.showMessageDialog(
                    this,
                    "Las dimensiones producen un resultado fuera del rango numerico.",
                    "Resultado no finito",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        volumen.setText("Volumen (cm3): " + UtilidadesEntrada.formatearMedida(vol));
        superficie.setText("Superficie (cm2): " + UtilidadesEntrada.formatearMedida(sup));
    }

    private void restablecerResultados() {
        volumen.setText("Volumen (cm3): ");
        superficie.setText("Superficie (cm2): ");
    }
}
