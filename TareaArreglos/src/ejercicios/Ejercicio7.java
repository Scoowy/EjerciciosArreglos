/*
 * Escribir un programa que permita calcular el cuadrado de los 100
 * primeros números enteros y a continuación escribir un arreglo que
 * contenga dichos resultados.
 */
package ejercicios;

public class Ejercicio7 {

    public static void main(String[] args) {
        calcularCuadrados();
    }

    private static void calcularCuadrados() {
        int[] cuadrados = new int[100];
        for (int i = 0; i < cuadrados.length; i++) {
            cuadrados[i] = (int) Math.pow(i + 1, 2);
        }
        presentarArreglo(cuadrados, "Cuadrados");
    }

    private static void presentarArreglo(int[] vector, String tipo) {
        String fila = "";
        for (int i = 0; i < vector.length; i++) {
            if (i == vector.length - 1) {
                fila += String.format(" %5d ", vector[i]);
            } else {
                fila += String.format(" %5d |", vector[i]);
            }
        }
        System.out.printf("\n%s:\n\t[%s]\n\n", tipo, fila);
    }
}
