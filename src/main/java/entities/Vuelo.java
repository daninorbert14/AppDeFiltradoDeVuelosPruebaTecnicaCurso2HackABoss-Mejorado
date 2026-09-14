package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.String.format;

// Clase objeto Vuelo.
public class Vuelo {
    // Constante de formateo de fecha para que se muestre en orden de día, mes y año.
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private int id;
    private String nombreVuelo;
    private String empresa;
    private String lugarSalida;
    private String lugarLlegada;
    private LocalDate fechaSalida;
    private LocalDate fechaLlegada;

    // Método Constructor.
    public Vuelo(int id, String nombreVuelo, String empresa, String lugarSalida, String lugarLlegada, LocalDate fechaSalida, LocalDate fechaLlegada) {
        this.id = id;
        this.nombreVuelo = nombreVuelo;
        this.empresa = empresa;
        this.lugarSalida = lugarSalida;
        this.lugarLlegada = lugarLlegada;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }

    // Métodos Getters.
    public int getId() {
        return id;
    }

    public String getNombreVuelo() {
        return nombreVuelo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getLugarSalida() {
        return lugarSalida;
    }

    public String getLugarLlegada() {
        return lugarLlegada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    // Método toString modificado para la personalización de la impresión de cada vuelo.
    @Override
    public String toString() {
        return format("Vuelo ➡️ ID: %-8d | Nombre: %-8s | Empresa: %-15s | Salida: %-10s | Llegada: %-12s | Fecha de salida: %-8s | Fecha de llegada: %-8s",
                getId(), getNombreVuelo(), getEmpresa(), getLugarSalida(), getLugarLlegada(), getFechaSalida().format(FORMATO_FECHA), getFechaLlegada().format(FORMATO_FECHA));
    }

}
