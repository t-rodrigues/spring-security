package dev.trodrigues.springsecurity.infra.security

interface TokenProvider {

    fun generateAccessToken(payload: String): TokenDto
}
