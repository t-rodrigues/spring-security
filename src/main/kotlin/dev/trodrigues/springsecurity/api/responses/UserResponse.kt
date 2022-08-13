package dev.trodrigues.springsecurity.api.responses

import dev.trodrigues.springsecurity.domain.entities.User
import java.util.*

data class UserResponse(
    val id: UUID? = null,
    val name: String,
    val email: String,
    val roles: List<String>? = null
)

fun User.toResponse(): UserResponse = UserResponse(
    id = this.id,
    name = this.name,
    email = this.email,
    roles = this.roles.map { it.authority }
)
