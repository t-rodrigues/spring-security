package dev.trodrigues.springsecurity.main.configs

import dev.trodrigues.springsecurity.infra.security.filters.AuthorizationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig(
    private val authorizationFilter: AuthorizationFilter
) {

    companion object {
        val PUBLIC_POST_MATCHERS = arrayOf("/auth/login", "/users")
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf().disable()
            .authorizeHttpRequests { auth ->
                auth.antMatchers(HttpMethod.POST, *PUBLIC_POST_MATCHERS).permitAll()
                auth.anyRequest().authenticated()
            }
            .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter::class.java)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager =
        authenticationConfiguration.authenticationManager
}
