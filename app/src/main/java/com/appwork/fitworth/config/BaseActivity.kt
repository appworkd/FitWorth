package com.appwork.fitworth.config

import android.content.IntentFilter
import android.net.ConnectivityManager.CONNECTIVITY_ACTION
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appwork.fitworth.R
import com.appwork.fitworth.br.InternetReceiver
import com.appwork.fitworth.br.InternetReceiver.InternetConnectionCallback
import com.appwork.fitworth.helper.Constants
import com.appwork.fitworth.helper.FragmentHelper
import com.appwork.fitworth.helper.InternetUtil
import com.appwork.fitworth.view.InternetFragment
import com.appwork.fitworth.view.InternetFragment.RetryListener


abstract class BaseActivity : AppCompatActivity(), RetryListener {

    private val fm by lazy {
        supportFragmentManager
    }
    private var isNoInternetVisible = false
    private val networkListener = object : InternetConnectionCallback {
        override fun isConnected(isConnected: Boolean) {
            updateNetworkStatus(isConnected)
        }
    }

    private fun updateNetworkStatus(isConnected: Boolean) {
        if (isConnected) {
            FragmentHelper.popAllFragments(
                fm
            )
            isNoInternetVisible = false
        } else {
            if (!isNoInternetVisible) {
                FragmentHelper.replaceFragment(
                    fm,
                    InternetFragment(this),
                    Constants.INTERNET_FRAGMENT,
                    R.id.mainActivityContainer
                )
                isNoInternetVisible = true
            }
        }
    }

    private val internetReceiver by lazy {
        InternetReceiver(networkListener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    //abstract fun showInternetScreen(isConnected: Boolean)


    override fun onStart() {
        super.onStart()
        registerReceiver(
            internetReceiver,
            IntentFilter(CONNECTIVITY_ACTION)
        )
    }

    private fun retryConnection() {
        updateNetworkStatus(InternetUtil.InternetConnection.checkConnection(this))
    }

    override fun onPause() {
        super.onPause()
        internetReceiver?.let {
            unregisterReceiver(it)
        }
    }

    override fun onStop() {
        super.onStop()

    }

    override fun onRetry() {
        retryConnection()
    }

}