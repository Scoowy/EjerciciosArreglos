/*
 * Leer una matriz de n X m elementos y calcular la suma de cada una de sus
 * filas y columnas, dejando dichos resultados en dos vectores,
 * uno de la suma de filas y otro de columnas.
 */
package ejercicios;

import java.util.Scanner;

public class Ejercicio1 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int[] filas;
        int[] columnas;
        int[][] matriz;

        System.out.printf("Ingrese el numero de filas de la matriz: ");
        filas = new int[teclado.nextInt()];
        System.out.printf("Ingrese el numero de columnas de la matriz: ");
        columnas = new int[teclado.nextInt()];

        matriz = new int[filas.length][columnas.length];
        ingresarElementos(matriz);
        presentarMatriz(matriz);

        System.out.println("==== SUMAS ====");
        sumarFilas(matriz, filas);
        sumarColumnas(matriz, columnas);
    }

    private static void ingresarElementos(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("Ingrese un numero en la posicion [%d:%d]: ", i, j);
                matriz[i][j] = teclado.nextInt();
            }
        }
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

    private static void sumarFilas(int[][] matriz, int[] filas) {
        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
            filas[i] = suma;
        }
        presentarSuma(filas, "Filas");
    }

    private static void sumarColumnas(int[][] matriz, int[] columnas) {
        for (int i = 0; i < columnas.length; i++) {
            columnas[i] = 0;
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                columnas[j] += matriz[i][j];
            }
        }
        presentarSuma(columnas, "Columnas");
    }

    private static void presentarSuma(int[] lista, String tipo) {
        String fila = "";
        for (int i = 0; i < lista.length; i++) {
            if (i == lista.length - 1) {
                fila += String.format(" %3d ", lista[i]);
            } else {
                fila += String.format(" %3d |", lista[i]);
            }
        }
        System.out.printf("%s:\n\t[%s]\n\n", tipo, fila);
    }
}
