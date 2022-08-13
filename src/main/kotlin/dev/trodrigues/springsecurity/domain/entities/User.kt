package dev.trodrigues.springsecurity.domain.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tb_users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid")
    val id: UUID? = null,
    val name: String,
    val email: String,
    val password: String,
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "tb_users_roles",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    val roles: Set<Role> = setOf()
)
