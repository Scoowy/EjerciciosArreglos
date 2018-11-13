/*
 * Calcular el número de elementos negativos, cero y positivos de un vector
 * dado de n elementos.
 */
package ejercicios;

import java.util.Scanner;

public class Ejercicio2 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int[] vector;
        String[] nomConteos = {"Negativos", "Positivos", "0 (Ceros)"};
        int[] conteos = new int[nomConteos.length];

        System.out.printf("Ingrese el largo del vector: ");
        vector = new int[teclado.nextInt()];

        ingresarElementos(vector);
        presentarVector(vector, "Vector");
        contarElementos(vector, conteos);
        presentarConteo(nomConteos, conteos);
    }

    private static void ingresarElementos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("Ingree un numero en la posicion [%d]: ", i);
            vector[i] = teclado.nextInt();
        }
    }

    private static void contarElementos(int[] vector, int[] conteos) {
        for (int i = 0; i < conteos.length; i++) {
            conteos[i] = 0;
        }

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < 0) {
                conteos[0] += 1;
            } else if (vector[i] > 0) {
                conteos[1] += 1;
            } else {
                conteos[2] += 1;
            }
        }
    }

    private static void presentarVector(int[] vector, String tipo) {
        String fila = "";
        for (int i = 0; i < vector.length; i++) {
            if (i == vector.length - 1) {
                fila += String.format(" %3d ", vector[i]);
            } else {
                fila += String.format(" %3d |", vector[i]);
            }
        }
        System.out.printf("\n%s:\n\t[%s]\n\n", tipo, fila);
    }

    private static void presentarConteo(String[] nomConteos, int[] conteos) {
        System.out.println("==== CONTEO ====");
        for (int i = 0; i < nomConteos.length; i++) {
            System.out.printf("%s: %d\n", nomConteos[i], conteos[i]);
        }
    }
}
