package com.example.auth.presentation.register

import com.example.core.presentation.ui.UiText

/*
Sealed interface with all possible user actions on Register Screen
 */
sealed interface RegisterEvent {
    data object RegistrationSuccess: RegisterEvent
    data class Error(val error: UiText): RegisterEvent

}