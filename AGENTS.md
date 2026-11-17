# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de un servicio Ktor para gestión de inventario**.

| | |
|---|---|
| Tema | Gestion de inventario de bodega |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Kotlin + Ktor |
| Stack | Kotlin / Ktor 2.3.7 |
| Patron arquitectonico | hexagonal/clean |
| Tiempo estimado | 10 horas |

## Receta del stack

Esqueleto obligatorio:

- `manifiesto de dependencias y build de Kotlin en la raiz (segun las convenciones idiomaticas de Kotlin/Ktor)`
- `punto de entrada de la aplicacion (segun las convenciones idiomaticas de Kotlin/Ktor)`
- `capa de dominio con entidades y puertos (segun las convenciones idiomaticas de Kotlin/Ktor)`
- `capa de aplicacion con casos de uso (segun las convenciones idiomaticas de Kotlin/Ktor)`
- `capa de infraestructura con los adaptadores y los handlers HTTP de Ktor (segun las convenciones idiomaticas de Kotlin/Ktor)`

Trampas conocidas:

- Todo el codigo, el manifiesto y los tests son de Kotlin/Ktor; no mezclar otro lenguaje ni otro runtime.

Dependencias:

- io.ktor:ktor-server-core-jvm 2.3.12
- io.ktor:ktor-server-netty-jvm 2.3.12
- org.jetbrains.kotlin:kotlin-test-junit 1.9.22
- ch.qos.logback:logback-classic 1.6.7
- com.h2database:h2 2.5.252
- io.ktor:ktor-serialization-kotlinx-json-jvm 2.3.12
- io.ktor:ktor-server-content-negotiation-jvm 2.3.12
- org.jetbrains.exposed:exposed-core 0.61.0
- org.jetbrains.exposed:exposed-dao 0.61.0
- org.jetbrains.exposed:exposed-jdbc 0.61.0
- org.slf4j:slf4j-api 2.0.20
- org.jetbrains.kotlinx:kotlinx-serialization-json 1.6.3
- org.jetbrains.kotlin:kotlin-maven-serialization 1.9.22

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Definición del modelo de datos y endpoints básicos**: Modelo de datos y endpoints básicos para registrar entradas y salidas de productos.
- **Fase 2 — Implementación de validaciones y manejo de errores**: Validaciones adicionales y manejo de errores implementados en el servicio.
- **Fase 3 — Optimización y refactorización del servicio**: Documentación de decisiones de diseño y refactorización aplicada.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/kotlin/domain/application/routes/InventoryRoutes.kt` — La pieza p2 (Definición de endpoints REST, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/kotlin/domain/infrastructure/repositories/ExposedInventoryRepository.kt` — La pieza p3 (Persistencia de datos con Exposed, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/kotlin/domain/domain/services/InventoryService.kt` — La pieza p4 (Validación de reglas de negocio, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/kotlin/domain/infrastructure/error/ErrorMapper.kt` — La pieza p5 (Mapeo de errores a respuestas HTTP, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).

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

## Pruebas de aceptacion y ubicacion de la logica

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

La logica de cada pieza va en su archivo; no la muevas a otro.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| El modelo de datos debe incluir al menos los campos: id, productId, quantity, operationType (ENTRADA/SALIDA), y timestamp. | chequeo estatico (code): exige `productId`, `quantity`, `operationType`, `ENTRADA`, `SALIDA`, `timestamp` | Verificada |
| Los endpoints deben seguir el formato REST: POST /inventory/entries para registrar entradas y POST /inventory/exits para registrar salidas. | chequeo estatico (code): exige `/inventory/entries`, `/inventory/exits` | Verificada |
| Manejar errores con códigos HTTP apropiados (400 para solicitudes inválidas, 404 para recursos no encontrados, 500 para errores internos). | sin ubicar | Restriccion no verificada en sin ubicar |
| Usar Exposed para la persistencia de datos. | chequeo estatico (code): exige `Exposed` | Verificada |

## Lo que falta y tenes que completar

### Imports sin uso (4) — no rompen la compilacion

Limpieza opcional: el proyecto compila igual con ellos.

- `src/main/kotlin/domain/application/routes/InventoryRoutes.kt` — `ErrorMapper`
- `src/main/kotlin/domain/application/routes/InventoryRoutes.kt` — `InvalidInputException`
- `src/main/kotlin/domain/application/routes/InventoryRoutes.kt` — `ExposedInventoryRepository`
- `src/main/kotlin/domain/infrastructure/error/ErrorMapper.kt` — `InventoryException`

### Presentes (13)

- `pom.xml`
- `src/main/kotlin/com/example/Application.kt`
- `mvnw`
- `mvnw.cmd`
- `.mvn/wrapper/maven-wrapper.properties`
- `src/main/kotlin/domain/domain/model/InventoryModel.kt`
- `src/main/kotlin/domain/application/routes/InventoryRoutes.kt`
- `src/main/kotlin/domain/infrastructure/repositories/ExposedInventoryRepository.kt`
- `src/main/kotlin/domain/domain/services/InventoryService.kt`
- `src/main/kotlin/domain/infrastructure/error/ErrorMapper.kt`
- `src/main/kotlin/domain/domain/ports/InventoryRepositoryPort.kt`
- `src/main/kotlin/domain/Application.kt`
- `src/main/kotlin/domain/resources/application.conf`

### Capas del patron declarado

Son las capas que la propuesta arquitectonica plantea, marcadas segun existan hoy en el repo. Orientan donde poner el codigo nuevo; no son una condicion para compilar.

- `src/main/kotlin/domain/model` (ausente)
- `src/main/kotlin/domain/ports` (ausente)
- `src/main/kotlin/domain/services` (ausente)
- `src/main/kotlin/application/routes` (ausente)
- `src/main/kotlin/infrastructure/repositories` (ausente)
- `src/main/kotlin/infrastructure/error` (ausente)
- `src/main/resources` (ausente)

## Verificacion

```bash
mvn clean compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollador, Tecnología Kotlin, Advanced L2
- Brecha que el reto ataca: Servicio Ktor que gestiona entradas y salidas de inventario de una bodega

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
