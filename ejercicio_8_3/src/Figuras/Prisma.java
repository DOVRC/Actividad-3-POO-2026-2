package Figuras;

/**
 * Prisma rectangular recto (ejercicio propuesto p. 517).
 * Eleccion de implementacion: el libro no especifica el tipo de prisma.
 */
public class Prisma extends FiguraGeometrica {

    private double largo;
    private double ancho;
    private double altura;

    public Prisma(double largo, double ancho, double altura) {
        this.largo = largo;
        this.ancho = ancho;
        this.altura = altura;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        return largo * ancho * altura;
    }

    public double calcularSuperficie() {
        return 2.0 * (largo * ancho + largo * altura + ancho * altura);
    }
}
