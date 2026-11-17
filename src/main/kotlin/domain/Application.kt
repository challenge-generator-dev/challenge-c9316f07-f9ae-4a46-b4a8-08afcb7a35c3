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