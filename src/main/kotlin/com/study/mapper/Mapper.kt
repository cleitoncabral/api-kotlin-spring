package com.study.mapper

interface Mapper<T, U> {
    fun map (t: T): U
}
