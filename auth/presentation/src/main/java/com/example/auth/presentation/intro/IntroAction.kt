package com.example.auth.presentation.intro

/*
    Sealed class representing the Actions the user can have on the intro screen.
    These actions are: Signing In ou Signing Up
 */
sealed interface IntroAction {
    data object OnSignInClick: IntroAction
    data object OnSignUpClick: IntroAction
}