@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.run.presentation.active_run

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.presentation.designsystem.RuniqueTheme
import com.example.core.presentation.designsystem.StartIcon
import com.example.core.presentation.designsystem.StopIcon
import com.example.core.presentation.designsystem.components.RuniqueFloatActionButton
import com.example.core.presentation.designsystem.components.RuniqueScaffold
import com.example.core.presentation.designsystem.components.RuniqueToolbar
import com.plcoding.run.presentation.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun ActiveRunScreenRot(
    viewModel: ActiveRunViewModel = koinViewModel()
) {
    ActiveRunScreen(
        state = viewModel.state,
        onAction = viewModel::onAction
    )
}

@Composable
private fun ActiveRunScreen(
    state: ActiveRunState,
    onAction: (ActiveRunAction) -> Unit
) {
    RuniqueScaffold(
        withGradient = false,
        topAppBar = {
            RuniqueToolbar(
                showBackButton = true,
                title = stringResource(id = R.string.active_run),
                onBackClick = {
                    onAction(ActiveRunAction.OnBackClick)
                }
            )
        },
        floatingActionButton = {
            RuniqueFloatActionButton(
                icon = if (state.shouldTrack) {
                    StopIcon
                } else {
                    StartIcon
                       },
                onClick = {
                    onAction(ActiveRunAction.onToggleRunClick)
                },
                iconSize = 20.dp,
                contentDescription = if(state.shouldTrack){
                    stringResource(id = R.string.pause_run)
                } else {
                    stringResource(id = R.string.start_run)
                }
            )
        }
    ) {

    }

}

@Preview
@Composable
private fun ActiveRunScreenPreview() {
    RuniqueTheme {
        ActiveRunScreen(
            state = ActiveRunState(),
            onAction = {}
        )
    }
}