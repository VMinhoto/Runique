package com.example.run.presentation.active_run

import com.example.core.domain.location.Location
import com.example.run.domain.RunData
import kotlin.time.Duration

data class ActiveRunState(
    // Value to hold elapsed time
    val elapsedTime: Duration = Duration.ZERO,
    // Value holding the information of runs of type RunData
    val runData: RunData = RunData(),
    // Boolean represents if we can track the user or not. Availability of location + permission.
    val shouldTrack: Boolean = false,
    // Boolean represents if the user has started running.
    val hasStartedRunning: Boolean = false,
    // Value of type location in core to hold the user position
    val currentLocation: Location? = null,
    // Boolean representing if the run is finished.
    val isRunFinished: Boolean = false,
    // Boolean representing if the run is saving to display the saving animation.
    val isSavingRun: Boolean = false,
    // Boolean representing to check if we should show the location rationale.
    val showLocationRationale: Boolean = false,
    // Boolean representing to check if we should show the notification rationale.
    val showNotificationRationale: Boolean = false,

)
