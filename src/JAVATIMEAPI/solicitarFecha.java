package JAVATIMEAPI;

import java.time.LocalDate;
import java.util.Scanner;

public class solicitarFecha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dia: ");
        int dia = scanner.nextInt();

        System.out.println("Ingrese el mes: ");
        int mes = scanner.nextInt();

        System.out.println("Ingrese el año: ");
        int año = scanner.nextInt();

        LocalDate fecha = LocalDate.of(año, mes, dia);
        System.out.println("La fecha ingresada es: " +fecha);
    }
}
