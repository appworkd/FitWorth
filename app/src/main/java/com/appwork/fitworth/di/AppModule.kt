package com.appwork.fitworth.di

import android.content.Context
import com.appwork.fitworth.prefshelper.DataStorePref
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Vivek Kumar belongs to APP WORK  on 21-09-2021.
 */


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun getDataStorePref(
        @ApplicationContext context: Context
    ) = DataStorePref(context)
}