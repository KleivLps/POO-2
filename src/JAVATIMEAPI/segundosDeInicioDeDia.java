package JAVATIMEAPI;

import java.time.LocalDate;
import java.time.LocalTime;

public class segundosDeInicioDeDia {

    public static void main(String[] args) {
        LocalTime horaActual = LocalTime.now();
        int segundosDesdeInicio = horaActual.toSecondOfDay();
        System.out.println("Segundos desde el inicio del dia: " +segundosDesdeInicio);
    }
}
