package com.study.service

import com.study.model.Author
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class UserDetail (private val user: Author): UserDetails {
    override fun getAuthorities() = user.role

    override fun getPassword() = user.password
    override fun getUsername() = user.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}