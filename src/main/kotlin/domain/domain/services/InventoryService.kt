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