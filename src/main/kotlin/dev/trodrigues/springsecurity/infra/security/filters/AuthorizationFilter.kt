package dev.trodrigues.springsecurity.infra.security.filters

import dev.trodrigues.springsecurity.infra.security.TokenProvider
import dev.trodrigues.springsecurity.infra.security.exceptions.AuthenticationException
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class AuthorizationFilter(
    private val tokenProvider: TokenProvider,
    private val userDetailsService: UserDetailsService
) : OncePerRequestFilter() {

    companion object {
        const val TOKEN_PREFIX = "Bearer "
    }

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val header = request.getHeader(HttpHeaders.AUTHORIZATION)
        if (!header.isNullOrBlank() && header.startsWith(TOKEN_PREFIX)) {
            val token = header.replace(TOKEN_PREFIX, "")
            val authentication = getAuthentication(token)
            SecurityContextHolder.getContext().authentication = authentication
        }
        filterChain.doFilter(request, response)
    }

    private fun getAuthentication(token: String): UsernamePasswordAuthenticationToken {
        if (!tokenProvider.isValidToken(token))
            throw AuthenticationException("invalid token")
        val username = tokenProvider.getUsername(token)
        val userDetails = userDetailsService.loadUserByUsername(username)
        return UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
    }
}
