/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.timzowen.theandroidseries.ui.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavDestination.Companion.hasRoute
import com.timzowen.theandroidseries.R
import com.timzowen.theandroidseries.navigation.LunchTrayNavHost
import com.timzowen.theandroidseries.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayAppBar(
    @StringRes currentScreenTitle: Int,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreenTitle)) },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LunchTrayApp() {
    // Create Controller
    val navController = rememberNavController()

    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()

    // Get the current screen
    val currentScreen = backStackEntry?.destination?.route?.let { route ->
        // For type-safe navigation, we can use the route string or better, 
        // match it to our Screen objects if possible.
        // However, with new Navigation, we usually use the NavDestination's hasRoute or just 
        // pass the title via some other means.
        // Since we are using type-safe navigation, let's try to get the title.
        // A simple way is to use a map or check the destination class.
        
        // In modern Compose Navigation (2.8.0+), we can use:
        // backStackEntry?.toRoute<Screen>()
        // But we need to handle the case where it's not one of our screens or null.
        null // placeholder for now, see logic below
    }
    
    // Improved way to get current screen title for type-safe nav
    val currentTitle = when {
        backStackEntry?.destination?.hasRoute<Screen.Start>() == true -> Screen.Start.title
        backStackEntry?.destination?.hasRoute<Screen.Entree>() == true -> Screen.Entree.title
        backStackEntry?.destination?.hasRoute<Screen.SideDish>() == true -> Screen.SideDish.title
        backStackEntry?.destination?.hasRoute<Screen.Accompaniment>() == true -> Screen.Accompaniment.title
        backStackEntry?.destination?.hasRoute<Screen.Checkout>() == true -> Screen.Checkout.title
        else -> R.string.app_name
    }

    // Create ViewModel
    val viewModel: OrderViewModel = viewModel()

    Scaffold(
        topBar = {
            LunchTrayAppBar(
                currentScreenTitle = currentTitle,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        LunchTrayNavHost(
            navController = navController,
            viewModel = viewModel,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
