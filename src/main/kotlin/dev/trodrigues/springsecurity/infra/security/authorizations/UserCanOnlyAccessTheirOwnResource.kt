package dev.trodrigues.springsecurity.infra.security.authorizations

import org.springframework.security.access.prepost.PreAuthorize

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@PreAuthorize("hasRole('ADMIN') || #userId == authentication.principal.id")
annotation class UserCanOnlyAccessTheirOwnResource()
