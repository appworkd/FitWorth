package com.appwork.fitworth.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.appwork.fitworth.MainActivity
import com.appwork.fitworth.R
import com.appwork.fitworth.helper.Constants.IS_SHOWED
import com.appwork.fitworth.prefshelper.DataStorePref
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    @Inject
    lateinit var pref: DataStorePref

    companion object {
        const val DELAY_TIME = 2000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lifecycleScope.launch {
            delay(DELAY_TIME)
                startActivity(
                    Intent(
                        this@SplashActivity,
                        MainActivity::class.java
                    )
                )
            finish()
        }
    }
}