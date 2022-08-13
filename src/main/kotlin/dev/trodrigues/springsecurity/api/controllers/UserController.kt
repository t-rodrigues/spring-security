package dev.trodrigues.springsecurity.api.controllers

import dev.trodrigues.springsecurity.api.responses.UserResponse
import dev.trodrigues.springsecurity.api.responses.toResponse
import dev.trodrigues.springsecurity.domain.entities.User
import dev.trodrigues.springsecurity.domain.services.UserService
import dev.trodrigues.springsecurity.infra.security.authorizations.UserCanOnlyAccessTheirOwnResource
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/users")
class UserController(
    private val userService: UserService
) {

    @GetMapping
    fun getUsers(): List<UserResponse> {
        return userService.findAll().map { it.toResponse() }
    }

    @UserCanOnlyAccessTheirOwnResource
    @GetMapping("/{userId}")
    fun getUserById(@PathVariable userId: UUID): UserResponse {
        return userService.findById(userId).toResponse()
    }

    @PostMapping
    fun createUser(@RequestBody user: User): UserResponse {
        return userService.create(user).toResponse()
    }
}
