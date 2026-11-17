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