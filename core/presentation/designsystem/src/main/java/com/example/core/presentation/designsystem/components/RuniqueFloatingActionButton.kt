package com.example.core.presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.core.presentation.designsystem.RunIcon
import com.example.core.presentation.designsystem.RuniqueTheme

@Composable
fun RuniqueFloatActionButton(
    // Icon to display
    icon: ImageVector,
    // Lambda function to execute when the button is clicked
    onClick: () -> Unit,
    // Modifier to apply to the button
    modifier: Modifier = Modifier,
    // Content description for accessibility
    contentDescription: String? = null,
    iconSize: Dp = 25.dp
){
    // To build this we will use nested boxes. One for the outer circle, one for the inner circle.
    Box(
        modifier = Modifier
            .size(75.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ){
        // Inner circle box with an Icon
        Box(modifier = Modifier
            .size(50.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
            .padding(12.dp),
            contentAlignment = Alignment.Center
        ){
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(iconSize)
            )
        }
    }
}

@Preview
@Composable
private fun RuniqueFloatActionButtonPreview() {
    RuniqueTheme {
        RuniqueFloatActionButton(
            icon = RunIcon,
            onClick = { /*TODO*/ })
    }
}