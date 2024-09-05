package JAVATIMEAPI;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class adivinarFecha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int año = random.nextInt(2024 - 1900) + 1900;
        int mes = random.nextInt(12) + 1 ;
        int dia = random.nextInt(28)+1;

        LocalDate fechaObjetivo = LocalDate.of(año, mes, dia);

        LocalDate intento;

        do {
            System.out.println("Adivina la fecha (yyyy-mm-dd");
            intento = LocalDate.parse(scanner.nextLine());

            if (intento.isBefore(fechaObjetivo)) {
                System.out.println("La fgecha es despues.");
            } else if (intento.isAfter(fechaObjetivo)) {
                System.out.println("La fecha es antes.");
            } else {
                System.out.println("¡Felicidades! Adivinaste la fecha. ");
            }
        } while (!intento.equals(fechaObjetivo));
    }
}
