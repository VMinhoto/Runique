@file:OptIn(ExperimentalFoundationApi::class)

package com.example.auth.presentation.register

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState
import com.example.auth.domain.PasswordValidationState


data class RegisterState(
    val email: TextFieldState = TextFieldState(),
    val isEmailValid: Boolean = false,
    val password: TextFieldState = TextFieldState(),
    val isPasswordVisible: Boolean = false,
    // Reference to the Password Validator in Domain
    val passwordValidationState: PasswordValidationState = PasswordValidationState(),
    // State to know while the call to register is in progress
    val isRegistering: Boolean = false,
    // State to know if pw is valid and we are not registering
    val canRegister: Boolean = false
)
