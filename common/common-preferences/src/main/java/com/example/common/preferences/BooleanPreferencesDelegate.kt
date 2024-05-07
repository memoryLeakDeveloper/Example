package com.example.common.preferences

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BooleanPreferencesDelegate(
    private val preferences: SharedPreferences,
    private val name: String,
    private val defValue: Boolean
) : ReadWriteProperty<Any?, Boolean?> {

    override fun getValue(thisRef: Any?, property: KProperty<*>): Boolean {
        return preferences.getBoolean(name, defValue)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean?) {
        preferences.edit().putBoolean(name, value ?: true).apply()
    }

}