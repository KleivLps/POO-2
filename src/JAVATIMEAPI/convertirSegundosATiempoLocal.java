package JAVATIMEAPI;

import java.time.LocalTime;
import java.util.Scanner;

public class convertirSegundosATiempoLocal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la cantidad de segundos: ");
        int segundos = scanner.nextInt();

        LocalTime tiempo = LocalTime.ofSecondOfDay(segundos);
        System.out.println("Hora correspondiente: " +tiempo);
    }
}
