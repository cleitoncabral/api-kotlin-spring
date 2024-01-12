package com.study.controller

import com.study.dto.NewTopicForm
import com.study.dto.TopicView
import com.study.dto.UpdateTopicForm
import com.study.service.TopicService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/topics")

class TopicController (private val service: TopicService) {

    @GetMapping
    fun list(): List<TopicView> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun getTopicById(@PathVariable id: Long): TopicView {
        return service.getTopicById(id)
    }

    @PostMapping
    @Transactional
    fun setTopic(@RequestBody @Valid form: NewTopicForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicView> {
        val topicView = service.setTopic(form)
        val uri = uriBuilder.path("/topics/${topicView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    fun updateTopic(@RequestBody @Valid form: UpdateTopicForm): ResponseEntity<TopicView> {
        val topicView = service.updateTopic(form)
        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deleteTopic(@PathVariable id: Long) {
        service.deleteTopic(id)
    }
}
