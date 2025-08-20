package com.nadim.android.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.nadim.android.newsapp.views.Home
import androidx.compose.runtime.getValue

@Composable
fun Navigation() {

    val backStack = rememberNavBackStack<Screen>(Screen.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Screen.Home> {
                Home()
            }
        }
    )

}