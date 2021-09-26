package com.appwork.fitworth.prefshelper

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first

/**
 * Created by Vivek Kumar belongs to APP WORK  on 22-09-2021.
 */

suspend fun <T> DataStore<Preferences>.getFlowValue(
    key: Preferences.Key<T>,
    defaultValue: T
): T {
    return this.data.first()[key] ?: defaultValue
    /* .catch { exception ->
         if (exception is IOException) {
             emit(emptyPreferences())
         } else {
             throw exception
         }
     }.map { preferences ->
         preferences[key] ?: defaultValue
     }*/
}

suspend fun <T> DataStore<Preferences>.setValue(
    key: Preferences.Key<T>,
    value: T
) {
    this.edit { preferences ->
        preferences[key] = value
    }
}