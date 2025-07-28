package com.reyaz.islamiccalendar.di

import androidx.room.Room
import com.reyaz.islamiccalendar.data.local.AppLocalDatabase
import com.reyaz.islamiccalendar.data.local.PrefDataStore.PrefDataStore
import com.reyaz.islamiccalendar.data.local.PrefDataStore.dataStore
import com.reyaz.islamiccalendar.data.local.dao.CalendarDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localModule = module {
    single { androidContext().dataStore }
    single { PrefDataStore(get()) }
    single<AppLocalDatabase> {
        Room.databaseBuilder(
            get(),
            AppLocalDatabase::class.java,
            AppLocalDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration(false)
            .build()
    }
    single<CalendarDao> { get<AppLocalDatabase>().calendarDao }
}