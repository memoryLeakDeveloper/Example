package com.example.feature.player.profile

interface Mapper<T, V> {

    fun mapTo(first: T): V
}