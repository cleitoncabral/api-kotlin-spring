package com.studykotlin.dto

import com.studykotlin.model.StatusTopic
import java.time.LocalDateTime

data class TopicView (
    val id: Long?,
    val title: String,
    val message: String,
    val status: StatusTopic,
    val dateCreation: LocalDateTime
)