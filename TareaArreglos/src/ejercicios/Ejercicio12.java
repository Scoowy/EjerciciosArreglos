/*
 * Se dispone de una lista de n nombres de alumnos. Escribir un programa
 * que solicite el nombre de un alumno y busque en la lista si el
 * nombre está o no.
 */
package ejercicios;

import java.util.Scanner;

public class Ejercicio12 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String[] alumnos = {"Luis", "Maria", "Juan", "Pepe", "Manuel", "Mikaela", "Lourdes", "Pedro", "Angela", "Luisa", "Carlos", "Rodrigo"};

        System.out.printf("Ingrese un nombre a buscar: ");
        String nombre = teclado.nextLine();

        if (existeNombre(alumnos, nombre)) {
            System.out.printf("El nombre %s SI se encuentra en la lista.\n", nombre);
        } else {
            System.out.printf("El nombre %s NO se encuentra en la lista.\n", nombre);
        }
    }

    private static boolean existeNombre(String[] alumnos, String nombre) {
        for (String alumno : alumnos) {
            if (alumno.equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}
