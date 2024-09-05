package JAVATIMEAPI;

import java.time.LocalDate;
import java.util.Scanner;

public class verificarAñoBisiesto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("IOngresa el año: ");
        int año = scanner.nextInt();

        boolean esBisiesto = LocalDate.of(año, 1, 1).isLeapYear();
        System.out.println("¿El año " + año + " es bisiesto " + (esBisiesto ? "SI":"NO"));
    }
}
