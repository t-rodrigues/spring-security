package dev.trodrigues.springsecurity.api.controllers

import dev.trodrigues.springsecurity.api.requests.AuthRequest
import dev.trodrigues.springsecurity.infra.security.AuthService
import dev.trodrigues.springsecurity.infra.security.dtos.TokenDto
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
    fun authenticate(@RequestBody authRequest: AuthRequest): TokenDto = authService.signIn(authRequest)
}
