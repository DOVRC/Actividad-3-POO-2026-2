package Notas;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Interfaz grafica para ingresar cinco notas y mostrar promedio,
 * desviacion estandar, nota mayor y nota menor.
 * Incluye las validaciones de los ejercicios propuestos (p. 494):
 * alerta si falta una nota o si un dato no es numerico.
 * Mejora documentada: Limpiar tambien restablece las etiquetas de resultado.
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5;
    private JLabel promedio, desviacion, mayor, menor;
    private JTextField campoNota1, campoNota2, campoNota3, campoNota4, campoNota5;
    private JButton calcular, limpiar;

    public VentanaPrincipal() {
        inicio();
        setTitle("Notas");
        setSize(320, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicio() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        int etiquetaX = 24;
        int campoX = 110;
        int campoAncho = 170;
        int filaAlto = 28;
        int y = 24;

        nota1 = new JLabel("Nota 1:");
        nota1.setBounds(etiquetaX, y, 80, 23);
        campoNota1 = new JTextField();
        campoNota1.setBounds(campoX, y, campoAncho, 23);
        y += filaAlto;

        nota2 = new JLabel("Nota 2:");
        nota2.setBounds(etiquetaX, y, 80, 23);
        campoNota2 = new JTextField();
        campoNota2.setBounds(campoX, y, campoAncho, 23);
        y += filaAlto;

        nota3 = new JLabel("Nota 3:");
        nota3.setBounds(etiquetaX, y, 80, 23);
        campoNota3 = new JTextField();
        campoNota3.setBounds(campoX, y, campoAncho, 23);
        y += filaAlto;

        nota4 = new JLabel("Nota 4:");
        nota4.setBounds(etiquetaX, y, 80, 23);
        campoNota4 = new JTextField();
        campoNota4.setBounds(campoX, y, campoAncho, 23);
        y += filaAlto;

        nota5 = new JLabel("Nota 5:");
        nota5.setBounds(etiquetaX, y, 80, 23);
        campoNota5 = new JTextField();
        campoNota5.setBounds(campoX, y, campoAncho, 23);
        y += filaAlto + 8;

        calcular = new JButton("Calcular");
        calcular.setBounds(etiquetaX, y, 110, 28);
        calcular.addActionListener(this);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(etiquetaX + 126, y, 110, 28);
        limpiar.addActionListener(this);
        y += filaAlto + 16;

        promedio = new JLabel("Promedio = ");
        promedio.setBounds(etiquetaX, y, 270, 23);
        y += filaAlto;

        desviacion = new JLabel("Desviacion = ");
        desviacion.setBounds(etiquetaX, y, 270, 23);
        y += filaAlto;

        mayor = new JLabel("Nota mayor = ");
        mayor.setBounds(etiquetaX, y, 270, 23);
        y += filaAlto;

        menor = new JLabel("Nota menor = ");
        menor.setBounds(etiquetaX, y, 270, 23);

        contenedor.add(nota1);
        contenedor.add(campoNota1);
        contenedor.add(nota2);
        contenedor.add(campoNota2);
        contenedor.add(nota3);
        contenedor.add(campoNota3);
        contenedor.add(nota4);
        contenedor.add(campoNota4);
        contenedor.add(nota5);
        contenedor.add(campoNota5);
        contenedor.add(calcular);
        contenedor.add(limpiar);
        contenedor.add(promedio);
        contenedor.add(desviacion);
        contenedor.add(mayor);
        contenedor.add(menor);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == calcular) {
            calcularNotas();
        }
        if (evento.getSource() == limpiar) {
            limpiarCampos();
        }
    }

    private void calcularNotas() {
        // Evita que queden resultados de un calculo previo si la validacion falla
        restablecerResultados();

        JTextField[] campos = {
            campoNota1, campoNota2, campoNota3, campoNota4, campoNota5
        };

        for (int i = 0; i < campos.length; i++) {
            String texto = campos[i].getText().trim();
            if (texto.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debe ingresar las cinco notas. Falta la nota " + (i + 1) + ".",
                        "Campo vacio",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
        }

        Notas notas = new Notas();
        for (int i = 0; i < campos.length; i++) {
            String texto = campos[i].getText().trim();
            try {
                double valor = Double.parseDouble(texto);
                if (!Double.isFinite(valor)) {
                    JOptionPane.showMessageDialog(
                            this,
                            "El valor de la nota " + (i + 1) + " no es numerico.",
                            "Dato no numerico",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                notas.listaNotas[i] = valor;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        this,
                        "El valor de la nota " + (i + 1) + " no es numerico.",
                        "Dato no numerico",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        double valorPromedio = notas.calcularPromedio();
        double valorDesviacion = notas.calcularDesviacion();
        double valorMayor = notas.calcularMayor();
        double valorMenor = notas.calcularMenor();

        promedio.setText("Promedio = " + String.format("%.2f", valorPromedio));
        desviacion.setText("Desviacion estandar = " + String.format("%.2f", valorDesviacion));
        mayor.setText("Nota mayor = " + String.valueOf(valorMayor));
        menor.setText("Nota menor = " + String.valueOf(valorMenor));
    }

    private void limpiarCampos() {
        campoNota1.setText("");
        campoNota2.setText("");
        campoNota3.setText("");
        campoNota4.setText("");
        campoNota5.setText("");
        restablecerResultados();
    }

    private void restablecerResultados() {
        promedio.setText("Promedio = ");
        desviacion.setText("Desviacion = ");
        mayor.setText("Nota mayor = ");
        menor.setText("Nota menor = ");
    }
}
