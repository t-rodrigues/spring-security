package dev.trodrigues.springsecurity.domain.entities

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tb_roles")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid")
    val id: UUID? = null,
    val authority: String
)
