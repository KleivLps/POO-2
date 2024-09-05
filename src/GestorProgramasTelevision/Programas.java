package GestorProgramasTelevision;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.HashSet;

public class Programas {
    private String nombre;
    private String descripcion;
    private ZonedDateTime horaInicioUTC;
    private ZonedDateTime horaFinUTC;
    private Duration duracion;

    public Programas(String nombre, String descripcion, ZonedDateTime horaInicioUTC, int duracionMinutos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horaInicioUTC = horaInicioUTC;
        this.duracion = Duration.ofMinutes(duracionMinutos);
        this.horaFinUTC = horaInicioUTC.plus(duracion);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ZonedDateTime getHoraInicioUTC() {
        return horaInicioUTC;
    }

    public ZonedDateTime getHoraFinUTC() {
        return horaFinUTC;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public void mostrarHorariosEnZonas(Set<ZoneId> zonas) {
        System.out.println("Horarios de emisión del programa '" + nombre + "':");
        for (ZoneId zona : zonas) {
            ZonedDateTime inicioZona = horaInicioUTC.withZoneSameInstant(zona);
            ZonedDateTime finZona = horaFinUTC.withZoneSameInstant(zona);
            System.out.println(zona + ": " + inicioZona + " - " + finZona);
        }
    }

    @Override
    public String toString() {
        return "Programa: " + nombre + " | Descripción: " + descripcion + " | Inicio: " + horaInicioUTC + " | Fin: " + horaFinUTC + " | Duración: " + duracion.toMinutes() + " minutos";
    }
}
