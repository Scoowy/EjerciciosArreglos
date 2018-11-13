/*
 * Se dispone de un arreglo T de n números diferentes de 0, (puede ser llenada
 * por un procedimiento que genere números aleatorios distintos de cero);
 * crear un nuevo arreglo en el que todos sus elementos resulten de dividir
 * los elementos del arreglo T por el elemento T[i], siendo i un valor
 * leído por teclado.
 */
package ejercicios;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] arreglo = new int[10];
        llenarArreglo(arreglo);
        presentarArreglo(arreglo, "Arreglo T");
        System.out.printf("Ingrese el numero por el cual quiera dividir\ntodos los numeros del arreglo T: ");
        int n = teclado.nextInt();
        calcularDivision(arreglo, n);
    }

    private static void llenarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 500) + 1;
        }
    }

    private static void calcularDivision(int[] arreglo, int numero) {
        double[] arregloDiv = new double[arreglo.length];
        String fila = "";
        String tipo = "Arreglo T[i] (Arreglo T dividido por n numero)";
        for (int i = 0; i < arreglo.length; i++) {
            arregloDiv[i] = (double) arreglo[i] / numero;
            if (i == arreglo.length - 1) {
                fila += String.format(" %.3f ", arregloDiv[i]);
            } else {
                fila += String.format(" %.3f |", arregloDiv[i]);
            }
        }
        System.out.printf("\n%s:\n\t[%s]\n\n", tipo, fila);
    }

    private static void presentarArreglo(int[] vector, String tipo) {
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
}
