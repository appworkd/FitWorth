package com.appwork.fitworth.br

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.appwork.fitworth.helper.InternetUtil

/**
 * Created by Vivek Kumar belongs to APP WORK  on 18-09-2021.
 */
class InternetReceiver(
    private val internetCallback: InternetConnectionCallback
) : BroadcastReceiver() {

    companion object {
        const val TAG = "InternetReceiver"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        internetCallback.isConnected(InternetUtil.InternetConnection.checkConnection(context!!))
    }

    interface InternetConnectionCallback {
        fun isConnected(isConnected: Boolean)
    }
}

