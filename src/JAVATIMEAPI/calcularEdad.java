package JAVATIMEAPI;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class calcularEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa tu fecha de nacimiento (yyyy-MM-dd): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());

        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        System.out.println("Tienes "+ edad + " años. ");
    }
}
