package com.study.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topic (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    var message: String,
    val dateCreation: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val curse: Curse,
    @ManyToOne
    val author: Author,
    @Enumerated(value = EnumType.STRING)
    val status: StatusTopic = StatusTopic.NOT_RESPONDED,
    @OneToMany(mappedBy = "topic")
    val responses: List<Response> = ArrayList()
)