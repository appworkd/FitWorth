package com.appwork.fitworth.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.appwork.fitworth.databinding.FragmentIntroductionBinding
import com.appwork.fitworth.helper.Constants.IS_SHOWED
import com.appwork.fitworth.prefshelper.DataStorePref
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class IntroductionFragment
    : Fragment() {
    @Inject
    lateinit var pref: DataStorePref

    lateinit var vbIntro: FragmentIntroductionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        lifecycleScope.launch {
            pref.saveBooleanPref(IS_SHOWED, true)
        }
        vbIntro = FragmentIntroductionBinding.inflate(inflater, container, false)

        return vbIntro.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}