package com.appwork.fitworth.prefshelper

import android.content.Context
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.appwork.fitworth.helper.Constants.PREFS_NAME
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

/**
 * Created by Vivek Kumar belongs to APP WORK  on 22-09-2021.
 */
class DataStorePref @Inject constructor(
    @ApplicationContext private val context: Context
) : SharedPreferencesDelegate {
    private val Context.dataStore by preferencesDataStore(PREFS_NAME)

    override suspend fun saveStringPref(key: String, value: String) {
        context.dataStore.setValue(
            stringPreferencesKey(key),
            value
        )
    }

    override suspend fun getStringPref(key: String, defValue: String): String {
        return context.dataStore.getFlowValue(
            stringPreferencesKey(key),
            defValue
        )
    }

    override suspend fun saveIntPref(key: String, value: Int) {
        context.dataStore.setValue(
            intPreferencesKey(key),
            value
        )
    }

    override suspend fun getIntPref(key: String, defValue: Int): Int {
       return context.dataStore.getFlowValue(
            intPreferencesKey(key),
            defValue
        )
    }

    override suspend fun saveLongPref(key: String, value: Long) {
        context.dataStore.setValue(
            longPreferencesKey(key),
            value
        )
    }

    override suspend fun getLongPref(key: String, defValue: Long): Long {
       return context.dataStore.getFlowValue(
            longPreferencesKey(key),
            defValue
        )
    }

    override suspend fun saveFloatPref(key: String, value: Float) {
        context.dataStore.setValue(
            floatPreferencesKey(key),
            value
        )
    }

    override suspend fun getFloatPref(key: String, defValue: Float): Float {
       return context.dataStore.getFlowValue(
            floatPreferencesKey(key),
            defValue
        )
    }
}