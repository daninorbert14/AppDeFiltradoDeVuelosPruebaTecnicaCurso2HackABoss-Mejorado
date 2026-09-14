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

2. Abre el proyecto en tu IDE (IntelliJ recomendado) — al detectar el `pom.xml`, IntelliJ lo importará automáticamente como proyecto Maven y descargará las dependencias
3. Ejecuta la clase `SistemaVuelos.java`

También puedes compilar el proyecto desde terminal con Maven:

```bash
mvn compile
```

---

## 🛠️ Tecnologías

* ☕ Java 17+
* 📅 `java.time` (manejo de fechas con `LocalDate`)
* 🔁 Streams & Lambdas
* 📦 Maven (gestión de dependencias y build)
* ✅ JUnit 5 (tests unitarios)

---

## 📂 Estructura del proyecto

```
src/
 ┣ main/java/
 ┃ ┣ entities/
 ┃ ┃ ┗ Vuelo.java
 ┃ ┣ utils/
 ┃ ┃ ┗ UtilsVuelos.java
 ┃ ┗ SistemaVuelos.java
 ┗ test/java/
   ┗ utils/
     ┗ UtilsVuelosTest.java
pom.xml
```

---

## 🧩 Arquitectura

| Componente         | Responsabilidad                            |
| ------------------ | ------------------------------------------- |
| `SistemaVuelos`     | Control del flujo y salida por consola      |
| `Vuelo`             | Modelo de datos                             |
| `UtilsVuelos`       | Lógica de filtrado de vuelos                |
| `UtilsVuelosTest`   | Tests unitarios de la lógica de filtrado    |

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
* Cobertura de tests unitarios sobre la lógica de filtrado (casos límite de fechas, valores `null`, listas vacías y orden del resultado)

---

## 🧪 Testing

El proyecto cuenta con tests unitarios para `UtilsVuelos` usando **JUnit 5**, cubriendo:

* Casos límite del rango de fechas (inclusión en `fechaInicio`/`fechaFin` exactos)
* Combinaciones con fechas `null` (rango abierto por un lado o por ambos)
* Listas de entrada vacías y `null`
* Verificación del orden del resultado por fecha de salida

Para ejecutarlos:

```bash
mvn test
```

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

---

## 👨‍💻 Autor

Daniel Norbert Martín
