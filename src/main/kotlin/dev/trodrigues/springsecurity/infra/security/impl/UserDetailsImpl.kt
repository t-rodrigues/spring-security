package dev.trodrigues.springsecurity.infra.security.impl

import dev.trodrigues.springsecurity.domain.entities.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetailsImpl(private val user: User) : UserDetails {

    val id = user.id!!

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        user.roles.map { SimpleGrantedAuthority(it.authority) }.toMutableSet()

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}
