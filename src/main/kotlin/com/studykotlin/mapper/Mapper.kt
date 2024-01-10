package com.studykotlin.mapper

interface Mapper<T, U> {
    fun map (t: T): U
}
