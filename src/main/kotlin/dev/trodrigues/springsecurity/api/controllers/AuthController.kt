package dev.trodrigues.springsecurity.api.controllers

import dev.trodrigues.springsecurity.api.controllers.requests.AuthRequest
import dev.trodrigues.springsecurity.infra.security.AuthService
import dev.trodrigues.springsecurity.infra.security.TokenDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(
    private val authService: AuthService
) {

    @PostMapping("/login")
    fun authenticate(@RequestBody authRequest: AuthRequest): TokenDto {
        return authService.signIn(authRequest)
    }
}
