package dev.trodrigues.springsecurity.infra.repositories

import dev.trodrigues.springsecurity.domain.entities.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RoleRepository : JpaRepository<Role, UUID> {

    fun getReferenceByAuthority(authority: String): Role
}
