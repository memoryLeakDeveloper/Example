package com.example.common.preferences

import android.content.SharedPreferences

class PrefStore(sharedPreferences: SharedPreferences) {

    var isFirstLaunch by BooleanPreferencesDelegate(sharedPreferences, IS_FIRST_LAUNCH, true)
    var isSoundOn by BooleanPreferencesDelegate(sharedPreferences, IS_SOUND_ON, false)
    var deviceAddress by StringPreferencesDelegate(sharedPreferences, DEVICE_ADDRESS, "")
    var deviceName by StringPreferencesDelegate(sharedPreferences, DEVICE_NAME, "")

    companion object {
        private const val IS_FIRST_LAUNCH = "IS_FIRST_LAUNCH"
        private const val IS_SOUND_ON = "IS_SOUND_ON"
        private const val DEVICE_ADDRESS = "LAST_DEVICE"
        private const val DEVICE_NAME = "DEVICE_NAME"
    }

}