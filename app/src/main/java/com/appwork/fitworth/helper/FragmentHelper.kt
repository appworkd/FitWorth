package com.appwork.fitworth.helper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Created by Vivek Kumar belongs to APP WORK  on 18-09-2021.
 */
object FragmentHelper {
    fun addFragment(
        fm: FragmentManager,
        fragment: Fragment,
        tag: String,
        containerId: Int
    ) {
        fm.beginTransaction()
            .add(containerId, fragment)
            .addToBackStack(tag)
            .commit()
    }

    fun replaceFragment(
        fm: FragmentManager,
        fragment: Fragment,
        tag: String,
        containerId: Int
    ) {
        fm.beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(tag)
            .commit()
    }

    fun popAllFragments(
        fm: FragmentManager
    ) {
        if (fm.fragments.isNotEmpty()) {
            fm.popBackStack()
        }

    }
}