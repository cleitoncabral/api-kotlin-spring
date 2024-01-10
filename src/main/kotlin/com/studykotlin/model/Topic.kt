package com.studykotlin.model

import java.time.LocalDateTime

data class Topic (
    var id: Long? = null,
    val title: String,
    val message: String,
    val dateCreation: LocalDateTime = LocalDateTime.now(),
    val curse: Curse,
    val author: User,
    val status: StatusTopic = StatusTopic.NOT_RESPONDED,
    val responses: List<Response> = ArrayList()
)