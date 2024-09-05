package JAVATIMEAPI;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;
import java.util.Set;

public class zonaHoraria {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa la fecha y hora (yyyy-MM-ddTHH:mm): ");
        LocalDateTime fechaHora =LocalDateTime.parse(scanner.nextLine());

        Set<String> zonasHorarias = ZoneId.getAvailableZoneIds();

        for (String zona : zonasHorarias) {
            ZonedDateTime zonedDateTime = fechaHora.atZone(ZoneId.of(zona));
            System.out.println("Zona horaria: " +zona+ " - fecha y hora: " +zonedDateTime);
        }
    }
}
