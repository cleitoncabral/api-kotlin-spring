package com.studykotlin.model

import java.time.LocalDateTime

data class Response (
        val id: Long? = null,
        val message: String,
        val dataCreate: LocalDateTime = LocalDateTime.now(),
        val author: User,
        val topic: Topic,
        val solution: Boolean
    )
