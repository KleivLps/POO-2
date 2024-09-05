package JAVATIMEAPI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class diferenciaEntreFechas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("Ingresa la primera fecha (dd-MM-yyyy): ");
        LocalDate fecha1 = LocalDate.parse(scanner.nextLine(), formato);

        System.out.println("Ingresa la segunda fecha (dd-MM-yyyy): ");
        LocalDate fecha2 = LocalDate.parse(scanner.nextLine(), formato);

        long años = ChronoUnit.YEARS.between(fecha1, fecha2);
        long meses = ChronoUnit.MONTHS.between(fecha1, fecha2) % 12;
        long dias = ChronoUnit.DAYS.between(fecha1, fecha2) % 365;

        System.out.println("Diferencia: " + años + " años, " + meses + " meses y " + dias + " dias.");
    }
}
