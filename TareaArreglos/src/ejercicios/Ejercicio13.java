/*
 * Realice un programa que me permita realizar (según un menú presentado al usuario):
 *      a. La multiplicación de dos matrices bidimensionales.
 *      b. Suma de matrices. 
 *      c. Resta de matrices. 
 *      d. Multiplicación por un escalar 
 *      e. Traspuesta de una matriz 
 * (Considérese las restricciones necesarias para cada operación). 
 */
package ejercicios;

import java.util.Scanner;

public class Ejercicio13 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int escalar = 5;
        int[][] mA3x3 = {{4, 7, 9}, {5, 6, 2}, {8, 1, 3}};
        int[][] mB3x3 = {{5, 9, 4}, {1, 7, 3}, {8, 2, 6}};
        int[][] mC2x3 = {{8, 1, 9}, {4, 6, 2}};
        int[][] mD5x5 = {{5, 9, 10, 17, 2}, {7, 3, 12, 18, 20}, {25, 4, 8, 14, 6}, {8, 1, 22, 21, 11}, {14, 19, 15, 19, 24}};
        do {
            System.out.printf("\n\t=== MENU ===\n1 - Multiplicar matrices\n2 - Sumar matrices\n3 - Restar matrices\n4 - Calcular escalar\n5 - Transpuesta de una matriz\n6 - Salir\n\tIngrese su opcion: ");
            int elecc = teclado.nextInt();
            switch (elecc) {
                case 1:
                    int[][] mM3x3 = new int[mA3x3.length][mC2x3[0].length];
                    presentarMatriz(mA3x3, "A");
                    presentarMatriz(mC2x3, "B");
                    multiplicacionMatrices(mA3x3, mC2x3, mM3x3);
                    break;
                case 2:
                    int[][] mS3x3 = new int[mA3x3.length][mB3x3.length];
                    presentarMatriz(mA3x3, "A");
                    presentarMatriz(mB3x3, "B");
                    sumaOrestaMatrices(mA3x3, mB3x3, mS3x3, true);
                    break;
                case 3:
                    int[][] mR3x3 = new int[mA3x3.length][mB3x3.length];
                    presentarMatriz(mA3x3, "A");
                    presentarMatriz(mB3x3, "B");
                    sumaOrestaMatrices(mA3x3, mB3x3, mR3x3, false);
                    break;
                case 4:
                    int[][] mE2x3 = new int[mC2x3.length][mC2x3[0].length];
                    presentarMatriz(mC2x3, "A");
                    System.out.printf("Escalar: %d\n\n", escalar);
                    escalarMatriz(mC2x3, escalar);
                    break;
                case 5:
                    presentarMatriz(mD5x5, "A");
                    transpuestaInf(mD5x5);
                    break;
                default:
                    System.out.println("SALISTE!");
                    salir = true;
                    break;
            }
        } while (!salir);

    }

    private static void multiplicacionMatrices(int[][] m1, int[][] m2, int[][] m3) {
        int sum = 0;
        for (int i = 0; i < m1.length; i++) {
            for (int l = 0; l < m2[0].length; l++) {
                for (int j = 0; j < m2.length; j++) {
                    sum += m1[i][j] * m2[j][l];
                }
                m3[i][l] = sum;
                sum = 0;
            }
        }
        presentarMatriz(m3, "Multiplicar");
    }

    private static void sumaOrestaMatrices(int[][] m1, int[][] m2, int[][] m3, boolean suma) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (suma) {
                    m3[i][j] = m1[i][j] + m2[i][j];
                } else {
                    m3[i][j] = m1[i][j] - m2[i][j];
                }
            }
        }
        if (suma) {
            presentarMatriz(m3, "Suma");
        } else {
            presentarMatriz(m3, "Resta");
        }
    }

    private static void escalarMatriz(int[][] m1, int escalar) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                m1[i][j] = m1[i][j] * escalar;
            }
        }
        presentarMatriz(m1, "Escalar");
    }

    private static void transpuestaInf(int[][] m1) {
        int aux;
        for (int i = 1; i < m1.length; i++) {
            for (int j = 0; j < i; j++) {
                aux = m1[i][j];
                m1[i][j] = m1[j][i];
                m1[j][i] = aux;
            }
        }

        presentarMatriz(m1, "Transpuesta");
    }

    private static void presentarMatriz(int[][] m1, String msg) {
        System.out.printf("Matriz %s\n", msg);
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                System.out.printf("%5d", m1[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.println();
    }
}
