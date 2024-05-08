package com.example.common.ui

import java.text.SimpleDateFormat
import java.util.Date


private const val yyyyMMddHHmmPattern = "dd.MM HH:mm"

fun Long.secondsToDMY(): String {
    val date = Date(this * 1000)
    val format = SimpleDateFormat(yyyyMMddHHmmPattern)
    return format.format(date)
}

fun String.stringToDate(): String {
    if (this.isBlank() or this.isEmpty()) return ""
    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val output = SimpleDateFormat(yyyyMMddHHmmPattern)
    return output.format(sdf.parse(this) ?: 0)
}
