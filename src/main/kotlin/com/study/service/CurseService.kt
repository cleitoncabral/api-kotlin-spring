package com.study.service

import com.study.model.Curse
import com.study.repository.CurseRepository
import org.springframework.stereotype.Service

@Service
class CurseService (private val repository: CurseRepository) {
    fun findById (id: Long): Curse {
        return repository.getOne(id)
    }
}
