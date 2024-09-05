package JAVATIMEAPI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class modificarFecha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("DD-MM-YYYY");

        System.out.println("Ingresa la fecha (DD-MM-YYYY): ");
        String input = scanner.nextLine();

        LocalDate fecha = LocalDate.parse(input, formato);
        LocalDate nuevaFecha = fecha.plusDays(15).plusMonths(2).plusYears(3);

        System.out.println("Nueva fecha: " +nuevaFecha);
        System.out.println("Dia de la semana: " +nuevaFecha.getDayOfWeek());
    }
}
