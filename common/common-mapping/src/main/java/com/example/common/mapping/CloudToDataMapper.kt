package com.example.common.mapping

interface CloudToDataMapper<in T : CloudModel, out V : DataModel> {

    fun mapToData(cloud: T): V
}