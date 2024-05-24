package com.example.core.presentation.designsystem.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RuniqueScaffold(
    modifier: Modifier = Modifier,
    // Boolean to apply a gradient to the scaffold
    withGradient: Boolean = true,
    // Top app Bar composable
    topAppBar: @Composable ()-> Unit = {},
    // Floating action button composable
    floatingActionButton: @Composable ()-> Unit = {},
    // Composable holding the page content
    content: @Composable (PaddingValues) -> Unit
){
    Scaffold(
        topBar = topAppBar,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
    ) {padding ->
        if(withGradient) {
            GradientBackground {
                content(padding)
            }
        } else {
            content(padding)
        }
    }

}