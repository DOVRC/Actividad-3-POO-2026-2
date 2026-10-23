package Figuras;

import java.awt.Image;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Carga imagenes desde el classpath (resources) o desde resources/figuras relativo.
 */
final class CargadorImagen {

    private static final int ANCHO = 140;
    private static final int ALTO = 140;

    private CargadorImagen() {
    }

    static JLabel crearEtiquetaFigura(String nombreArchivo) {
        JLabel etiqueta = new JLabel();
        etiqueta.setHorizontalAlignment(JLabel.CENTER);
        ImageIcon icono = cargar(nombreArchivo);
        if (icono != null) {
            Image escalada = icono.getImage().getScaledInstance(ANCHO, ALTO, Image.SCALE_SMOOTH);
            etiqueta.setIcon(new ImageIcon(escalada));
        } else {
            etiqueta.setText("(Sin imagen: " + nombreArchivo + ")");
            System.err.println("No se pudo cargar la imagen: " + nombreArchivo);
        }
        return etiqueta;
    }

    private static ImageIcon cargar(String nombreArchivo) {
        String recurso = "figuras/" + nombreArchivo;
        URL url = CargadorImagen.class.getClassLoader().getResource(recurso);
        if (url != null) {
            return new ImageIcon(url);
        }
        Path ruta = Path.of("resources", "figuras", nombreArchivo);
        if (Files.isRegularFile(ruta)) {
            return new ImageIcon(ruta.toAbsolutePath().toString());
        }
        Path alternativa = Path.of("figuras", nombreArchivo);
        if (Files.isRegularFile(alternativa)) {
            return new ImageIcon(alternativa.toAbsolutePath().toString());
        }
        return null;
    }
}
