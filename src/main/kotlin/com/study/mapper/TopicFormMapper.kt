package com.study.mapper

import com.study.dto.NewTopicForm
import com.study.model.Topic
import com.study.service.CurseService
import com.study.service.UserService
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