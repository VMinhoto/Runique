package com.example.auth.presentation.register

/*
Sealed interface with all possible user actions on Register Screen
 */
sealed interface RegisterAction {
    data object OnTogglePasswordVisibilityClick: RegisterAction
    data object OnLogicClick: RegisterAction
    data object OnRegisterClick: RegisterAction
}