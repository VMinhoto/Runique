package com.example.run.presentation.run_overview

import com.example.run.presentation.run_overview.model.RunUi

/**
 * State class for the RunOverviewState Screen.
 * @param runs - List of [RunUi] objects.
 */
data class RunOverviewState(
    val runs: List<RunUi> = emptyList()
)
