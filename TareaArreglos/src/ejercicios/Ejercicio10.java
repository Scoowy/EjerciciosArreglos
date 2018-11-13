/*
 * Cada alumno de una clase de 20 estudiantes tiene notas correspondientes a 5
 * asignaturas diferentes, pudiendo no tener calificación en alguna asignatura.
 * A cada asignatura le corresponde un determinado coeficiente.
 * Escribir un programa que permita:
 *      a. Calcular la media de cada alumno
 *      b. Media general de la clase
 *      c. Media de la clase en cada asignatura
 *      d. Porcentaje de faltas (no presentado a examen)
 */
package ejercicios;

public class Ejercicio10 {

    static String[] estudiantes = new String[20];
    static double[] asignatura1 = new double[estudiantes.length];
    static double[] asignatura2 = new double[estudiantes.length];
    static double[] asignatura3 = new double[estudiantes.length];
    static double[] asignatura4 = new double[estudiantes.length];
    static double[] asignatura5 = new double[estudiantes.length];
    static double[] medias = new double[estudiantes.length];
    static double[] faltas = {0, 0, 0, 0, 0};

    public static void main(String[] args) {
        iniciarDatos();
        reporte();
    }

    private static void iniciarDatos() {
        for (int i = 0; i < estudiantes.length; i++) {
            estudiantes[i] = String.format("Est%d", i + 1);
            asignatura1[i] = nota();
            asignatura2[i] = nota();
            asignatura3[i] = nota();
            asignatura4[i] = nota();
            asignatura5[i] = nota();
        }
    }

    private static double nota() {
        double nota;
        if (falta()) {
            return -1;
        }
        nota = (double) (Math.random() * 20) + 1;
        return nota;
    }

    private static boolean falta() {
        int dado = (int) (Math.random() * 10) + 1;
        return dado <= 2;
    }

    private static void reporte() {
        String cabecera = String.format("\n%8s%8s%8s%8s%8s%8s%8s\n", "Alumno", "Asig 1", "Asig 2", "Asig 3", "Asig 4", "Asig 5", "Media");
        String fila;
        String reporteG = String.format("Reporte de estudiantes:\n%s", cabecera);
        for (int i = 0; i < estudiantes.length; i++) {
            double media = (asignatura1[i] + asignatura2[i] + asignatura3[i] + asignatura4[i] + asignatura5[i]) / 5;
            medias[i] = media;
            fila = String.format("%8s%8s%8s%8s%8s%8s%8.2f", estudiantes[i], valorStr(asignatura1[i]), valorStr(asignatura2[i]), valorStr(asignatura3[i]), valorStr(asignatura4[i]), valorStr(asignatura5[i]), media);
            reporteG += String.format("%s\n", fila);
        }
        System.out.println(reporteG);
        System.out.printf("Media General: %.2f\n\n", mediaGeneral());
        System.out.printf("Media Asig 1: %.2f\n", mediaAsig(asignatura1, 0));
        System.out.printf("Media Asig 2: %.2f\n", mediaAsig(asignatura2, 1));
        System.out.printf("Media Asig 3: %.2f\n", mediaAsig(asignatura3, 2));
        System.out.printf("Media Asig 4: %.2f\n", mediaAsig(asignatura4, 3));
        System.out.printf("Media Asig 5: %.2f\n", mediaAsig(asignatura5, 4));

        System.out.printf("\nPorcentaje de faltas: %d%%\n", calcPorcentajeFaltas());
    }

    private static double mediaAsig(double[] asig, int numAsig) {
        double media = 0;
        for (int i = 0; i < asig.length; i++) {
            if (asig[i] >= 0) {
                media += asig[i];
            } else {
                faltas[numAsig] += 1;
            }
        }
        return media / asig.length;
    }

    private static double mediaGeneral() {
        double media = 0;
        for (int i = 0; i < medias.length; i++) {
            media += medias[i];
        }
        return media / medias.length;
    }

    private static int calcPorcentajeFaltas() {
        int numTotal = estudiantes.length * 5;
        int faltasTotal = 0;

        for (int i = 0; i < faltas.length; i++) {
            faltasTotal += faltas[i];
        }

        int porcentaje = (faltasTotal * 100) / numTotal;

        return porcentaje;
    }

    private static String valorStr(double valor) {
        String valorString;
        if (valor >= 0) {
            valorString = String.format("%.2f", valor);
        } else {
            valorString = "---";
        }

        return valorString;
    }
}
