package dev.trodrigues.springsecurity.infra.security.impl

import dev.trodrigues.springsecurity.api.requests.AuthRequest
import dev.trodrigues.springsecurity.infra.security.AuthService
import dev.trodrigues.springsecurity.infra.security.TokenProvider
import dev.trodrigues.springsecurity.infra.security.dtos.TokenDto
import dev.trodrigues.springsecurity.infra.security.exceptions.AuthenticationException
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Service

@Service
class AuthServiceImpl(
    private val authenticationManager: AuthenticationManager,
    private val tokenProvider: TokenProvider
) : AuthService {
    override fun signIn(authRequest: AuthRequest): TokenDto {
        return try {
            val authentication = UsernamePasswordAuthenticationToken(authRequest.email, authRequest.password)
            authenticationManager.authenticate(authentication)
            tokenProvider.generateAccessToken(authentication.principal!! as String)
        } catch (_: Exception) {
            throw AuthenticationException("Invalid username or password")
        }
    }
}
