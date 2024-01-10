package com.studykotlin.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class NewTopicForm (
    @field:NotEmpty @field:Size(min = 5, max = 1000, message = "Título deve ser maior que 5") val title: String,
    @field:NotEmpty (message = "Mensagem não pode ser vazia") val message: String,
    @field:NotNull val idCurse: Long,
    @field:NotNull val idAuthor: Long
)