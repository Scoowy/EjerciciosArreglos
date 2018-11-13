/*
 * Diseñe un programa que permita encontrar el determinante de una matriz.
 */
package ejercicios;

public class Ejercicio16 {

    public static void main(String[] args) {
        int[][] mD4x4 = {{2, 3, 3, 6}, {2, 3, 6, 7}, {21, 82, 0, 3}, {2, 23, 1, 1}};

        presentarMatriz(mD4x4, "A");
        System.out.printf("La determinante es: %d\n", determinante(mD4x4));
    }

    private static int determinante(int[][] mA) {
        int dAi, sDi;
        int iAd = dAi = 1;
        int sId = sDi = 0;
        int j, l;

        for (int k = 0; k < mA.length; k++) {
            j = k;
            l = mA.length - 1;
            for (int i = 0; i < mA.length; i++) {
                iAd *= mA[j][i];
                dAi *= mA[j][l];
                if (j == mA.length - 1) {
                    j = 0;
                } else {
                    j++;
                    l--;
                }
            }
            sId += iAd;
            sDi += dAi;
        }
        return sId - sDi;
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
