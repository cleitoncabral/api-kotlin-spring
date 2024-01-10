package com.studykotlin.mapper

import com.studykotlin.dto.NewTopicForm
import com.studykotlin.model.Topic
import com.studykotlin.service.CurseService
import com.studykotlin.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(private val userService: UserService, private val curseService: CurseService): Mapper<NewTopicForm, Topic> {
    override fun map(t: NewTopicForm): Topic {
        return Topic(
            title = t.title,
            message = t.message,
            curse = curseService.findById(t.idCurse),
            author = userService.findById(t.idAuthor)
        )
    }
}