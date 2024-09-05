package EVENTOSRANDOM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventosAstronomicos {
    public static LocalDate[] calcularProximasFechas(LocalDate ultimaFecha, int cicloAños, int cantidadEventos ) {
        List<LocalDate> fechas = new ArrayList<>();

        for (int i = 1; i <= cantidadEventos; i++) {
            fechas.add(ultimaFecha.plusYears(cicloAños * 1));
        }

        return fechas.toArray(new LocalDate[0]);

    }

    public static void main(String[] args) {
        LocalDate ultimaInvasionCigarras = LocalDate.of(2021, 6, 1);
        LocalDate[] proximasInvasionesCigarras = calcularProximasFechas(ultimaInvasionCigarras, 17, 5);
        System.out.println("Proximas invasiones de cigarras (ciclo de 17 años): ");
        for (LocalDate fecha : proximasInvasionesCigarras) {
            System.out.println(fecha);
        }

        LocalDate ultimaAparicionHalley = LocalDate.of(1986, 2, 9);
        LocalDate[] proximasAparicionesHalley = calcularProximasFechas(ultimaAparicionHalley, 76, 3 );
        System.out.println("\nProximas apariciones del cometa halley (ciclo de 76 años): ");
        for (LocalDate fecha : proximasAparicionesHalley) {
            System.out.println(fecha);
        }

        LocalDate[] proximosTransitosVenus = calcularTransitoVenus();
        System.out.println("\nProximos transitos de venus: ");
        for (LocalDate fecha : proximosTransitosVenus) {
            System.out.println(fecha);
        }
    }

    public static LocalDate[] calcularTransitoVenus() {
        List<LocalDate> fechas = new ArrayList<>();
        LocalDate ultimaFecha1 = LocalDate.of(2012, 6, 5);
        int[] ciclosVenus = {105, 8, 121, 8};

        for (int i = 0; i < 5; i++) {
            int ciclo = ciclosVenus[i % ciclosVenus.length];
            ultimaFecha1 = ultimaFecha1.plusYears(ciclo);
            fechas.add(ultimaFecha1);
        }

        return fechas.toArray(new LocalDate[0]);
    }
}
