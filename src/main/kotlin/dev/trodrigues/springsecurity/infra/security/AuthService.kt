package dev.trodrigues.springsecurity.infra.security

import dev.trodrigues.springsecurity.api.requests.AuthRequest

interface AuthService {

    fun signIn(authRequest: AuthRequest): TokenDto
}
