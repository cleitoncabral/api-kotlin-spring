package com.studykotlin.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class UpdateTopicForm (
    @field:NotNull val id: Long,
    @field:NotNull @field:Size(min = 5, max = 1000) val title: String,
    @field:NotEmpty val message: String
)
