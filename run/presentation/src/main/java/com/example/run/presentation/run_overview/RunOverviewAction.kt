package com.example.run.presentation.run_overview

sealed interface RunOverviewAction {
    data object onStartClick: RunOverviewAction
    data object OnLogoutClick: RunOverviewAction
    data object OnAnalyticsClick: RunOverviewAction
}