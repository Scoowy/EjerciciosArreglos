/*
 * Se dispone de un arreglo de n elementos. Se desea diseñar un algoritmo que 
 * permita insertar el valor x en la posición k‐ésima de la lista, debiendo 
 * desplazarse los elementos hacia la derecha para dar lugar al nuevo
 * elemento y desechando el último elemento sobrante.
 */
package ejercicios;

import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] arreglo;

        System.out.printf("Ingrese el tamaño del arreglo: ");
        int tamanio = teclado.nextInt();
        arreglo = new int[tamanio];

        llenarArreglo(arreglo);

        System.out.printf("Ingrese la posicion en la que quiera insertar el numero: ");
        int pos = teclado.nextInt();
        System.out.printf("Ingrese el elemento a ingresar: ");
        int elemento = teclado.nextInt();

        insertarElemento(arreglo, pos, elemento);
    }

    private static void llenarArreglo(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random() * 500) + 1;
        }
        presentarArreglo(arreglo, "Arreglo A");
    }

    private static void insertarElemento(int[] arreglo, int pos, int elemento) {
        for (int i = arreglo.length - 1; i > pos; i--) {
            arreglo[i] = arreglo[i - 1];
        }
        arreglo[pos] = elemento;
        presentarArreglo(arreglo, "Arreglo A");
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
