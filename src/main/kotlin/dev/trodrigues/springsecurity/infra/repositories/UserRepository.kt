package dev.trodrigues.springsecurity.infra.repositories

import dev.trodrigues.springsecurity.domain.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : JpaRepository<User, UUID> {

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles")
    override fun findAll(): List<User>

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE u.id = :id")
    override fun findById(id: UUID): Optional<User>

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.roles WHERE UPPER(u.email) = UPPER(:email)")
    fun findByEmailIgnoreCase(email: String): User?
}
