package com.reyaz.islamiccalendar.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.reyaz.islamiccalendar.data.local.entity.CalDateEntity
import com.reyaz.islamiccalendar.data.local.entity.CalMonthEntity
import com.reyaz.islamiccalendar.data.local.entity.MonthWithDates

@Dao
interface CalendarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMonth(month: CalMonthEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDates(dates: List<CalDateEntity>)

    @Transaction
    @Query("SELECT * FROM cal_month WHERE month = :month AND year = :year LIMIT 1")
    suspend fun getMonthWithDates(month: Int, year: Int): MonthWithDates?

    @Query("SELECT * FROM cal_date WHERE gregorianDate = :date LIMIT 1")
    suspend fun getDate(date: String): CalDateEntity?

    @Query("SELECT EXISTS(SELECT * FROM cal_month WHERE month = :month AND year = :year)")
    suspend fun isCalExists(month: Int, year: Int): Boolean
}
