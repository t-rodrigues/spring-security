package dev.trodrigues.springsecurity.infra.security

import dev.trodrigues.springsecurity.infra.security.dtos.TokenDto

interface TokenProvider {

    fun generateAccessToken(payload: String): TokenDto
}
