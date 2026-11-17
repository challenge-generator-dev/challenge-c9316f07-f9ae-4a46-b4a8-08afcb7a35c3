# Implementación de un servicio Ktor para gestión de inventario

El sistema debe gestionar las entradas y salidas de inventario de una bodega. Los actores involucrados son el Administrador de Bodega, el Sistema de Ventas y el Sistema de Abastecimiento. El Administrador de Bodega registra las entradas y salidas de productos. El Sistema de Ventas solicita productos y el Sistema de Abastecimiento notifica las llegadas de nuevos productos. El sistema debe validar que no se permitan salidas de productos que no existan en el inventario y que las entradas no superen la capacidad máxima de la bodega (1000 unidades). En caso de error, el sistema debe registrar el evento y notificar al Administrador de Bodega.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Gestion de inventario de bodega |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 10 horas |

## Stack

- **Lenguaje:** Kotlin
- **Framework:** Ktor 2.3.7
- **Version:** Kotlin 1.9.22

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Tener el proyecto base del reto funcionando en tu máquina: clonar el repositorio, instalar las herramientas y verificar que compila y arranca antes de empezar a practicar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Instala las herramientas para ejecutar el proyecto: JDK 17+ y Maven 3.9+.
- Clona el repositorio del reto (el enlace viene en la entrega del reto y en la sección "Repositorio del Proyecto" del PDF) y ábrelo en tu IDE.
- Instala las dependencias y compila ejecutando `mvn clean compile` en la raíz del repositorio.
- Confirma que el comando termina sin errores: el proyecto arranca y sus pruebas corren.
- Ubica los archivos de práctica: son los que contienen `TODO(reto)` (búscalos en el repositorio). Lee el README.md y el AGENTS.md antes de empezar.

**Entregable:** El proyecto compila/arranca sin errores con `mvn clean compile`.

<details>
<summary>Pistas de conocimiento</summary>

- Los archivos con `TODO(reto)` son el ejercicio: el resto del repositorio ya está resuelto y no hace falta tocarlo.
- Si el comando de verificación falla, revisa la versión de las herramientas instaladas antes de modificar código.
- AGENTS.md describe el reto, el comando de verificación y las reglas del repositorio.

</details>

### Fase 1: Definición del modelo de datos y endpoints básicos

**Objetivo:** Definir el modelo de datos para el inventario y crear los endpoints básicos para registrar entradas y salidas.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Identificar las entidades y relaciones necesarias para modelar el inventario.
- Crear los endpoints para registrar entradas y salidas de productos.
- Validar que las entradas no superen la capacidad máxima de la bodega.

**Entregable:** Modelo de datos y endpoints básicos para registrar entradas y salidas de productos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera las restricciones de capacidad de la bodega al modelar las entradas.
- Piensa en cómo validar las salidas para evitar productos inexistentes.

</details>

### Fase 2: Implementación de validaciones y manejo de errores

**Objetivo:** Implementar validaciones adicionales y manejar los errores que puedan ocurrir durante las operaciones de inventario.

**Tiempo estimado:** 4 horas

**Instrucciones:**

- Agregar validaciones para asegurar que las salidas no superen el stock disponible.
- Implementar manejo de errores para casos como productos inexistentes o capacidad máxima superada.
- Registrar los eventos de error y notificar al Administrador de Bodega.

**Entregable:** Validaciones adicionales y manejo de errores implementados en el servicio.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo notificar al Administrador de Bodega en caso de errores.
- Piensa en cómo registrar los eventos de error para futuras auditorías.

</details>

### Fase 3: Optimización y refactorización del servicio

**Objetivo:** Optimizar y refactorizar el servicio para mejorar su rendimiento y mantenibilidad.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Refactorizar la pieza p1 (InventoryModel) para separar la lógica de persistencia usando un puerto (InventoryRepositoryPort).
- Refactorizar la pieza p2 (InventoryService) para delegar la persistencia al puerto InventoryRepositoryPort.
- Documentar las decisiones de diseño en un archivo ADR (Architecture Decision Record) en el repositorio.
- Asegurar que los casos de aceptación de p1 y p2 sigan pasando tras la refactorización.

**Entregable:** Documentación de decisiones de diseño y refactorización aplicada.

<details>
<summary>Pistas de conocimiento</summary>

- Considera el uso de patrones de diseño para mejorar la estructura del código.
- Piensa en cómo documentar las decisiones de optimización para futuras referencias.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es el modelo de datos del inventario y cómo se relacionan sus entidades?
- **paraQueSirve**: ¿Para qué sirven las validaciones implementadas en el servicio?
- **comoSeUsa**: ¿Cómo se usa el servicio para registrar entradas y salidas de productos?
- **erroresComunes**: ¿Cuáles son los errores comunes que pueden ocurrir durante las operaciones de inventario y cómo se manejan?
- **queDecisionesImplica**: ¿Qué decisiones de diseño y optimización se tomaron durante la refactorización del servicio?

## Criterios de Evaluacion

- Modelo de datos y endpoints básicos implementados.
- Validaciones adicionales y manejo de errores implementados.
- Servicio optimizado y refactorizado con documentación de decisiones de diseño.

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Definición del modelo de datos y endpoints básicos | Modelado de datos para inventario | — | El modelo de datos incluye los campos requeridos (id, productId, quantity, operationType, timestamp).; Los endpoints POST /inventory/entries y POST /inventory/exits están definidos y responden con éxito. | — | — |
| f1 — Definición del modelo de datos y endpoints básicos | Definición de endpoints REST | `src/main/kotlin/domain/application/routes/InventoryRoutes.kt:InventoryRoutes.registerEntry` | El modelo de datos incluye los campos requeridos (id, productId, quantity, operationType, timestamp).; Los endpoints POST /inventory/entries y POST /inventory/exits están definidos y responden con éxito. | — | — |
| f1 — Definición del modelo de datos y endpoints básicos | Persistencia de datos con Exposed | `src/main/kotlin/domain/infrastructure/repositories/ExposedInventoryRepository.kt:ExposedInventoryRepository.save` | El modelo de datos incluye los campos requeridos (id, productId, quantity, operationType, timestamp).; Los endpoints POST /inventory/entries y POST /inventory/exits están definidos y responden con éxito. | — | — |
| f2 — Implementación de validaciones y manejo de errores | Validación de reglas de negocio | `src/main/kotlin/domain/domain/services/InventoryService.kt:InventoryService.registerEntry` | Las validaciones de entrada rechazan solicitudes inválidas con código HTTP 400.; Los errores de negocio (ej: cantidad insuficiente) se manejan con códigos HTTP apropiados.; Los errores internos se manejan con código HTTP 500. | — | — |
| f2 — Implementación de validaciones y manejo de errores | Mapeo de errores a respuestas HTTP | `src/main/kotlin/domain/infrastructure/error/ErrorMapper.kt:ErrorMapper.toHttpResponse` | Las validaciones de entrada rechazan solicitudes inválidas con código HTTP 400.; Los errores de negocio (ej: cantidad insuficiente) se manejan con códigos HTTP apropiados.; Los errores internos se manejan con código HTTP 500. | — | — |
| f3 — Optimización y refactorización del servicio | Diseño de puertos para desacoplar persistencia | — | La lógica de persistencia está aislada en un puerto (InventoryRepositoryPort).; El servicio delega la persistencia al puerto sin acoplarse a Exposed.; La documentación de decisiones de diseño está incluida en el repositorio. | — | — |

## Pruebas de aceptacion

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| El modelo de datos debe incluir al menos los campos: id, productId, quantity, operationType (ENTRADA/SALIDA), y timestamp. | chequeo estatico (code): exige `productId`, `quantity`, `operationType`, `ENTRADA`, `SALIDA`, `timestamp` | Verificada |
| Los endpoints deben seguir el formato REST: POST /inventory/entries para registrar entradas y POST /inventory/exits para registrar salidas. | chequeo estatico (code): exige `/inventory/entries`, `/inventory/exits` | Verificada |
| Manejar errores con códigos HTTP apropiados (400 para solicitudes inválidas, 404 para recursos no encontrados, 500 para errores internos). | sin ubicar | Restriccion no verificada en sin ubicar |
| Usar Exposed para la persistencia de datos. | chequeo estatico (code): exige `Exposed` | Verificada |

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
