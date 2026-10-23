package Notas;

/**
 * Define un array de notas numericas de tipo double y calcula
 * promedio, desviacion estandar, mayor y menor.
 * Basado en el ejercicio 8.2 del libro (Bermon Angarita).
 * Correccion: calcularPromedio recorre desde el indice 0 (el libro
 * iniciaba en 1 y omitia la primera nota, p. 485).
 */
public class Notas {
    double[] listaNotas;

    public Notas() {
        listaNotas = new double[5];
    }

    /**
     * Calcula el promedio de las cinco notas.
     * @return promedio de las notas
     */
    double calcularPromedio() {
        double suma = 0;
        for (int i = 0; i < listaNotas.length; i++) {
            suma = suma + listaNotas[i];
        }
        return (suma / listaNotas.length);
    }

    /**
     * Calcula la desviacion estandar poblacional del array de notas
     * (division por n = 5, como en la solucion del libro).
     * @return desviacion estandar
     */
    double calcularDesviacion() {
        double prom = calcularPromedio();
        double suma = 0;
        for (int i = 0; i < listaNotas.length; i++) {
            suma += Math.pow(listaNotas[i] - prom, 2);
        }
        return Math.sqrt(suma / listaNotas.length);
    }

    /**
     * @return la nota menor del array
     */
    double calcularMenor() {
        double menor = listaNotas[0];
        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] < menor) {
                menor = listaNotas[i];
            }
        }
        return menor;
    }

    /**
     * @return la nota mayor del array
     */
    double calcularMayor() {
        double mayor = listaNotas[0];
        for (int i = 0; i < listaNotas.length; i++) {
            if (listaNotas[i] > mayor) {
                mayor = listaNotas[i];
            }
        }
        return mayor;
    }
}
