/*
 * Una empresa tiene diez almacenes y desea un programa que lea sus ventas
 * mensuales, calcule la media de las ventas y obtener un listado de los
 * almacenes cuyas ventas mensuales son superiores a la media.
 */
package ejercicios;

import java.util.Scanner;

public class Ejercicio11 {

    public static void main(String[] args) {
        double[] ventasAlmacenes = new double[10];

        iniciarArreglo(ventasAlmacenes);
        System.out.printf("El promedio de ventas es: %.2f\n", promedio(ventasAlmacenes));
        almacenesValidos(ventasAlmacenes);
    }

    private static void iniciarArreglo(double[] arreglo) {
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < arreglo.length; i++) {
            System.out.printf("Ingrese el total de ventas del mes %d: ", i + 1);
            arreglo[i] = teclado.nextDouble();
        }
        presentarArreglo(arreglo, "Ventas por Almacén");
    }

    private static double promedio(double[] arreglo) {
        double promedio = 0;
        for (int i = 0; i < arreglo.length; i++) {
            promedio += arreglo[i];
        }
        return promedio /= arreglo.length;
    }

    private static void almacenesValidos(double[] arreglo) {
        double prom = promedio(arreglo);
        System.out.printf("\nListado de Almacenes con ventas\nsuperiores a la media:\n");
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] > prom) {
                System.out.printf("\tAlmacén %d\n", i + 1);
            }
        }
    }

    private static void presentarArreglo(double[] arreglo, String tipo) {
        String fila = "";
        for (int i = 0; i < arreglo.length; i++) {
            if (i == arreglo.length - 1) {
                fila += String.format(" %.2f ", arreglo[i]);
            } else {
                fila += String.format(" %.2f |", arreglo[i]);
            }
        }
        System.out.printf("\n%s:\n\t[%s]\n\n", tipo, fila);
    }
}
