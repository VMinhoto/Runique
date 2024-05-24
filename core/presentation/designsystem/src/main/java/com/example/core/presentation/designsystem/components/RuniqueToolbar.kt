@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.core.presentation.designsystem.components

import android.widget.Space
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.presentation.designsystem.AnalyticsIcon
import com.example.core.presentation.designsystem.ArrowLeftIcon
import com.example.core.presentation.designsystem.LogoIcon
import com.example.core.presentation.designsystem.Poppins
import com.example.core.presentation.designsystem.R
import com.example.core.presentation.designsystem.RuniqueGreen
import com.example.core.presentation.designsystem.RuniqueTheme
import com.example.core.presentation.designsystem.components.util.DropDownItem

@Composable
fun RuniqueToolbar(
    // Boolean to show back button
    showBackButton: Boolean,
    // String to hold the title of the Bar
    title: String,
    // Modifier to be applied to the toolbar
    modifier: Modifier = Modifier,
    // List of items to be displayed in the menu
    menuItems: List<DropDownItem> = emptyList(),
    // Function to be called when the back button is clicked
    onMenuItemClick: (Int) -> Unit = {},
    // Function to be called when the back button is clicked
    onBackClick: () -> Unit = {},
    // Function that defines the appearance of the top bar
    scrollBehaviour: TopAppBarScrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
    // Composable that holds the icon of the top bar. ()?=null means that it can be null
    startContent: (@Composable () -> Unit)? = null
){
    // State to check if dropdown is open or not
    var isDropDownOpen by rememberSaveable {
        mutableStateOf(false)
    }
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // If the composable is not null, call the composable function
                startContent?.invoke()
                Spacer( modifier = Modifier.width(8.dp))
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = Poppins
                )
            }
        },
        modifier = modifier,
        scrollBehavior = scrollBehaviour,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        navigationIcon = {
            // Only appears if showBackButton is true
            if(showBackButton) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = ArrowLeftIcon,
                        contentDescription = stringResource(id = R.string.go_back),
                        tint = MaterialTheme.colorScheme.onBackground
                        )
                }
            }
        },
        actions = {
            if(menuItems.isNotEmpty()) {
                Box {
                    // Dropdown menu
                    DropdownMenu(
                        // Appears as expanded then isDropDownOpen is true
                        expanded = isDropDownOpen,
                        // ON desmiss makes is DropDownOpen false
                        onDismissRequest = {
                            isDropDownOpen = false
                        }) {
                        menuItems.forEachIndexed { index, item ->
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                                // on click call the lambda onMenuItemClick with the index
                                modifier = Modifier
                                    .clickable { onMenuItemClick(index) }
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ){
                                // Each item has an Icon, a spacer and a text
                                Icon(
                                    imageVector = item.icon,
                                    contentDescription = item.title
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = item.title)
                            }
                        }
                    }

                    // This is the icon with the 3 dots that can be clicked to open the dropdown menu
                    IconButton(onClick = {
                        isDropDownOpen = true
                    }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = stringResource(id = R.string.open_menu),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                    }
                }
            }
        }

    )
}

@Preview
@Composable
private fun RuniqueToolbarPreview(){
    RuniqueTheme {
        RuniqueToolbar(
            showBackButton = false,
            title = "Runique",
            modifier = Modifier.fillMaxWidth(),
            startContent = {
                Icon(
                    imageVector = LogoIcon,
                    contentDescription = null,
                    tint = RuniqueGreen,
                    modifier = Modifier
                        .size(35.dp)
                    )
            },
            menuItems = listOf(
                DropDownItem(
                    icon = AnalyticsIcon,
                    title = "BLA BLA"
                )
            )
        )
    }
}