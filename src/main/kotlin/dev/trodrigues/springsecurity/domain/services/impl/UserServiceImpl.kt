package dev.trodrigues.springsecurity.domain.services.impl

import dev.trodrigues.springsecurity.domain.entities.User
import dev.trodrigues.springsecurity.domain.services.UserService
import dev.trodrigues.springsecurity.infra.repositories.RoleRepository
import dev.trodrigues.springsecurity.infra.repositories.UserRepository
import dev.trodrigues.springsecurity.infra.security.enums.Role
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder
) : UserService {

    override fun findAll(): List<User> {
        return userRepository.findAll()
    }

    override fun create(user: User): User {
        val password = passwordEncoder.encode(user.password)
        val role = roleRepository.getReferenceByAuthority(Role.COMMON_USER.description)
        return userRepository.save(user.copy(password = password, roles = setOf(role)))
    }

    override fun findById(userId: UUID): User {
        return userRepository.findById(userId).orElseThrow { IllegalArgumentException("user not found") }
    }
}
