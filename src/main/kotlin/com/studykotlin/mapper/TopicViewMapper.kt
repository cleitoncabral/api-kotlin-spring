package com.studykotlin.mapper

import com.studykotlin.dto.TopicView
import com.studykotlin.model.Topic
import org.springframework.stereotype.Component

@Component
class TopicViewMapper: Mapper<Topic, TopicView> {
    override fun map(t: Topic): TopicView {
        return TopicView (
            id = t.id,
            title = t.title,
            message = t.message,
            dateCreation = t.dateCreation,
            status = t.status
        )
    }
}