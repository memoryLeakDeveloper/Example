package com.example.common.mapping

interface UiToDomainMapper<in T : UiModel, out V : DomainModel> {

    fun mapToDomain(ui: T): V
}