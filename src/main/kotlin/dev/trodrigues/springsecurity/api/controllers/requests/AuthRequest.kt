package dev.trodrigues.springsecurity.api.controllers.requests

data class AuthRequest(
    val email: String? = null,
    val password: String? = null
)
