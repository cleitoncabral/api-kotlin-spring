package com.studykotlin.service

import com.studykotlin.dto.NewTopicForm
import com.studykotlin.dto.TopicView
import com.studykotlin.dto.UpdateTopicForm
import com.studykotlin.exception.NotFoundException
import com.studykotlin.mapper.TopicFormMapper
import com.studykotlin.mapper.TopicViewMapper
import com.studykotlin.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService (
    private var topics: List<Topic> = ArrayList(),
    private val topicFormMapper: TopicFormMapper,
    private val topicViewMapper: TopicViewMapper,
    private val notFoundMessage: String = "Não encontrado"
) {

    fun list(): List<TopicView> {
        return topics.stream().map { t -> topicViewMapper.map(t)}.collect(Collectors.toList())
    }

    fun getTopicById(id: Long): TopicView {
        val topic = topics.stream().filter { t ->
            t.id == id
        }.findFirst().orElseThrow{NotFoundException(notFoundMessage)}

        return topicViewMapper.map(topic)
    }

    fun setTopic(form: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        topic.id = topics.size.toLong() + 1
        topics = topics.plus(topic)
        return topicViewMapper.map(topic)
    }

    fun updateTopic(form: UpdateTopicForm): TopicView {
        val topic = topics.stream().filter{f -> f.id == form.id}.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        val updatedTopic = Topic(
            id = form.id,
            title = form.title,
            message = form.message,
            author = topic.author,
            curse = topic.curse,
            responses = topic.responses,
            status = topic.status,
            dateCreation = topic.dateCreation
        )
        topics = topics.minus(topic).plus(updatedTopic)

        return topicViewMapper.map(updatedTopic)
    }

    fun deleteTopic(id: Long) {
        val topic = topics.stream().filter{t -> t.id == id}.findFirst().orElseThrow{NotFoundException(notFoundMessage)}
        topics = topics.minus(topic)
    }


}