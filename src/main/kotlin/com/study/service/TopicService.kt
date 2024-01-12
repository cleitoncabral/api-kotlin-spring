package com.study.service

import com.study.dto.NewTopicForm
import com.study.dto.TopicView
import com.study.dto.UpdateTopicForm
import com.study.exception.NotFoundException
import com.study.mapper.TopicFormMapper
import com.study.mapper.TopicViewMapper
import com.study.repository.TopicRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService (
    private var repository: TopicRepository,
    private val topicFormMapper: TopicFormMapper,
    private val topicViewMapper: TopicViewMapper,
    private val notFoundMessage: String = "Não encontrado"
) {

    fun list(): List<TopicView> {
        return repository.findAll().stream().map { t -> topicViewMapper.map(t)}.collect(Collectors.toList())
    }

    fun getTopicById(id: Long): TopicView {
        val topic = repository.findById(id).orElseThrow{NotFoundException(notFoundMessage)}

        return topicViewMapper.map(topic)
    }

    fun setTopic(form: NewTopicForm): TopicView {
        val topic = topicFormMapper.map(form)
        repository.save(topic)
        return topicViewMapper.map(topic)
    }

    fun updateTopic(form: UpdateTopicForm): TopicView {
        val topic = repository.findById(form.id).orElseThrow{NotFoundException(notFoundMessage)}
        topic.title = form.title
        topic.message = topic.message
        return topicViewMapper.map(topic)
    }

    fun deleteTopic(id: Long) {
        repository.deleteById(id)
    }


}