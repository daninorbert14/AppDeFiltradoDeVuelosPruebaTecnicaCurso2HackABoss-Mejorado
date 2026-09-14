# ✈️ Sistema de Gestión de Vuelos

Aplicación de consola en Java para la consulta y filtrado de vuelos según un rango de fechas.

---

## 📖 Descripción

Este proyecto permite:

* Visualizar la lista completa de vuelos disponibles
* Filtrar los vuelos según un rango de fechas fijo (`fechaInicio`, `fechaFin`)
* Mostrar los resultados ordenados por fecha de salida

---

## 🚀 Ejecución

1. Clona el repositorio:

```bash
git clone <URL_DEL_REPOSITORIO>
```

2. Abre el proyecto en tu IDE (IntelliJ recomendado)
3. Ejecuta la clase `SistemaVuelos.java`

---

## 🛠️ Tecnologías

* ☕ Java 17+
* 📅 `java.time` (manejo de fechas con `LocalDate`)
* 🔁 Streams & Lambdas

---

## 📂 Estructura del proyecto

```
src/
 ┣ entities/
 ┃ ┗ Vuelo.java
 ┣ utils/
 ┃ ┗ UtilsVuelos.java
 ┗ SistemaVuelos.java
```

---

## 🧩 Arquitectura

| Componente      | Responsabilidad                        |
| --------------- | --------------------------------------- |
| `SistemaVuelos` | Control del flujo y salida por consola |
| `Vuelo`         | Modelo de datos                        |
| `UtilsVuelos`   | Lógica de filtrado de vuelos           |

---

## ⚙️ Funcionamiento

```
1. Mostrar todos los vuelos
2. Filtrar según fechaInicio/fechaFin (definidas como constantes)
3. Mostrar los vuelos filtrados y ordenados por fecha de salida
```

---

## 🧠 Detalles técnicos

* Separación de responsabilidades aplicada (SRP)
* Uso de `Stream API` para filtrado y ordenación
* `fechaInicio` y `fechaFin` son constantes fijas definidas en `main`

---

## 🖥️ Ejemplo de salida

```
--- LISTA DE VUELOS ✈️ ---
...

✅ Vuelos encontrados:
--- VUELOS DESDE 01/06/2026 HASTA 01/10/2026 (Por fecha de salida) ---
...
```

---

## 📌 Mejoras futuras

* CRUD completo de vuelos
* Persistencia de datos (fichero o base de datos)
* Interfaz gráfica (JavaFX / Swing)
* Tests unitarios

---

## 👨‍💻 Autor

Daniel Norbert Martín
