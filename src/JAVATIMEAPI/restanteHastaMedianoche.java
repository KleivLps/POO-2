package JAVATIMEAPI;

import java.time.LocalTime;

public class restanteHastaMedianoche {

    public static void main(String[] args) {
        LocalTime horaActual = LocalTime.now();
        LocalTime medianoche = LocalTime.MIDNIGHT;

        long horasRestantes = java.time.Duration.between(horaActual, medianoche).toHours();
        long minutosRestantes = java.time.Duration.between(horaActual, medianoche).toMinutes() % 60;
        long segundosRestantes = java.time.Duration.between(horaActual, medianoche).getSeconds() % 60;

        System.out.println("Faltan " +horasRestantes+ " horas, " +minutosRestantes+ " minutos y " +segundosRestantes+ " segundos para la medianoche.");
    }
}
