package utils;

import entities.Vuelo;

import java.util.*;
import java.time.*;

// Clase para lógica.
public class UtilsVuelos {
    // Método para ejecutar el filtrado de vuelos según las fechas introducidas y una lista de vuelos dada.
    public static List<Vuelo> filtrarVuelos(List<Vuelo> listaVuelos, LocalDate fechaInicio, LocalDate fechaFin) {
        return listaVuelos.stream()
                // Filtra los vuelos cubriendo los 4 posibles casos repartidos por las posibilidades de las dos fechas y unidas por el "&&".
                .filter(vuelo ->
                        (fechaInicio == null || !vuelo.getFechaSalida().isBefore(fechaInicio)) &&
                        (fechaFin == null || !vuelo.getFechaSalida().isAfter(fechaFin)))
                .sorted(Comparator.comparing(Vuelo::getFechaSalida))    // Se ordenan los vuelos filtrados según su fechaSalida.
                .toList(); // Se agrupan los vuelos en una lista.
    }
}
