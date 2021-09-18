package com.appwork.fitworth.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appwork.fitworth.databinding.FragmentInternetBinding


class InternetFragment(
    private val retryListener: RetryListener
) : Fragment() {
    private lateinit var fragNoInternetBinding: FragmentInternetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragNoInternetBinding = FragmentInternetBinding.inflate(
            layoutInflater,
            container,
            false
        )
        // Inflate the layout for this fragment
        return fragNoInternetBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragNoInternetBinding.button.setOnClickListener {
            retryListener?.let {
                it.onRetry()
            }
        }
    }

    interface RetryListener {
        fun onRetry()
    }
}