package com.study.repository

import com.study.model.Curse
import org.springframework.data.jpa.repository.JpaRepository

interface CurseRepository: JpaRepository<Curse, Long> {
}