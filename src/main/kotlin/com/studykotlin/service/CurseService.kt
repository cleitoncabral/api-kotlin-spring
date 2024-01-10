package com.studykotlin.service

import com.studykotlin.model.Curse
import org.springframework.stereotype.Service
import java.util.*

@Service
class CurseService (var curses: List<Curse>) {
    init {
        val curse = Curse (
            id = 1,
            name = "Java",
            category = "Java"
        )
        curses = Arrays.asList(curse)
    }

    fun findById (id: Long): Curse {
        return curses.stream().filter{c -> c.id == id}.findFirst().get()
    }
}
