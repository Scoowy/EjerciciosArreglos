/*
 * Dada una lista L de n X m elementos, diseñar un programa que calcule
 * la suma de números pares e impares contenidos en ella.
 */
package ejercicios;

import java.util.Scanner;

public class Ejercicio8 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matriz;

        System.out.printf("Ingrese el numero de filas: ");
        int filas = teclado.nextInt();
        System.out.printf("Ingrese el numero de columnas: ");
        int columnas = teclado.nextInt();
        matriz = new int[filas][columnas];

        ingresarElementos(matriz);
        calcularParImpar(matriz);
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

    private static void calcularParImpar(int[][] matriz) {
        int sumPar = 0;
        int sumImpar = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if ((matriz[i][j] % 2) == 0) {
                    sumPar += matriz[i][j];
                } else {
                    sumImpar += matriz[i][j];
                }
            }
        }
        System.out.printf("Suma (Pares): %d\nSuma (Impares): %d\n", sumPar, sumImpar);
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
