package JAVATIMEAPI;

import java.time.LocalTime;

public class mitadHastaMedianoche {
    public static void main(String[] args) {
        LocalTime hora = LocalTime.of(12,0);

        LocalTime medianoche = LocalTime.MIDNIGHT;
        long segundosHastaMedianoche = java.time.Duration.between(hora, medianoche).getSeconds();
        LocalTime mitadTiempo = hora.plusSeconds(segundosHastaMedianoche / 2);

        System.out.println("Mitad del tiempo hasta medianoche: " +mitadTiempo);
    }
}
