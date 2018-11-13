/*
 * Se desea realizar un programa que permita controlar las reservas de
 * plazas de un vuelo Quito‐Loja, de acuerdo con las siguientes normas
 * de la compañía aérea.
 *      a. Número de plazas del avión: 100.
 *      b. Plazas numeradas del 1 al 30: fumadores.
 *      c. Plazas numeradas del 31 al 100: no fumadores.
 *
 * Se desea realizar la reserva a petición del pasajero y cerrar la reserva
 * cuando no haya plazas libres o el avión esté próximo a despegar. 
 * Como ampliación de este algoritmo, considere la opción de anulaciones
 * imprevistas de reservas.
 * 
 * (Considere la utilización de un menú por pantalla para representar cada
 * uno de los estados).
 */
package ejercicios;

import java.util.Scanner;

public class Ejercicio9 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        String[] asientos = new String[100];
        String[] pasajeros = new String[asientos.length];
//        boolean lleno = false;
        boolean terminar = false;
        iniciarAsientos(asientos);

        // For para probar 98 asientos llenos
        //for (int i = 0; i < asientos.length - 2; i++) {
        //    asientos[i] = "#";
        //}
        while (!terminar) {
            presenatarAsientos(asientos, "Estado actual");
            switch (menu(avionLleno(asientos))) {
                case 1:
                    reservar(asientos, pasajeros);
                    break;
                case 2:
                    anular(asientos, pasajeros);
                    break;
                case 3:
                    break;
                case 4:
                    terminar = true;
                    break;
            }
        }

    }

    private static void iniciarAsientos(String[] asientos) {
        for (int i = 0; i < asientos.length; i++) {
            asientos[i] = " ";
        }
    }

    private static int menu(boolean lleno) {
        int opcion = 0;
        int op1 = 1;
        if (lleno) {
            System.out.printf("Acciones:\n\tx - Realizar *** ******* (Avion lleno)\n\t2 - Anular reserva\n\t3 - Presentar estado actual de los asientos\n\t4 - Salir\n");
            op1 = 2;
        } else {
            System.out.printf("Acciones:\n\t1 - Realizar una reserva\n\t2 - Anular reserva\n\t3 - Presentar estado actual de los asientos\n\t4 - Salir\n");
        }
        do {
            System.out.printf("Opcion: ");
            opcion = teclado.nextInt();
        } while (opcion < op1 || opcion > 4);

        return opcion;
    }

    private static void reservar(String[] asientos, String[] pasajeros) {
        int asiento = 0;
        String nombre;
        boolean correcto = false;

        teclado.nextLine();

        System.out.printf("Nombre del pasajero: ");
        nombre = teclado.nextLine();

        while (!correcto) {
            System.out.printf("Nro de asiento: ");
            asiento = teclado.nextInt();

            if (asientoLibre(asientos, asiento)) {
                correcto = true;
            } else {
                System.out.printf("Ingrese un asiento vacio...\n");
            }
        }

        asientos[asiento - 1] = "#";
        pasajeros[asiento - 1] = nombre;

        System.out.printf("Reserva correcta!\n");
    }

    private static void anular(String[] asientos, String[] pasajeros) {
        int asiento = 0;
        do {
            System.out.printf("Ingrese el nro de asiento para anular la reserva: ");
            asiento = teclado.nextInt();
        } while (asientoLibre(asientos, asiento));

        System.out.printf("La reserva a nombre de %s del asiento Nro %d, sera anulada...\nEsta seguro de querer continuar?\n", pasajeros[asiento - 1], asiento);
        System.out.printf("\t1 - CONTINUAR (La reserva sera anulada)\n\t2 - Volver al menu\n");
        int confirmacion = teclado.nextInt();
        if (confirmacion == 1) {
            asientos[asiento - 1] = " ";
            pasajeros[asiento - 1] = "";

            System.out.printf("Anulacion de reserva correcta...\n");
        } else {
            System.out.printf("Anulacion de reserva cancelada...\n");
        }
    }

    private static boolean asientoLibre(String[] asientos, int asiento) {
        return " ".equals(asientos[asiento - 1]);
    }

    private static boolean avionLleno(String[] asientos) {
        for (String asiento : asientos) {
            if (" ".equals(asiento)) {
                return false;
            }
        }
        return true;
    }

    private static void presenatarAsientos(String[] asientos, String titulo) {
        int minAsiento = 1;
        int maxAsiento = 5;
        String rango;
        String puestos = "";
        if (!"".equals(titulo)) {
            titulo = String.format("\n\t====== %s ======\n\n", titulo);
        }
        String presentacion = String.format("%sAsientos disponibles:\n\t[ ] - Vacio\t[#]Ocupado\nFumadores:\n", titulo);

        // Impresion de los asientos 1 al 5
        for (int i = 0; i < maxAsiento; i++) {
            if ((i == 1) || (i == 4)) {
                puestos += String.format(" ");
            }
            puestos += String.format("[%s]", asientos[i]);
        }
        rango = String.format("%3d - %-3d\t", minAsiento, maxAsiento);
        puestos = String.format("%6s%s", " ", puestos);
        presentacion += String.format("%s%s\n", rango, puestos);

        minAsiento = maxAsiento + 1;
        maxAsiento += 7;
        puestos = "";

        // Impresion de los asientos 6 a 12
        for (int i = minAsiento - 1; i < maxAsiento; i++) {
            if ((i == 7) || (i == 10)) {
                puestos += String.format(" ");
            }
            puestos += String.format("[%s]", asientos[i]);
        }
        rango = String.format("%3d - %-3d\t", minAsiento, maxAsiento);
        puestos = String.format("%3s%s", " ", puestos);
        presentacion += String.format("%s%s\n", rango, puestos);
        minAsiento = maxAsiento + 1;
        maxAsiento += 9;
        puestos = "";

        // Impresion de los asientos 13 a 93
        for (int i = 0; i < 9; i++) {
            int cont = 0;
            for (int j = minAsiento - 1; j < maxAsiento; j++) {
                if (cont == 3) {
                    puestos += String.format(" ");
                    cont = 0;
                }

                puestos += String.format("[%s]", asientos[j]);
                cont += 1;

                if (j == 29) {
                    puestos += String.format("\n\nNo Fumadores:");
                }
            }

            rango = String.format("%3d - %-3d\t", minAsiento, maxAsiento);
            presentacion += String.format("%s%s\n", rango, puestos);
            minAsiento = maxAsiento + 1;
            maxAsiento += 9;
            puestos = "";
        }

        // Impresion de los asientos 94 a 100
        for (int i = minAsiento - 1; i < maxAsiento - 2; i++) {
            if ((i == 95) || (i == 98)) {
                puestos += String.format(" ");
            }
            puestos += String.format("[%s]", asientos[i]);
        }
        rango = String.format("%3d - %-3d\t", minAsiento, maxAsiento - 2);
        puestos = String.format("%3s%s", " ", puestos);
        presentacion += String.format("%s%s\n", rango, puestos);

        System.out.println(presentacion);
    }

}
