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