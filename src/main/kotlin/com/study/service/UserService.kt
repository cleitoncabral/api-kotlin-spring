package com.study.service

import com.study.model.Author
import com.study.repository.UserRepository

import org.springframework.stereotype.Service

@Service
class UserService (private val repository: UserRepository) {
    fun findById (id: Long): Author {
        return repository.getOne(id)
    }
}
