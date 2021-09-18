package com.appwork.fitworth.helper

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Vivek Kumar belongs to APP WORK  on 18-09-2021.
 */
class InternetUtil {
    object InternetConnection {
        fun checkConnection(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo?.isConnected == true
        }
    }
}