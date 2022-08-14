package dev.trodrigues.springsecurity.api.requests

data class AuthRequest(
    val email: String? = null,
    val password: String? = null
)
