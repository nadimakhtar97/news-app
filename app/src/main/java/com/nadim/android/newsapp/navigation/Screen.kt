package com.nadim.android.newsapp.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Screen: NavKey {

    @Serializable
    object Home: Screen()

}