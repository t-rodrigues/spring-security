package dev.trodrigues.springsecurity.infra.security

import dev.trodrigues.springsecurity.api.requests.AuthRequest
import dev.trodrigues.springsecurity.infra.security.dtos.TokenDto

interface AuthService {

    fun signIn(authRequest: AuthRequest): TokenDto
}
