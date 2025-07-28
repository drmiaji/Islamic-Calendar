package com.reyaz.islamiccalendar.data.local.PrefDataStore

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.reyaz.islamiccalendar.utils.toFormattedDateTime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "app_preferences")

private const val TAG = "PREF_DATA_STORE"
class PrefDataStore(private val dataStore: DataStore<Preferences>) {
    companion object {
        private val KEY_EXPIRED_TIMESTAMP = longPreferencesKey("expired_date")
        private val CURR_HIJRI_MONTH = intPreferencesKey("curr_hijri_month")
        private val CURR_HIJRI_YEAR = intPreferencesKey("curr_hijri_year")
    }

    val expiredTimestamp = dataStore.data.map { pref ->
        pref[KEY_EXPIRED_TIMESTAMP] ?: 0
    }

    val hijriMonth = dataStore.data.map { pref ->
        pref[CURR_HIJRI_MONTH]
    }

    val hijriYear = dataStore.data.map { pref ->
        pref[CURR_HIJRI_YEAR]
    }


    suspend fun setExpiryDate(timestamp: Long){
        Log.d(TAG, "setExpiryDate: ${timestamp.toFormattedDateTime()}")
        dataStore.edit { pref ->
            pref[KEY_EXPIRED_TIMESTAMP] = timestamp
        }
    }

    suspend fun setCurrHijriMonth(month: Int){
        dataStore.edit { pref ->
            pref[CURR_HIJRI_MONTH] = month
        }
    }

    suspend fun setCurrHijriYear(year: Int){
        dataStore.edit {
            pref -> pref[CURR_HIJRI_YEAR] = year
        }
    }
}