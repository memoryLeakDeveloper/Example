package com.example.common.preferences

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringPreferencesDelegate(
    private val preferences: SharedPreferences,
    private val name: String,
    private val defValue: String
) : ReadWriteProperty<Any?, String?> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return preferences.getString(name, defValue) ?: ""
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
        preferences.edit().putString(name, value).apply()
    }

}