package com.study.repository

import com.study.model.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {
    fun findByCurseName(nameCurse: String, pagination: Pageable): Page<Topic>
}