	package com.study

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class StudyKotlinApplication

fun main(args: Array<String>) {
	runApplication<StudyKotlinApplication>(*args)
}
