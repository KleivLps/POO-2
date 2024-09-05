package JAVATIMEAPI;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class convertirATokio {
    public static ZonedDateTime convertirATokio(LocalDateTime fechaHora){
        return fechaHora.atZone(ZoneId.of("Asia/Tokyo"));
    }

    public static void main(String[] args) {
        LocalDateTime fechaHora = LocalDateTime.now();
        ZonedDateTime enTokio = convertirATokio(fechaHora);

        System.out.println("Fecha y hora en tokio: " + enTokio);
    }
}
