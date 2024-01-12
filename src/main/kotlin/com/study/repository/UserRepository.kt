package com.study.repository

import com.study.model.Author
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<Author, Long> {
}