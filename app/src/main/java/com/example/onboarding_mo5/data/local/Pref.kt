package com.example.onboarding_mo5.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class Pref @Inject constructor(private val pref: SharedPreferences) {

    fun onShowed(): Boolean {
        return pref.getBoolean(SHOWED_KEY, false)
    }

    fun onBoardingShow() {
        pref.edit().putBoolean(SHOWED_KEY, true).apply()
    }

    companion object {
        const val SHOWED_KEY = "showed.key"
    }
}