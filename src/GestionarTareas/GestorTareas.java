package GestionarTareas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GestorTareas {
    private List<Tarea> tareas = new ArrayList<>();

    public void crearTarea(String descripcion, LocalDate fechaVencimiento) {
        Tarea tarea = new Tarea(descripcion, fechaVencimiento);
        tareas.add(tarea);
        System.out.println("Tarea creada: " + tarea);
    }

    public void finalizarTarea(int id) {
        Tarea tarea = buscarTareaPorId(id);
        if (tarea != null && !tarea.isFinalizada()) {
            tarea.finalizarTarea();
            System.out.println("Tarea finalizada: " + tarea);
        } else {
            System.out.println("Tarea no encontrada o ya finalizada.");
        }
    }

    public void verTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            for (Tarea tarea : tareas) {
                System.out.println(tarea);
            }
        }
    }

    public void eliminarTarea(int id) {
        Tarea tarea = buscarTareaPorId(id);
        if (tarea != null) {
            tareas.remove(tarea);
            System.out.println("Tarea eliminada: " + tarea);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    public void editarTarea(int id, String nuevaDescripcion) {
        Tarea tarea = buscarTareaPorId(id);
        if (tarea != null) {
            tarea.setDescripcion(nuevaDescripcion);
            System.out.println("Tarea actualizada: " + tarea);
        } else {
            System.out.println("Tarea no encontrada.");
        }
    }

    public void mostrarTiempoTotalTrabajo() {
        long totalMinutos = tareas.stream()
                .filter(Tarea::isFinalizada)
                .mapToLong(Tarea::getDuracion)
                .sum();
        System.out.println("Tiempo total de trabajo: " + totalMinutos + " minutos.");
    }

    public void buscarTareaPorDescripcion(String descripcion) {
        List<Tarea> resultados = tareas.stream()
                .filter(t -> t.getDescripcion().contains(descripcion))
                .collect(Collectors.toList());

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron tareas con esa descripción.");
        } else {
            for (Tarea tarea : resultados) {
                System.out.println(tarea);
            }
        }
    }

    public void ordenarTareas(Comparator<Tarea> criterio) {
        tareas.sort(criterio);
        System.out.println("Tareas ordenadas.");
        verTareas();
    }

    private Tarea buscarTareaPorId(int id) {
        return tareas.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Gestor de Tareas ---");
            System.out.println("1. Crear tarea");
            System.out.println("2. Finalizar tarea");
            System.out.println("3. Ver tareas");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Editar tarea");
            System.out.println("6. Mostrar tiempo total de trabajo");
            System.out.println("7. Buscar tarea por descripción");
            System.out.println("8. Ordenar tareas");
            System.out.println("9. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la descripción de la tarea: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Ingresa la fecha de vencimiento (yyyy-MM-dd): ");
                    LocalDate fechaVencimiento = LocalDate.parse(scanner.nextLine());
                    gestor.crearTarea(descripcion, fechaVencimiento);
                    break;
                case 2:
                    System.out.print("Ingresa el ID de la tarea a finalizar: ");
                    int idFinalizar = scanner.nextInt();
                    gestor.finalizarTarea(idFinalizar);
                    break;
                case 3:
                    gestor.verTareas();
                    break;
                case 4:
                    System.out.print("Ingresa el ID de la tarea a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    gestor.eliminarTarea(idEliminar);
                    break;
                case 5:
                    System.out.print("Ingresa el ID de la tarea a editar: ");
                    int idEditar = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Ingresa la nueva descripción: ");
                    String nuevaDescripcion = scanner.nextLine();
                    gestor.editarTarea(idEditar, nuevaDescripcion);
                    break;
                case 6:
                    gestor.mostrarTiempoTotalTrabajo();
                    break;
                case 7:
                    System.out.print("Ingresa la descripción a buscar: ");
                    String descBusqueda = scanner.nextLine();
                    gestor.buscarTareaPorDescripcion(descBusqueda);
                    break;
                case 8:
                    System.out.println("Ordenar por:");
                    System.out.println("1. Alfabéticamente");
                    System.out.println("2. Fecha de inicio");
                    System.out.println("3. ID");
                    System.out.println("4. Fecha de vencimiento");
                    System.out.println("5. Fecha de finalización");
                    int opcionOrden = scanner.nextInt();
                    switch (opcionOrden) {
                        case 1:
                            gestor.ordenarTareas(Comparator.comparing(Tarea::getDescripcion));
                            break;
                        case 2:
                            gestor.ordenarTareas(Comparator.comparing(Tarea::getTiempoInicio));
                            break;
                        case 3:
                            gestor.ordenarTareas(Comparator.comparing(Tarea::getId));
                            break;
                        case 4:
                            gestor.ordenarTareas(Comparator.comparing(Tarea::getFechaVencimiento));
                            break;
                        case 5:
                            gestor.ordenarTareas(Comparator.comparing(Tarea::getTiempoFinalizacion, Comparator.nullsLast(Comparator.naturalOrder())));
                            break;
                        default:
                            System.out.println("Opción de ordenación no válida.");
                    }
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 9.");
            }

        } while (opcion != 9);

        scanner.close();
    }
}