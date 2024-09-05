package JAVATIMEAPI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class formatoFecha {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("DD/MM/YYYY");

        System.out.println("Ingresa la fecha (dd/mm/yyyy): ");
        String input = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(input, formato);
        System.out.println("La fecha ingresada es: " +fecha);
    }
}
