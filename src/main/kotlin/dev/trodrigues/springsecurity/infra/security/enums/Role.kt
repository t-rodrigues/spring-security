package dev.trodrigues.springsecurity.infra.security.enums

enum class Role(val description: String) {

    ADMIN("ROLE_ADMIN"),
    MANAGER("ROLE_MANAGER"),
    COMMON_USER("ROLE_COMMON_USER")
}
