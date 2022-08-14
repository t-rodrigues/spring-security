package dev.trodrigues.springsecurity.infra.security.impl

import dev.trodrigues.springsecurity.infra.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component

@Component
class UserDetailsServiceImpl(
    private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByEmailIgnoreCase(username)
            ?: throw UsernameNotFoundException("Username not found $username")
        return UserDetailsImpl(user)
    }
}
