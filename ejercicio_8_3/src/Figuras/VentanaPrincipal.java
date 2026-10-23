package Figuras;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Menu principal con acceso a las cinco figuras geometricas.
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private JButton cilindro;
    private JButton esfera;
    private JButton piramide;
    private JButton cubo;
    private JButton prisma;

    public VentanaPrincipal() {
        inicio();
        setTitle("Figuras geometricas");
        setSize(420, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        JLabel titulo = new JLabel("Seleccione una figura", SwingConstants.CENTER);
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 14f));
        titulo.setBorder(BorderFactory.createEmptyBorder(16, 12, 8, 12));

        cilindro = new JButton("Cilindro");
        esfera = new JButton("Esfera");
        piramide = new JButton("Piramide");
        cubo = new JButton("Cubo");
        prisma = new JButton("Prisma");

        cilindro.addActionListener(this);
        esfera.addActionListener(this);
        piramide.addActionListener(this);
        cubo.addActionListener(this);
        prisma.addActionListener(this);

        JPanel panelBotones = new JPanel(new GridLayout(3, 2, 12, 12));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(8, 24, 24, 24));
        panelBotones.add(cilindro);
        panelBotones.add(esfera);
        panelBotones.add(piramide);
        panelBotones.add(cubo);
        panelBotones.add(prisma);

        setLayout(new BorderLayout());
        add(titulo, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == cilindro) {
            new VentanaCilindro().setVisible(true);
        } else if (evento.getSource() == esfera) {
            new VentanaEsfera().setVisible(true);
        } else if (evento.getSource() == piramide) {
            new VentanaPiramide().setVisible(true);
        } else if (evento.getSource() == cubo) {
            new VentanaCubo().setVisible(true);
        } else if (evento.getSource() == prisma) {
            new VentanaPrisma().setVisible(true);
        }
    }
}
