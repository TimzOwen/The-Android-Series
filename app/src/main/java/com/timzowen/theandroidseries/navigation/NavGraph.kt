package com.timzowen.theandroidseries.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

import androidx.navigation.compose.composable
import com.timzowen.theandroidseries.ui.screens.home.HomeScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        startDestination = Routes.Home.routes,
        navController = navController,
        modifier = modifier
    ) {
        composable(Routes.Home.routes) {
            HomeScreen(onSendMoneyClick = { navController.navigate("payment_graph") })
        }
        paymentGraph(navController)
    }

}