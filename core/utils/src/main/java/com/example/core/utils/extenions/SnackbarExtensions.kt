package com.example.core.utils.extenions

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals

class SnackbarVisualsWithError(override val message: String, override val duration: SnackbarDuration = SnackbarDuration.Short) : SnackbarVisuals {
    override val actionLabel: String
        get() = "OK"
    override val withDismissAction: Boolean
        get() = true

}
