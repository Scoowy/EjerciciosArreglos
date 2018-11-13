/*
 * Calcular la suma de los elementos de la diagonal principal de una matriz
 * de n X n.
 */
package ejercicios;

import java.util.Scanner;

public class Ejercicio4 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matriz;

        System.out.printf("Ingrese la dimension de la matriz cuadratica: ");
        int dim = teclado.nextInt();
        matriz = new int[dim][dim];

        ingresarElementos(matriz);
        System.out.printf("Suma de la diagonal principal: %d\n", calcularDiagonal(matriz));
    }

    private static int calcularDiagonal(int[][] matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i == j) {
                    suma += matriz[i][j];
                }
            }
        }
        return suma;
    }

    private static void ingresarElementos(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("Ingrese un numero en la posicion [%d:%d]: ", i, j);
                matriz[i][j] = teclado.nextInt();
            }
        }
        presentarMatriz(matriz);
    }

    private static void presentarMatriz(int[][] matriz) {
        String matrizFormato = "";

        System.out.println("\nMatriz:");
        for (int i = 0; i < matriz.length; i++) {
            String fila = "";
            for (int j = 0; j < matriz[i].length; j++) {
                if (j == matriz[i].length - 1) {
                    fila += String.format(" %3d ", matriz[i][j]);
                } else {
                    fila += String.format(" %3d |", matriz[i][j]);
                }
            }
            fila = String.format("\t[%s]", fila);
            matrizFormato += String.format("%s\n", fila);
        }
        System.out.println(matrizFormato);
    }
}
