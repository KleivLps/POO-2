package JAVATIMEAPI;

import java.time.LocalTime;
import java.util.Scanner;

public class ajustarHora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la hora (HH:MM:SS): ");
        LocalTime hora = LocalTime.parse(scanner.nextLine());

        LocalTime horaAjustada = hora.plusSeconds(1).withNano(0).withSecond(0);
        System.out.println("Hora ajustada: " +horaAjustada);
}
}
