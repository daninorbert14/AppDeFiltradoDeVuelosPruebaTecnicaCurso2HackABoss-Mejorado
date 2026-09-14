package utils;

import entities.Vuelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilsVuelosTest {

    private List<Vuelo> vuelos;

    // Cada test arranca con una lista de vuelos fresca e idéntica, sin que un test pueda contaminar el estado de otro
    @BeforeEach
    void setUp() {
        vuelos = List.of(
                new Vuelo(1, "A", "Iberia", "MAD", "BCN", LocalDate.of(2026, 6, 1), LocalDate.of(2026, 6, 2)),
                new Vuelo(2, "B", "Iberia", "MAD", "VLC", LocalDate.of(2026, 7, 15), LocalDate.of(2026, 7, 16)),
                new Vuelo(3, "C", "Iberia", "MAD", "SVQ", LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 2))
        );
    }

    // Comprueba que un vuelo con fechaSalida exactamente igual a fechaInicio se incluya (límite inferior inclusivo)
    @Test
    void deberiaIncluirVueloEnLimiteInferior() {
        List<Vuelo> resultado = UtilsVuelos.filtrarVuelos(vuelos, LocalDate.of(2026, 6, 1), LocalDate.of(2026, 12, 1));
        assertTrue(resultado.stream().anyMatch(v -> v.getId() == 1));
    }

    // Comprueba que un vuelo con fechaSalida exactamente igual a fechaFin se incluya (límite superior inclusivo)
    @Test
    void deberiaIncluirVueloEnLimiteSuperior() {
        List<Vuelo> resultado = UtilsVuelos.filtrarVuelos(vuelos, LocalDate.of(2026, 1, 1), LocalDate.of(2026, 7, 15));
        assertTrue(resultado.stream().anyMatch(v -> v.getId() == 2));
    }
    // Comprueba que, sin límite inferior, se devuelvan exactamente los vuelos hasta fechaFin (y ningún otro)
    @Test
    void fechaInicioNull_incluyeTodoHastaFechaFin() {
        List<Vuelo> resultado = UtilsVuelos.filtrarVuelos(vuelos, null, LocalDate.of(2026, 7, 20));
        assertEquals(List.of(1, 2), resultado.stream().map(Vuelo::getId).toList());
    }

    // Comprueba que, sin límite superior, se devuelvan exactamente los vuelos desde fechaInicio (y ningún otro)
    @Test
    void fechaFinNull_incluyeTodoDesdeFechaInicio() {
        List<Vuelo> resultado = UtilsVuelos.filtrarVuelos(vuelos, LocalDate.of(2026, 7, 1), null);
        assertEquals(List.of(2, 3), resultado.stream().map(Vuelo::getId).toList());
    }

    // Comprueba que la lista resultante esté vacía cuando el rango de fechas no coincide con ningún vuelo
    @Test
    void sinCoincidencias_devuelveListaVacia() {
        List<Vuelo> resultado = UtilsVuelos.filtrarVuelos(vuelos, LocalDate.of(2030, 1, 1), LocalDate.of(2030, 2, 1));
        assertTrue(resultado.isEmpty());
    }

    // Comprueba que la lista resultante esté ordenada por las fechas de salida
    @Test
    void resultadoQuedaOrdenadoPorFechaSalida() {
        // Usamos una entrada deliberadamente desordenada para no depender de que el orden de inserción coincida con el de fechas
        List<Vuelo> vuelosDesordenados = List.of(
                new Vuelo(3, "C", "Iberia", "MAD", "SVQ", LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 2)),
                new Vuelo(1, "A", "Iberia", "MAD", "BCN", LocalDate.of(2026, 6, 1), LocalDate.of(2026, 6, 2)),
                new Vuelo(2, "B", "Iberia", "MAD", "VLC", LocalDate.of(2026, 7, 15), LocalDate.of(2026, 7, 16))
        );

        List<Vuelo> resultado = UtilsVuelos.filtrarVuelos(vuelosDesordenados, null, null);
        assertEquals(List.of(1, 2, 3), resultado.stream().map(Vuelo::getId).toList());
    }

    // Comprueba que si la lista de vuelos está vacía devuelve una lista vacía
    @Test
    void listaVacia_devuelveListaVacia() {
        List<Vuelo> resultado = UtilsVuelos.filtrarVuelos(List.of(), LocalDate.of(2026, 1, 1), LocalDate.of(2026, 12, 31));
        assertTrue(resultado.isEmpty());
    }

    // Comprueba que si la lista es null devuelve un NullPointerException (con fechas válidas, para aislar la causa)
    @Test
    void listaNull_lanzaNullPointerException() {
        assertThrows(NullPointerException.class,
                () -> UtilsVuelos.filtrarVuelos(null, LocalDate.of(2026, 1, 1), LocalDate.of(2026, 12, 31)));
    }
}