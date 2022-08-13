package dev.trodrigues.springsecurity.domain.services

import dev.trodrigues.springsecurity.domain.entities.User
import java.util.*

interface UserService {

    fun findAll(): List<User>

    fun create(user: User): User

    fun findById(userId: UUID): User
}
