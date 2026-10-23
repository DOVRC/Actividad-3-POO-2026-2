package Figuras;

/**
 * Esfera: radio. Volumen con 4.0/3.0 (correccion del 1.333 del libro, p. 500).
 */
public class Esfera extends FiguraGeometrica {

    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(this.radio, 3.0);
    }

    public double calcularSuperficie() {
        return 4.0 * Math.PI * Math.pow(this.radio, 2.0);
    }
}
