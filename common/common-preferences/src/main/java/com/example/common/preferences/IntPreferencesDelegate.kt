package com.example.common.preferences

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class IntPreferencesDelegate(
    private val preferences: SharedPreferences,
    private val name: String,
    private val defValue: Int
) : ReadWriteProperty<Any?, Int?> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return preferences.getInt(name, defValue)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int?) {
        preferences.edit().putInt(name, value ?: 0).apply()
    }

}