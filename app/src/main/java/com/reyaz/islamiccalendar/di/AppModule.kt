package com.reyaz.islamiccalendar.di

import com.reyaz.islamiccalendar.data.repository.CalendarRepositoryImpl
import com.reyaz.islamiccalendar.domain.repository.CalendarRepository
import com.reyaz.islamiccalendar.ui.screen.calendar.CalendarViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<CalendarRepository>{CalendarRepositoryImpl(get(), get(), get(), get())}
    viewModel { CalendarViewModel(get()) }
}