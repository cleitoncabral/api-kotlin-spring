	package com.study

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StudyKotlinApplication

fun main(args: Array<String>) {
	runApplication<StudyKotlinApplication>(*args)
}