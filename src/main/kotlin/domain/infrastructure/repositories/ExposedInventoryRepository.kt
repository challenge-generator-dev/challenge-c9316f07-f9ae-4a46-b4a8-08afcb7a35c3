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