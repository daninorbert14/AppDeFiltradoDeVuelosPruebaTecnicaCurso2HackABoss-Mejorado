import entities.Vuelo;
import utils.UtilsVuelos;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Clase para UI/Consola.
public class SistemaVuelos {
    // Constante de formateo de fecha para que se muestre en orden de día, mes y año.
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        // Lista de todos los vuelos
        List<Vuelo> listaVuelos = List.of(
                new Vuelo(47629387, "TOK001-V", "Iberia", "Barcelona", "Tokio", LocalDate.of(2026, 8, 24), LocalDate.of(2026, 9, 6)),
                new Vuelo(36482602, "PLS001-V", "Air Mauritius", "Madrid", "Port-Louis", LocalDate.of(2027, 7, 20), LocalDate.of(2027, 8, 18)),
                new Vuelo(46392749, "BIL001-V", "Ryanair", "Madrid", "Bilbao", LocalDate.of(2026, 6, 5), LocalDate.of(2026, 6, 10)),
                new Vuelo(82764068, "BDP001-V", "Swiss Airlines", "Berlín", "Budapest", LocalDate.of(2026, 10, 11), LocalDate.of(2026, 10, 19)),
                new Vuelo(93716283, "TNF001-V", "Iberia", "Bilbao", "Tenerife", LocalDate.of(2026, 4, 23), LocalDate.of(2026, 4, 28)),
                new Vuelo(17384629, "NYK001-V", "Air Europa", "Madrid", "Nueva York", LocalDate.of(2027, 6, 16), LocalDate.of(2027, 6, 26)),
                new Vuelo(68262839, "BGT001-V", "Avianca", "Madrid", "Bogotá", LocalDate.of(2026, 7, 10), LocalDate.of(2026, 7, 20)),
                new Vuelo(37283946, "PAR001-V", "British Airways", "Londres", "París", LocalDate.of(2026, 11, 11), LocalDate.of(2026, 11, 15)),
                new Vuelo(28465937, "NAI001-V", "Iberia", "Madrid", "Nairobi", LocalDate.of(2027, 9, 3), LocalDate.of(2027, 9, 17)),
                new Vuelo(54027305, "BSA001-V", "LATAM Airlines", "Brasilia", "Buenos Aires", LocalDate.of(2026, 5, 6), LocalDate.of(2026, 5, 9)));

        // Impresión de la lista de todos los vuelos.
        System.out.println("--- LISTA DE VUELOS ✈️ ---");
        imprimirVuelos(listaVuelos);

        // Fechas hardcodeadas para el filtrado de vuelos.
        LocalDate fechaInicio = LocalDate.of(2026, 6, 1);
        LocalDate fechaFin = LocalDate.of(2026, 10, 1);

        // Elaboración de la lista de vuelos filtrados.
        List<Vuelo> vuelosFiltrados = UtilsVuelos.filtrarVuelos(listaVuelos, fechaInicio, fechaFin);

        // Comprobación del contenido de la lista de vuelos filtrados.
        if (vuelosFiltrados.isEmpty()) {
            System.out.println("\n ❌ No se han encontrado vuelos ❌");
        } else {
            System.out.println("\n ✅ Vuelos encontrados ✅ \n");
            // Según el valor de las fechas introducidas para el filtrado de vuelos se imprime un mensaje distinto.
            if (fechaInicio == null && fechaFin == null)
                System.out.println("--- VUELOS DISPONIBLES (Por fecha de salida) ---");
            else if (fechaInicio == null)
                System.out.println("--- VUELOS DISPONIBLES HASTA " + fechaFin.format(FORMATO_FECHA) + " (Por fecha de salida) ---");
            else if (fechaFin == null)
                System.out.println("--- VUELOS DISPONIBLES DESDE " + fechaInicio.format(FORMATO_FECHA) + " (Por fecha de salida) ---");
            else
                System.out.println("--- VUELOS DISPONIBLES DESDE " + fechaInicio.format(FORMATO_FECHA) + " HASTA " + fechaFin.format(FORMATO_FECHA) + " (Por fecha de salida) ---");

            // Llamada al método que imprime los vuelos.
            imprimirVuelos(vuelosFiltrados);
        }
    }

    // Metodo que imprime una lista de vuelos dada.
    private static void imprimirVuelos(List<Vuelo> vuelos) {
        vuelos.forEach(System.out::println);
    }
}
