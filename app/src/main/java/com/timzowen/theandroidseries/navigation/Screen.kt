package com.timzowen.theandroidseries.navigation

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Start : Screen
    @Serializable
    data object Flavor : Screen
    @Serializable
    data object Pickup : Screen
    @Serializable
    data object Summary : Screen
}
