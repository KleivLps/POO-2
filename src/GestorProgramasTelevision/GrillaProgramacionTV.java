package GestorProgramasTelevision;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;

public class GrillaProgramacionTV {
    private List<Programas> programas = new ArrayList<>();

    public void crearPrograma(String nombre, String descripcion, ZonedDateTime horaInicioUTC, int duracionMinutos) {
        ZonedDateTime horaFinPropuesta = horaInicioUTC.plusMinutes(duracionMinutos);

        if (!haySuperposicion(horaInicioUTC, horaFinPropuesta)) {
            Programas programa = new Programas(nombre, descripcion, horaInicioUTC, duracionMinutos);
            programas.add(programa);
            programas.sort(Comparator.comparing(Programas::getHoraInicioUTC));
            System.out.println("Programa creado: " + programa);
        } else {
            System.out.println("Conflicto de horarios detectado. Estos son los intervalos disponibles:");
            mostrarIntervalosDisponibles();
        }
    }

    public void verProgramas() {
        if (programas.isEmpty()) {
            System.out.println("No hay programas en la grilla.");
        } else {
            for (Programas programa : programas) {
                System.out.println(programa);
            }
        }
    }

    public void mostrarHorariosEnZonas(int idPrograma, Set<ZoneId> zonas) {
        if (idPrograma >= 0 && idPrograma < programas.size()) {
            programas.get(idPrograma).mostrarHorariosEnZonas(zonas);
        } else {
            System.out.println("Programa no encontrado.");
        }
    }

    private boolean haySuperposicion(ZonedDateTime inicio, ZonedDateTime fin) {
        for (Programas programa : programas) {
            if (inicio.isBefore(programa.getHoraFinUTC()) && fin.isAfter(programa.getHoraInicioUTC())) {
                return true;
            }
        }
        return false;
    }

    private void mostrarIntervalosDisponibles() {
        ZonedDateTime ultimoFin = ZonedDateTime.now(ZoneId.of("UTC"));
        for (Programas programa : programas) {
            if (ultimoFin.isBefore(programa.getHoraInicioUTC())) {
                System.out.println("Disponible desde: " + ultimoFin + " hasta: " + programa.getHoraInicioUTC());
            }
            ultimoFin = programa.getHoraFinUTC();
        }
        System.out.println("Disponible desde: " + ultimoFin + " en adelante.");
    }

    public static void main(String[] args) {
        GrillaProgramacionTV gestor = new GrillaProgramacionTV();
        Scanner scanner = new Scanner(System.in);

        Set<ZoneId> zonas = Set.of(
                ZoneId.of("America/Lima"),
                ZoneId.of("America/Sao_Paulo"),
                ZoneId.of("America/Bogota"),
                ZoneId.of("America/New_York"),
                ZoneId.of("America/Los_Angeles"),
                ZoneId.of("Europe/Madrid"),
                ZoneId.of("Europe/Berlin"),
                ZoneId.of("Africa/Johannesburg"),
                ZoneId.of("Asia/Jerusalem"),
                ZoneId.of("Asia/Hong_Kong"),
                ZoneId.of("Asia/Tokyo"),
                ZoneId.of("Australia/Sydney"),
                ZoneId.of("Pacific/Auckland")
        );

        int opcion;
        do {
            System.out.println("\n--- Gestor de Grilla de Programas ---");
            System.out.println("1. Crear programa");
            System.out.println("2. Ver programas");
            System.out.println("3. Ver horarios en zonas horarias");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el nombre del programa: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingresa la descripción del programa: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingresa la hora de inicio en UTC (yyyy-MM-ddTHH:mm): ");
                    ZonedDateTime horaInicioUTC = ZonedDateTime.parse(scanner.nextLine() + "Z[UTC]");
                    System.out.print("Ingresa la duración del programa en minutos: ");
                    int duracionMinutos = scanner.nextInt();
                    gestor.crearPrograma(nombre, descripcion, horaInicioUTC, duracionMinutos);
                    break;
                case 2:
                    gestor.verProgramas();
                    break;
                case 3:
                    System.out.print("Ingresa el ID del programa (0 para el primero, 1 para el segundo, etc.): ");
                    int idPrograma = scanner.nextInt();
                    gestor.mostrarHorariosEnZonas(idPrograma, zonas);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 4.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}
