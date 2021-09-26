package com.appwork.fitworth.prefshelper

/**
 * Created by Vivek Kumar belongs to APP WORK  on 22-09-2021.
 */
interface SharedPreferencesDelegate {

    suspend fun saveStringPref(key: String, value: String)

    suspend fun getStringPref(key: String, defValue: String): String

    suspend fun saveIntPref(key: String, value: Int)

    suspend fun getIntPref(key: String, defValue: Int): Int

    suspend fun saveLongPref(key: String, value: Long)

    suspend fun getLongPref(key: String, defValue: Long): Long

    suspend fun saveFloatPref(key: String, value: Float)

    suspend fun getFloatPref(key: String, defValue: Float): Float

}