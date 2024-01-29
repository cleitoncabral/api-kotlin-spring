package com.study.config

import com.study.model.Role
import com.study.service.UserService
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*


@Component
class JWTUtil (
    private val userService: UserService
) {
    @Value("\${jwt.secret}")
    private lateinit var secret: String

    @Value("\${jwt.expiration}")
    private lateinit var expiration: String

    val key = Keys.secretKeyFor(SignatureAlgorithm.HS512)

    fun generateToken(username: String, authorities: List<Role>): String? {
        val now = Date()
        val expiryDate = Date(now.time + expiration.toLong())
        return Jwts.builder().claim("sub", username).claim("role", authorities).setExpiration(expiryDate).signWith(key).compact()
    }

    fun isValid(jwt: String?): Boolean {
        return try {
            Jwts.parser().setSigningKey(key).build().parseSignedClaims(jwt)
            true
        } catch (e: IllegalFormatException) {
            false
        }
    }


    fun getAuthentication(jwt: String?): Authentication {
        val username = Jwts.parser().setSigningKey(key).build().parseSignedClaims(jwt).payload.subject
        val user = userService.loadUserByUsername(username)
        return UsernamePasswordAuthenticationToken(username, null, user.authorities)
    }

}