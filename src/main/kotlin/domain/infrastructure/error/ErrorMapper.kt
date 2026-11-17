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