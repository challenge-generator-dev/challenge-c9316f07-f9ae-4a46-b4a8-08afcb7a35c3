# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/kotlin/domain/application/routes/InventoryRoutes.kt` — La pieza p2 (Definición de endpoints REST, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/kotlin/domain/infrastructure/repositories/ExposedInventoryRepository.kt` — La pieza p3 (Persistencia de datos con Exposed, fase f1) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/kotlin/domain/domain/services/InventoryService.kt` — La pieza p4 (Validación de reglas de negocio, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/kotlin/domain/infrastructure/error/ErrorMapper.kt` — La pieza p5 (Mapeo de errores a respuestas HTTP, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Imports sin uso — no rompen la compilacion

Limpieza opcional: el proyecto compila igual con ellos:

- `src/main/kotlin/domain/application/routes/InventoryRoutes.kt` — `ErrorMapper`
- `src/main/kotlin/domain/application/routes/InventoryRoutes.kt` — `InvalidInputException`
- `src/main/kotlin/domain/application/routes/InventoryRoutes.kt` — `ExposedInventoryRepository`
- `src/main/kotlin/domain/infrastructure/error/ErrorMapper.kt` — `InventoryException`

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Kotlin, Advanced L2

### Brecha de conocimiento
Servicio Ktor que gestiona entradas y salidas de inventario de una bodega

### Reto
- Tema: Gestion de inventario de bodega
- Seniority: advanced-l2
- Tipo: practical
- Título: Implementación de un servicio Ktor para gestión de inventario
- Tiempo estimado: 10 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición del modelo de datos y endpoints básicos — objetivo: Definir el modelo de datos para el inventario y crear los endpoints básicos para registrar entradas y salidas. — entregable (NO resolver): Modelo de datos y endpoints básicos para registrar entradas y salidas de productos.
- Fase 2: Implementación de validaciones y manejo de errores — objetivo: Implementar validaciones adicionales y manejar los errores que puedan ocurrir durante las operaciones de inventario. — entregable (NO resolver): Validaciones adicionales y manejo de errores implementados en el servicio.
- Fase 3: Optimización y refactorización del servicio — objetivo: Optimizar y refactorizar el servicio para mejorar su rendimiento y mantenibilidad. — entregable (NO resolver): Documentación de decisiones de diseño y refactorización aplicada.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.example</groupId>
  <artifactId>ktor-skeleton</artifactId>
  <version>1.0.0</version>
  <packaging>jar</packaging>
  
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <kotlin.version>1.9.22</kotlin.version>
    <ktor.version>2.3.12</ktor.version>
    <jvm.target>21</jvm.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>io.ktor</groupId>
      <artifactId>ktor-server-core-jvm</artifactId>
      <version>${ktor.version}</version>
    </dependency>
    <dependency>
      <groupId>io.ktor</groupId>
      <artifactId>ktor-server-netty-jvm</artifactId>
      <version>${ktor.version}</version>
    </dependency>
    <dependency>
      <groupId>org.jetbrains.kotlin</groupId>
      <artifactId>kotlin-test-junit</artifactId>
      <version>${kotlin.version}</version>
      <scope>test</scope>
    </dependency>
      <dependency>
          <groupId>ch.qos.logback</groupId>
          <artifactId>logback-classic</artifactId>
          <version>1.6.7</version>
      </dependency>
      <dependency>
          <groupId>com.h2database</groupId>
          <artifactId>h2</artifactId>
          <version>2.5.252</version>
      </dependency>
      <dependency>
          <groupId>io.ktor</groupId>
          <artifactId>ktor-serialization-kotlinx-json-jvm</artifactId>
          <version>2.3.12</version>
      </dependency>
      <dependency>
          <groupId>io.ktor</groupId>
          <artifactId>ktor-server-content-negotiation-jvm</artifactId>
          <version>2.3.12</version>
      </dependency>
      <dependency>
          <groupId>org.jetbrains.exposed</groupId>
          <artifactId>exposed-core</artifactId>
          <version>0.61.0</version>
      </dependency>
      <dependency>
          <groupId>org.jetbrains.exposed</groupId>
          <artifactId>exposed-dao</artifactId>
          <version>0.61.0</version>
      </dependency>
      <dependency>
          <groupId>org.jetbrains.exposed</groupId>
          <artifactId>exposed-jdbc</artifactId>
          <version>0.61.0</version>
      </dependency>
      <dependency>
          <groupId>org.slf4j</groupId>
          <artifactId>slf4j-api</artifactId>
          <version>2.0.20</version>
      </dependency>
      <dependency>
          <groupId>org.jetbrains.kotlinx</groupId>
          <artifactId>kotlinx-serialization-json</artifactId>
          <version>1.6.3</version>
      </dependency>
      <dependency>
          <groupId>io.ktor</groupId>
          <artifactId>ktor-server-status-pages-jvm</artifactId>
          <version>2.3.12</version>
      </dependency>
  </dependencies>

  <build>
    <sourceDirectory>${project.basedir}/src/main/kotlin</sourceDirectory>
    <testSourceDirectory>${project.basedir}/src/test/kotlin</testSourceDirectory>
    <plugins>
      <plugin>
        <groupId>org.jetbrains.kotlin</groupId>
        <artifactId>kotlin-maven-plugin</artifactId>
        <version>${kotlin.version}</version>
        <configuration>
          <compilerPlugins>
            <plugin>kotlinx-serialization</plugin>
          </compilerPlugins>
        </configuration>
        <dependencies>
          <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-maven-serialization</artifactId>
            <version>${kotlin.version}</version>
          </dependency>
        </dependencies>
        <executions>
          <execution>
            <id>compile</id>
            <goals>
              <goal>compile</goal>
            </goals>
          </execution>
          <execution>
            <id>test-compile</id>
            <goals>
              <goal>test-compile</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.11.0</version>
        <configuration>
          <source>${jvm.target}</source>
          <target>${jvm.target}</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>

// === ARCHIVO: src/main/kotlin/com/example/Application.kt ===
package com.example

import domain.application.routes.InventoryRoutes.inventoryRoutes
import domain.domain.model.InventoryException
import domain.domain.ports.InventoryRepositoryPort
import domain.domain.services.InventoryService
import domain.infrastructure.error.ErrorMapper.toHttpResponse
import domain.infrastructure.repositories.ExposedInventoryRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationCallPipeline
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond
import io.ktor.server.routing.Routing
import io.ktor.server.routing.routing
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("com.example.Application")

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module).start(wait = true)
}

fun Application.module() {
    logger.info("Iniciando aplicación de gestión de inventario...")

    val database = Database.connect(
        url = "jdbc:h2:mem:inventory;DB_CLOSE_DELAY=-1",
        driver = "org.h2.Driver"
    )
    
    transaction(database) {
        logger.info("Inicializando base de datos H2...")
        SchemaUtils.create(ExposedInventoryRepository.InventoryEntries)
        logger.info("Base de datos inicializada correctamente")
    }

    logger.info("Configurando módulos de Ktor...")
    
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
    
    install(StatusPages) {
        exception<InventoryException.ProductNotFoundException> { call, cause ->
            call.respond(HttpStatusCode.NotFound, mapOf("error" to cause.message))
        }
        exception<InventoryException.InsufficientStockException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, mapOf("error" to cause.message))
        }
        exception<InventoryException.CapacityExceededException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, mapOf("error" to cause.message))
        }
        exception<InventoryException.InvalidQuantityException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, mapOf("error" to cause.message))
        }
        exception<IllegalArgumentException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, mapOf("error" to cause.message))
        }
        exception<Exception> { call, cause ->
            logger.error("Error interno del servidor: ${cause.message}", cause)
            call.respond(HttpStatusCode.InternalServerError, mapOf("error" to "Error interno del servidor"))
        }
    }
    
    val inventoryRepository: InventoryRepositoryPort = ExposedInventoryRepository()
    val inventoryService = InventoryService(inventoryRepository)
    
    routing {
        inventoryRoutes(inventoryService)
    }
    
    intercept(ApplicationCallPipeline.Plugins) {
        try {
            proceed()
        } catch (e: Exception) {
            logger.error("Error durante el procesamiento: ${e.message}", e)
            call.toHttpResponse(e)
        }
    }
    
    logger.info("Módulos configurados correctamente")
}

// === ARCHIVO: mvnw ===
#!/bin/sh
"exec" "$(dirname "$0")/mvnw" "$@"

// === ARCHIVO: mvnw.cmd ===
@REM
@REM Copyright 2007 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM     http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.

@IF "%MAVEN_SKIP_RC%" == "" @
@call :chkMHome
@IF ERRORLEVEL 1 @
@call "%MAVEN_PROJECTBASEDIR%\.mvn\jvm.config" %MAVEN_CMD_LINE_ARGS%
@goto :continue

@:chkMHome
@REM Check for Maven home defined inside Maven wrapper distribution
@IF "%MAVEN_HOME%" == "" (
  @SET MAVEN_HOME=%~dp0\.mvn\wrapper\maven-wrapper
)

@:continue
@set CMD_LINE_ARGS=%*
@set MAVEN_JAVA_EXE="%JAVA_HOME%\bin\java.exe"
@set WRAPPER_JAR="%MAVEN_HOME%\maven-wrapper.jar"
@set WRAPPER_PROPS="%MAVEN_HOME%\maven-wrapper.properties"
@set WRAPPER_LOG="%MAVEN_HOME%\maven-wrapper.log"

@if exist %MAVEN_JAVA_EXE% (
  if exist %WRAPPER_JAR% (
    %MAVEN_JAVA_EXE% %MAVEN_OPTS% -classpath %WRAPPER_JAR% -Dmaven.multiModuleProjectDirectory="%MAVEN_PROJECTBASEDIR%" org.apache.maven.wrapper.MavenWrapperMain %CMD_LINE_ARGS%
  ) else (
    @echo Could not locate maven-wrapper.jar, using basic mvn commands
    @call mvn %CMD_LINE_ARGS%
  )
) else (
  @echo Could not locate java.exe, please check JAVA_HOME
)

// === ARCHIVO: .mvn/wrapper/maven-wrapper.properties ===
distributionUrl=https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.6/apache-maven-3.9.6-bin.zip
wrapperUrl=https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.3.0/maven-wrapper-3.3.0.jar

// === ARCHIVO: src/main/kotlin/domain/domain/model/InventoryModel.kt ===
package domain.domain.model

import java.time.LocalDateTime
import java.util.UUID

/**
 * Tipo de operación de inventario.
 */
enum class OperationType {
    ENTRADA,
    SALIDA
}

/**
 * Representa un producto en el inventario de la bodega.
 * @property sku Identificador único del producto.
 * @property name Nombre del producto.
 * @property quantity Cantidad disponible en inventario.
 * @property maxCapacity Capacidad máxima permitida para este producto (1000 unidades).
 * @property lastUpdated Fecha y hora de la última actualización del inventario.
 */
data class InventoryItem(
    val sku: String,
    val name: String,
    val quantity: Int,
    val maxCapacity: Int = 1000,
    val lastUpdated: LocalDateTime = LocalDateTime.now()
)

/**
 * Representa una operación de entrada o salida de inventario.
 * @property id Identificador único de la operación.
 * @property productId Identificador único del producto.
 * @property quantity Cantidad a registrar (positiva para entradas, negativa para salidas).
 * @property operationType Tipo de operación (ENTRADA o SALIDA).
 * @property timestamp Fecha y hora de la operación.
 * @property performedBy Identificador del actor que realizó la operación (Administrador, Sistema de Ventas, etc.).
 */
data class InventoryOperation(
    val id: UUID = UUID.randomUUID(),
    val productId: String,
    val quantity: Int,
    val operationType: OperationType,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val performedBy: String
)

/**
 * Excepciones de negocio relacionadas con el inventario.
 */
sealed class InventoryException(message: String) : Exception(message) {
    /**
     * Se lanza cuando se intenta registrar una salida de un producto que no existe en el inventario.
     */
    class ProductNotFoundException(sku: String) :
        InventoryException("Producto con SKU $sku no encontrado en el inventario.")

    /**
     * Se lanza cuando se intenta registrar una salida que excede la cantidad disponible.
     */
    class InsufficientStockException(sku: String, requested: Int, available: Int) :
        InventoryException("Stock insuficiente para el producto $sku. Solicitado: $requested, Disponible: $available.")

    /**
     * Se lanza cuando se intenta registrar una entrada que excede la capacidad máxima de la bodega.
     */
    class CapacityExceededException(sku: String, requested: Int, maxCapacity: Int) :
        InventoryException("Capacidad excedida para el producto $sku. Solicitado: $requested, Máxima: $maxCapacity.")

    /**
     * Se lanza cuando se intenta registrar una operación con cantidad cero.
     */
    class InvalidQuantityException :
        InventoryException("La cantidad de la operación no puede ser cero.")
}

// === ARCHIVO: src/main/kotlin/domain/application/routes/InventoryRoutes.kt ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package domain.application.routes

import domain.domain.services.InventoryService
import domain.infrastructure.error.ErrorMapper
import domain.infrastructure.error.InvalidInputException
import domain.infrastructure.repositories.ExposedInventoryRepository
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

/**
 * Define las rutas de la API para operaciones de inventario.
 */
object InventoryRoutes {

    @Serializable
    data class InventoryEntryRequest(
        val productId: String,
        val quantity: Int
    )

    @Serializable
    data class InventoryEntryResponse(
        val id: String,
        val productId: String,
        val quantity: Int,
        val message: String
    )

    /**
     * Registra la ruta POST para entradas de inventario.
     */
    fun Application.registerEntry(inventoryService: InventoryService) {
        routing {
            post("/inventory/entries") {
              TODO("reto: post")
            }
        }
    }

    /**
     * Registra la ruta POST para salidas de inventario.
     */
    fun Application.registerExit(inventoryService: InventoryService) {
        routing {
            post("/inventory/exits") {
              TODO("reto: post")
            }
        }
    }

    /**
     * Registra todas las rutas de inventario.
     */
    fun Application.inventoryRoutes(inventoryService: InventoryService) {
      TODO("reto: inventoryRoutes")
    }
}

// === ARCHIVO: src/main/kotlin/domain/infrastructure/repositories/ExposedInventoryRepository.kt ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package domain.infrastructure.repositories

import domain.domain.model.InventoryOperation
import domain.domain.ports.InventoryRepositoryPort
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime
import java.util.UUID

/**
 * Implementación del repositorio de inventario usando Exposed.
 */
class ExposedInventoryRepository : InventoryRepositoryPort {

    object InventoryEntries : Table("inventory_entries") {
        val id = uuid("id")
        val sku = varchar("sku", 50)
        val quantity = integer("quantity")
        val timestamp = varchar("timestamp", 50)
        val performedBy = varchar("performed_by", 100)
    }

    init {
        transaction {
            SchemaUtils.create(InventoryEntries)
        }
    }

    override fun save(operation: InventoryOperation): UUID {
      TODO("reto: save")
    }

    override fun findBySku(sku: String): List<InventoryOperation> {
      TODO("reto: findBySku")
    }

    override fun findAll(): List<InventoryOperation> {
      TODO("reto: findAll")
    }
}

/**
 * Excepción para errores de operaciones de base de datos.
 */
class DatabaseOperationException(message: String, cause: Throwable? = null) : Exception(message, cause)

// === ARCHIVO: src/main/kotlin/domain/domain/services/InventoryService.kt ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package domain.domain.services

import domain.domain.model.InventoryOperation
import domain.domain.ports.InventoryRepositoryPort
import domain.infrastructure.error.InvalidInputException
import java.time.LocalDateTime
import java.util.UUID

/**
 * Servicio que implementa la lógica de negocio para el inventario.
 * @param repository Puerto para la persistencia de operaciones de inventario.
 */
class InventoryService(private val repository: InventoryRepositoryPort) {

    /**
     * Registra una entrada de inventario.
     * @param productId Identificador del producto.
     * @param quantity Cantidad a registrar (debe ser positiva).
     * @return UUID de la operación registrada.
     * @throws InvalidInputException si la cantidad es negativa o el productId está vacío.
     */
    fun registerEntry(productId: String, quantity: Int): UUID {
      TODO("reto: registerEntry")
    }

    /**
     * Registra una salida de inventario.
     * @param productId Identificador del producto.
     * @param quantity Cantidad a registrar (debe ser positiva para la operación).
     * @return UUID de la operación registrada.
     * @throws InvalidInputException si la cantidad es negativa o el productId está vacío.
     */
    fun registerExit(productId: String, quantity: Int): UUID {
      TODO("reto: registerExit")
    }

    /**
     * Obtiene el historial de operaciones para un producto.
     * @param sku Identificador del producto.
     * @return Lista de operaciones de inventario.
     */
    fun getHistory(sku: String): List<InventoryOperation> {
        return repository.findBySku(sku)
    }

    /**
     * Obtiene todas las operaciones de inventario.
     * @return Lista de todas las operaciones.
     */
    fun getAllOperations(): List<InventoryOperation> {
        return repository.findAll()
    }

    private fun validateInput(productId: String, quantity: Int) {
        if (productId.isBlank()) {
            throw InvalidInputException("El identificador del producto no puede estar vacío.")
        }
        if (quantity <= 0) {
            throw InvalidInputException("La cantidad debe ser un número positivo.")
        }
    }
}

// === ARCHIVO: src/main/kotlin/domain/infrastructure/error/ErrorMapper.kt ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package domain.infrastructure.error

import domain.domain.model.InventoryException
import io.ktor.server.application.*
import io.ktor.server.response.*

/**
 * Mapea excepciones de dominio a respuestas HTTP apropiadas.
 */
object ErrorMapper {

    suspend fun ApplicationCall.toHttpResponse(exception: Exception): Unit {
      TODO("reto: toHttpResponse")
    }
}

/**
 * Excepción para entradas inválidas.
 */
class InvalidInputException(message: String) : Exception(message)

/**
 * Excepción para recursos no encontrados.
 */
class ResourceNotFoundException(message: String) : Exception(message)

// === ARCHIVO: src/main/kotlin/domain/domain/ports/InventoryRepositoryPort.kt ===
package domain.domain.ports

import domain.domain.model.InventoryOperation
import java.util.UUID

/**
 * Puerto para el repositorio de inventario.
 * Define el contrato para la persistencia de operaciones de inventario,
 * permitiendo que el dominio se desacople de la implementación específica (Exposed).
 */
interface InventoryRepositoryPort {
    
    /**
     * Persiste una operación de inventario.
     * @param operation La operación a guardar (entrada o salida).
     * @return El UUID generado para la operación persistida.
     */
    fun save(operation: InventoryOperation): UUID
    
    /**
     * Busca todas las operaciones asociadas a un SKU específico.
     * @param sku Identificador único del producto.
     * @return Lista de operaciones encontradas, vacía si no hay operaciones.
     */
    fun findBySku(sku: String): List<InventoryOperation>
    
    /**
     * Recupera todas las operaciones de inventario registradas.
     * @return Lista de todas las operaciones.
     */
    fun findAll(): List<InventoryOperation>
}

// === ARCHIVO: src/main/kotlin/domain/Application.kt ===
package domain

import domain.application.routes.InventoryRoutes.inventoryRoutes
import domain.domain.model.InventoryException
import domain.domain.ports.InventoryRepositoryPort
import domain.domain.services.InventoryService
import domain.infrastructure.error.ErrorMapper.toHttpResponse
import domain.infrastructure.repositories.ExposedInventoryRepository
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.ApplicationCallPipeline
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond
import io.ktor.server.routing.routing
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("Application")

fun main() {
    logger.info("Iniciando aplicación de gestión de inventario...")
    
    val database = initializeDatabase()
    val repository: InventoryRepositoryPort = ExposedInventoryRepository()
    val inventoryService = InventoryService(repository)
    
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = {
        module(inventoryService)
    }).start(wait = true)
}

private fun initializeDatabase(): Database {
    logger.info("Inicializando base de datos H2...")
    val database = Database.connect(
        url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=MySQL",
        driver = "org.h2.Driver",
        user = "sa",
        password = ""
    )
    
    transaction(database) {
        SchemaUtils.create(ExposedInventoryRepository.InventoryEntries)
    }
    
    logger.info("Base de datos inicializada correctamente")
    return database
}

fun Application.module(inventoryService: InventoryService) {
    logger.info("Configurando módulos de Ktor...")
    
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        })
    }
    
    install(StatusPages) {
        exception<InventoryException.ProductNotFoundException> { call, cause ->
            call.respond(HttpStatusCode.NotFound, mapOf("error" to cause.message))
        }
        exception<InventoryException.InsufficientStockException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, mapOf("error" to cause.message))
        }
        exception<InventoryException.CapacityExceededException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, mapOf("error" to cause.message))
        }
        exception<InventoryException.InvalidQuantityException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, mapOf("error" to cause.message))
        }
        exception<IllegalArgumentException> { call, cause ->
            call.respond(HttpStatusCode.BadRequest, mapOf("error" to cause.message))
        }
        exception<Exception> { call, cause ->
            logger.error("Error interno del servidor: ${cause.message}", cause)
            call.respond(HttpStatusCode.InternalServerError, mapOf("error" to "Error interno del servidor"))
        }
    }
    
    routing {
        inventoryRoutes(inventoryService)
    }
    
    intercept(ApplicationCallPipeline.Plugins) {
        try {
            proceed()
        } catch (e: Exception) {
            call.toHttpResponse(e)
        }
    }
    
    logger.info("Módulos configurados correctamente")
}

// === ARCHIVO: src/main/kotlin/domain/resources/application.conf ===
ktor {
    application {
        modules = [ domain.ApplicationKt.module ]
    }
    
    server {
        host = "0.0.0.0"
        port = 8080
        watchPaths = [ "classes" ]
    }
}

database {
    url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;MODE=MySQL"
    driver = "org.h2.Driver"
    user = "sa"
    password = ""
    schema = "PUBLIC"
}

h2 {
    options {
        DB_CLOSE_DELAY = "-1"
        MODE = "MySQL"
    }
}

logging {
    level = "INFO"
    appenders {
        console {
            pattern = "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"
        }
    }
}
```
