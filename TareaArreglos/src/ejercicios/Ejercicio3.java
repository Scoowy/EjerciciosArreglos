/*
 * Escriba un programa que me permita almacenar en un arreglo B el factorial
 * de 10 números almacenados previamente en un arreglo A.
 */
package ejercicios;

public class Ejercicio3 {

    public static void main(String[] args) {
        int[] arregloA = {5, 7, 2, 6, 3};
        int[] arregloB = new int[arregloA.length];

        presentarVector(arregloA, "Arreglo A");
        calcularArregloB(arregloA, arregloB);
        presentarVector(arregloB, "Arreglo B (factorial de Arreglo A)");
    }

    private static void calcularArregloB(int[] arregloA, int[] arregloB) {
        for (int i = 0; i < arregloA.length; i++) {
            int factorial = 1;
            for (int j = factorial; j <= arregloA[i]; j++) {
                factorial *= j;
            }
            arregloB[i] = factorial;
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
        System.out.printf("\n%s:\n\t[%s]\n", tipo, fila);
    }
}
