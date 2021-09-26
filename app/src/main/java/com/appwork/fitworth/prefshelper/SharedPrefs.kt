package com.appwork.fitworth.prefshelper

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Created by Vivek Kumar belongs to APP WORK  on 26-09-2021.
 */
class SharedPrefs(
    @ApplicationContext private val context: Context
) : SharedPreferencesDelegate {
    companion object {
        const val SHARED_PREFS = "share_prefs_fit_worth"
    }

    private lateinit var prefs: SharedPreferences
    private var editor: SharedPreferences.Editor

    init {
        context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        editor = prefs.edit()
    }

    override suspend fun saveStringPref(key: String, value: String) {
        editor.apply() {
            putString(key, value)
            apply()
        }
    }

    override suspend fun getStringPref(key: String, defValue: String): String {
        return prefs.getString(key, defValue) ?: defValue
    }

    override suspend fun saveIntPref(key: String, value: Int) {
        editor.apply() {
            putInt(key, value)
            apply()
        }
    }

    override suspend fun getIntPref(key: String, defValue: Int): Int {
        return prefs.getInt(key, defValue) ?: defValue
    }

    override suspend fun saveLongPref(key: String, value: Long) {
        editor.apply() {
            putLong(key, value)
            apply()
        }
    }

    override suspend fun getLongPref(key: String, defValue: Long): Long {
        return prefs.getLong(key, defValue) ?: defValue
    }

    override suspend fun saveFloatPref(key: String, value: Float) {
        editor.apply() {
            putFloat(key, value)
            apply()
        }
    }

    override suspend fun getFloatPref(key: String, defValue: Float): Float {
        return prefs.getFloat(key, defValue) ?: defValue
    }

}