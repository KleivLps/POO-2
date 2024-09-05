package JAVATIMEAPI;

    import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

    public class MENUINTERACTIVO {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int opcion;

            do {
                System.out.println("Menú de Opciones:");
                System.out.println("1. Generar fecha actual");
                System.out.println("2. Generar fecha específica (cumpleaños)");
                System.out.println("3. Crear LocalDate desde día, mes y año");
                System.out.println("4. Crear LocalDate desde fecha en formato predeterminado");
                System.out.println("5. Modificar fecha agregando días, meses y años");
                System.out.println("6. Modificar fecha restando días, meses y años");
                System.out.println("7. Verificar si un año es bisiesto");
                System.out.println("8. Juego de adivinanza de fechas");
                System.out.println("9. Obtener segundos desde el inicio del día");
                System.out.println("10. Calcular tiempo restante hasta medianoche");
                System.out.println("11. Ajustar hora al próximo valor exacto");
                System.out.println("12. Convertir segundos a LocalTime");
                System.out.println("13. Calcular diferencia en segundos entre dos horas");
                System.out.println("14. LocalTime a la mitad del tiempo hasta medianoche");
                System.out.println("15. Convertir LocalDateTime a ZonedDateTime en Tokio");
                System.out.println("16. Mostrar fecha y hora en todas las zonas horarias");
                System.out.println("17. Calcular edad a partir de la fecha de nacimiento");
                System.out.println("18. Calcular diferencia entre dos fechas usando ChronoUnit");
                System.out.println("19. Salir");
                System.out.print("Selecciona una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir nueva línea

                switch (opcion) {
                    case 1:
                        LocalDate fechaActual = LocalDate.now();
                        System.out.println("La fecha actual es: " + fechaActual);
                        break;

                    case 2:
                        LocalDate cumpleaños = LocalDate.of(2004, 6, 19); // Ejemplo: 19 de junio de 2004
                        System.out.println("Mi cumpleaños es: " + cumpleaños);
                        break;

                    case 3:
                        System.out.print("Ingresa el día: ");
                        int dia = scanner.nextInt();
                        System.out.print("Ingresa el mes: ");
                        int mes = scanner.nextInt();
                        System.out.print("Ingresa el año: ");
                        int año = scanner.nextInt();
                        LocalDate fecha = LocalDate.of(año, mes, dia);
                        System.out.println("La fecha ingresada es: " + fecha);
                        break;

                    case 4:
                        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        System.out.print("Ingresa la fecha (dd/MM/yyyy): ");
                        String input4 = scanner.nextLine();
                        LocalDate fecha4 = LocalDate.parse(input4, formatter4);
                        System.out.println("La fecha ingresada es: " + fecha4);
                        break;

                    case 5:
                        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        System.out.print("Ingresa la fecha (dd-MM-yyyy): ");
                        String input5 = scanner.nextLine();
                        LocalDate fecha5 = LocalDate.parse(input5, formatter5);
                        LocalDate nuevaFecha5 = fecha5.plusDays(15).plusMonths(2).plusYears(3);
                        System.out.println("Nueva fecha: " + nuevaFecha5);
                        System.out.println("Día de la semana: " + nuevaFecha5.getDayOfWeek());
                        break;

                    case 6:
                        DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        System.out.print("Ingresa la fecha (dd-MM-yyyy): ");
                        String input6 = scanner.nextLine();
                        LocalDate fecha6 = LocalDate.parse(input6, formatter6);
                        LocalDate nuevaFecha6 = fecha6.minusDays(13).minusMonths(10).minusYears(1);
                        System.out.println("Nueva fecha: " + nuevaFecha6);
                        System.out.println("Día de la semana: " + nuevaFecha6.getDayOfWeek());
                        break;

                    case 7:
                        System.out.print("Ingresa el año: ");
                        int año7 = scanner.nextInt();
                        boolean esBisiesto = LocalDate.of(año7, 1, 1).isLeapYear();
                        System.out.println("¿El año " + año7 + " es bisiesto? " + (esBisiesto ? "Sí" : "No"));
                        break;

                    case 8:
                        Random random = new Random();
                        int year = random.nextInt(2024 - 1900) + 1900;
                        int month = random.nextInt(12) + 1;
                        int day = random.nextInt(28) + 1;
                        LocalDate fechaObjetivo = LocalDate.of(year, month, day);
                        LocalDate intento;
                        do {
                            System.out.print("Adivina la fecha (yyyy-MM-dd): ");
                            intento = LocalDate.parse(scanner.nextLine());
                            if (intento.isBefore(fechaObjetivo)) {
                                System.out.println("La fecha es después.");
                            } else if (intento.isAfter(fechaObjetivo)) {
                                System.out.println("La fecha es antes.");
                            } else {
                                System.out.println("¡Felicidades! Adivinaste la fecha.");
                            }
                        } while (!intento.equals(fechaObjetivo));
                        break;

                    case 9:
                        LocalTime horaActual9 = LocalTime.now();
                        int segundosDesdeInicio = horaActual9.toSecondOfDay();
                        System.out.println("Segundos desde el inicio del día: " + segundosDesdeInicio);
                        break;

                    case 10:
                        LocalTime horaActual10 = LocalTime.now();
                        LocalTime medianoche = LocalTime.MIDNIGHT;
                        long horasRestantes = java.time.Duration.between(horaActual10, medianoche).toHours();
                        long minutosRestantes = java.time.Duration.between(horaActual10, medianoche).toMinutes() % 60;
                        long segundosRestantes = java.time.Duration.between(horaActual10, medianoche).getSeconds() % 60;
                        System.out.println("Faltan " + horasRestantes + " horas, " + minutosRestantes + " minutos y " + segundosRestantes + " segundos para la medianoche.");
                        break;

                    case 11:
                        System.out.print("Ingresa la hora (HH:mm:ss): ");
                        LocalTime hora11 = LocalTime.parse(scanner.nextLine());
                        LocalTime horaAjustada = hora11.plusSeconds(1).withNano(0).withSecond(0);
                        System.out.println("Hora ajustada: " + horaAjustada);
                        break;

                    case 12:
                        System.out.print("Ingresa la cantidad de segundos: ");
                        int segundos12 = scanner.nextInt();
                        LocalTime tiempo12 = LocalTime.ofSecondOfDay(segundos12);
                        System.out.println("Hora correspondiente: " + tiempo12);
                        break;

                    case 13:
                        System.out.print("Ingresa la primera hora (HH:mm:ss): ");
                        LocalTime hora1 = LocalTime.parse(scanner.nextLine());
                        System.out.print("Ingresa la segunda hora (HH:mm:ss): ");
                        LocalTime hora2 = LocalTime.parse(scanner.nextLine());
                        long diferenciaSegundos = java.time.Duration.between(hora1, hora2).getSeconds();
                        System.out.println("Diferencia en segundos: " + diferenciaSegundos);
                        break;

                    case 14:
                        LocalTime hora14 = LocalTime.of(12, 0);
                        LocalTime medianoche14 = LocalTime.MIDNIGHT;
                        long segundosHastaMedianoche = java.time.Duration.between(hora14, medianoche14).getSeconds();
                        LocalTime mitadTiempo = hora14.plusSeconds(segundosHastaMedianoche / 2);
                        System.out.println("Mitad del tiempo hasta medianoche: " + mitadTiempo);
                        break;

                    case 15:
                        LocalDateTime fechaHora = LocalDateTime.now();
                        ZonedDateTime enTokio = fechaHora.atZone(ZoneId.of("Asia/Tokyo"));
                        System.out.println("Fecha y hora en Tokio: " + enTokio);
                        break;

                    case 16:
                        System.out.print("Ingresa la fecha y hora (yyyy-MM-ddTHH:mm): ");
                        LocalDateTime fechaHora16 = LocalDateTime.parse(scanner.nextLine());
                        Set<String> zonasHorarias = ZoneId.getAvailableZoneIds();
                        for (String zona : zonasHorarias) {
                            ZonedDateTime zonedDateTime = fechaHora16.atZone(ZoneId.of(zona));
                            System.out.println("Zona horaria: " + zona + " - Fecha y hora: " + zonedDateTime);
                        }
                        break;

                    case 17:
                        System.out.print("Ingresa tu fecha de nacimiento (yyyy-MM-dd): ");
                        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
                        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
                        System.out.println("Tienes " + edad + " años.");
                        break;

                    case 18:
                        DateTimeFormatter formatter18 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        System.out.print("Ingresa la primera fecha (dd-MM-yyyy): ");
                        LocalDate fecha1 = LocalDate.parse(scanner.nextLine(), formatter18);
                        System.out.print("Ingresa la segunda fecha (dd-MM-yyyy): ");
                        LocalDate fecha2 = LocalDate.parse(scanner.nextLine(), formatter18);
                        long años = ChronoUnit.YEARS.between(fecha1, fecha2);
                        long meses = ChronoUnit.MONTHS.between(fecha1, fecha2) % 12;
                        long días = ChronoUnit.DAYS.between(fecha1, fecha2) % 365;
                        System.out.println("Diferencia: " + años + " años, " + meses + " meses, y " + días + " días.");
                        break;

                    case 19:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, elige una opción del 1 al 19.");
                        break;
                }
                System.out.println();
            } while (opcion != 19);

            scanner.close();
        }
    }

