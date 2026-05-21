package com.timzowen.theandroidseries.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.timzowen.theandroidseries.R
import com.timzowen.theandroidseries.datasource.DataSource
import com.timzowen.theandroidseries.ui.screens.AccompanimentMenuScreen
import com.timzowen.theandroidseries.ui.screens.CheckoutScreen
import com.timzowen.theandroidseries.ui.screens.EntreeMenuScreen
import com.timzowen.theandroidseries.ui.screens.OrderViewModel
import com.timzowen.theandroidseries.ui.screens.SideDishMenuScreen
import com.timzowen.theandroidseries.ui.screens.StartOrderScreen

@Composable
fun LunchTrayNavHost(
    navController: NavHostController,
    viewModel: OrderViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Start,
        modifier = modifier
    ) {
        composable<Screen.Start> {
            StartOrderScreen(
                onStartOrderButtonClicked = {
                    navController.navigate(Screen.Entree)
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(R.dimen.padding_medium))
            )
        }
        composable<Screen.Entree> {
            EntreeMenuScreen(
                options = DataSource.entreeMenuItems,
                onSelectionChanged = { viewModel.updateEntree(it) },
                onNextButtonClicked = {
                    navController.navigate(Screen.SideDish)
                },
                onCancelButtonClicked = {
                    cancelAndNavigateToStart(viewModel, navController)
                },
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(dimensionResource(R.dimen.padding_medium))
            )
        }
        composable<Screen.SideDish> {
            SideDishMenuScreen(
                options = DataSource.sideDishMenuItems,
                onSelectionChanged = { viewModel.updateSideDish(it) },
                onNextButtonClicked = {
                    navController.navigate(Screen.Accompaniment)
                },
                onCancelButtonClicked = {
                    cancelAndNavigateToStart(viewModel, navController)
                },
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(dimensionResource(R.dimen.padding_medium))
            )
        }
        composable<Screen.Accompaniment> {
            AccompanimentMenuScreen(
                options = DataSource.accompanimentMenuItems,
                onSelectionChanged = { viewModel.updateAccompaniment(it) },
                onNextButtonClicked = {
                    navController.navigate(Screen.Checkout)
                },
                onCancelButtonClicked = {
                    cancelAndNavigateToStart(viewModel, navController)
                },
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(dimensionResource(R.dimen.padding_medium))
            )
        }
        composable<Screen.Checkout> {
            val uiState by viewModel.uiState.collectAsState()
            CheckoutScreen(
                orderUiState = uiState,
                onNextButtonClicked = {
                    cancelAndNavigateToStart(viewModel, navController)
                },
                onCancelButtonClicked = {
                    cancelAndNavigateToStart(viewModel, navController)
                },
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .fillMaxHeight()
            )
        }
    }
}

private fun cancelAndNavigateToStart(
    viewModel: OrderViewModel,
    navController: NavHostController
) {
    viewModel.resetOrder()
    navController.popBackStack(Screen.Start, inclusive = false)
}
