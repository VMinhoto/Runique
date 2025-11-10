package com.example.run.presentation.run_overview

import com.example.run.presentation.run_overview.model.RunUi

sealed interface RunOverviewAction {
    data object onStartClick: RunOverviewAction
    data object OnLogoutClick: RunOverviewAction
    data object OnAnalyticsClick: RunOverviewAction
    data class deleteRun(val runUi: RunUi): RunOverviewAction
}