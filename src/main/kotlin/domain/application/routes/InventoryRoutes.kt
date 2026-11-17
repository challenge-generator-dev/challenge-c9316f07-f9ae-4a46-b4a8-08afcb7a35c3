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