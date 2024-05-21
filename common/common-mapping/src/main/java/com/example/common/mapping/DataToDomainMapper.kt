package com.example.common.mapping

interface DataToDomainMapper<in T : DataModel, out V : DomainModel> {

    fun mapToDomain(data: T): V
}