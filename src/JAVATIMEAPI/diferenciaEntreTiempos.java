package JAVATIMEAPI;

import java.time.LocalTime;
import java.util.Scanner;

public class diferenciaEntreTiempos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la primera hora (HH:mm:ss): ");
        LocalTime hora1 = LocalTime.parse(scanner.nextLine());

        System.out.println("Ingresa la segunda hora (HH:mm:ss): ");
        LocalTime hora2 = LocalTime.parse(scanner.nextLine());

        long diferenciaDeSegundos = java.time.Duration.between(hora1, hora2).getSeconds();
        System.out.println("Diferencia en segundos: " +diferenciaDeSegundos);
    }
}
