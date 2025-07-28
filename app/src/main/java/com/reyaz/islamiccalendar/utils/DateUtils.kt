package com.reyaz.islamiccalendar.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

fun Long.toFormattedDateTime(
    pattern: String = "dd MMMM yyyy, hh:mm:ss a",
    zoneId: ZoneId = ZoneId.systemDefault()
): String {
    val instant = Instant.ofEpochMilli(this)
    val formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH)
    return instant.atZone(zoneId).format(formatter)
}