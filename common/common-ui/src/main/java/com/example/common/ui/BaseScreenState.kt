package com.example.common.ui

abstract class BaseScreenState(
    open val isLoading: Boolean = false,
    open val isError: Boolean = false,
    open val error: Throwable? = null
)