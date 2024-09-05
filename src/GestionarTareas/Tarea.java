package GestionarTareas;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tarea {
    private static int contadorId = 1;
    private int id;
    private String descripcion;
    private LocalDateTime tiempoInicio;
    private LocalDate fechaVencimiento;
    private LocalDateTime tiempoFinalizacion;
    private boolean finalizada;

    public Tarea(String descripcion, LocalDate fechaVencimiento) {
        this.id = contadorId++;
        this.descripcion = descripcion;
        this.tiempoInicio = LocalDateTime.now();
        this.fechaVencimiento = fechaVencimiento;
        this.finalizada = false;

    }
    public  int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getTiempoInicio() {
        return tiempoInicio;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public LocalDateTime getTiempoFinalizacion() {
        return tiempoFinalizacion;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void finalizarTarea() {
        this.tiempoFinalizacion = LocalDateTime.now();
        this.finalizada = true;
    }

    public long getDuracion() {
        if (finalizada) {
            return Duration.between(tiempoInicio, tiempoFinalizacion).toMinutes();
        }
        return 0;
    }
    public long getDiasRestantes() {
        return Duration.between(LocalDateTime.now(), fechaVencimiento.atStartOfDay()).toDays();
    }
@Override
    public String toString() {
        if (finalizada) {
            return "Tarea " + id + ": " +descripcion + " | Inicio: " + tiempoInicio + "| Fin: " +tiempoFinalizacion + "| Duracion: " +getDuracion() + " minutos.";
        } else {
            return "Tarea " + id + ": " +descripcion + " | Inicio: " + tiempoInicio + "| Vencimiento: " +tiempoFinalizacion + "| Dias Restantes: " +getDiasRestantes();
        }
    }
}
