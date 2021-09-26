package com.appwork.fitworth

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.appwork.fitworth.config.BaseActivity
import com.appwork.fitworth.databinding.ActivityMainBinding
import com.appwork.fitworth.helper.Constants.IS_SHOWED
import com.appwork.fitworth.prefshelper.DataStorePref
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @Inject
    lateinit var pref :DataStorePref
    private val vbMain by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vbMain.root)

    }
}