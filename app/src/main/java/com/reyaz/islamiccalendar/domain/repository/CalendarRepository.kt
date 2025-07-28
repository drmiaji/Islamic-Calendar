package com.reyaz.islamiccalendar.domain.repository

import com.reyaz.islamiccalendar.domain.model.CompleteCalendar
import kotlinx.coroutines.flow.Flow

interface CalendarRepository {
    fun observeCalendar(month: Int?, year: Int?): Flow<Result<CompleteCalendar>>
    suspend fun getHijriCalendarWithGeorgianAndSave(month: Int, year: Int,
                                                    shouldSaveExpiry: Boolean): Result<Unit>
}