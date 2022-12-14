package dev.trodrigues.springsecurity.infra.security.impl

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import dev.trodrigues.springsecurity.infra.security.TokenProvider
import dev.trodrigues.springsecurity.infra.security.dtos.TokenDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class JwtTokenProviderImpl(
    @Value("\${app.jwt.secret-key}")
    private val secretKey: String,
    @Value("\${app.jwt.expires-in}")
    private val expiresInMs: Long
) : TokenProvider {

    private val algorithm = Algorithm.HMAC256(secretKey.toByteArray())

    override fun generateAccessToken(payload: String): TokenDto {
        val now = Instant.now()
        val accessToken = getAccessToken(payload, now.plusMillis(expiresInMs))
        return TokenDto(accessToken)
    }

    override fun getUsername(token: String): String = decodedToken(token).subject

    override fun isValidToken(token: String): Boolean {
        return try {
            decodedToken(token)
            true
        } catch (_: Exception) {
            false
        }
    }

    private fun getAccessToken(subject: String, expiresIn: Instant): String =
        JWT.create().withIssuedAt(Instant.now())
            .withExpiresAt(expiresIn)
            .withSubject(subject).sign(algorithm).trim()

    private fun decodedToken(token: String): DecodedJWT =
        JWT.require(algorithm).build().verify(token)
}
