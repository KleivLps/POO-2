package JAVATIMEAPI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class restarFecha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("DD-MM-YYYY");

        System.out.println("Ingresa la fecha (DD-MM-YYYY): ");
        String input = scanner.nextLine();

        LocalDate fecha = LocalDate.parse(input, formato);
        LocalDate nuevaFecha = fecha.minusDays(13). minusMonths(10).minusYears(1);

        System.out.println("Nueva fecha: " +nuevaFecha);
        System.out.println("Dia de la semana: " +nuevaFecha.getDayOfWeek());
    }
}
