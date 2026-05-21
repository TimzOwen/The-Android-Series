package com.timzowen.theandroidseries.navigation

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.timzowen.theandroidseries.R
import com.timzowen.theandroidseries.data.DataSource
import com.timzowen.theandroidseries.screens.OrderSummaryScreen
import com.timzowen.theandroidseries.screens.OrderViewModel
import com.timzowen.theandroidseries.screens.SelectOptionScreen
import com.timzowen.theandroidseries.screens.StartOrderScreen

@Composable
fun CupcakeNavHost(
    viewModel: OrderViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Screen.Start,
        modifier = modifier
    ) {
        composable<Screen.Start> {
            StartOrderScreen(
                quantityOptions = DataSource.quantityOptions,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(R.dimen.padding_medium)),
                onNextButtonClicked = {
                    viewModel.setQuantity(it)
                    navController.navigate(Screen.Flavor)
                }
            )
        }

        composable<Screen.Flavor> {
            val context = LocalContext.current
            SelectOptionScreen(
                subtotal = uiState.price,
                options = DataSource.flavors.map { id -> context.resources.getString(id) },
                onSelectionChanged = { viewModel.setFlavor(it) },
                modifier = Modifier.fillMaxHeight(),
                onNextButtonClicked = { navController.navigate(Screen.Pickup) },
                onCancelButtonClicked = { cancelAndNavigateToStart(viewModel, navController) }
            )
        }

        composable<Screen.Pickup> {
            SelectOptionScreen(
                subtotal = uiState.price,
                options = uiState.pickupOptions,
                onSelectionChanged = { viewModel.setDate(it) },
                modifier = Modifier.fillMaxHeight(),
                onNextButtonClicked = { navController.navigate(Screen.Summary) },
                onCancelButtonClicked = { cancelAndNavigateToStart(viewModel, navController) }
            )
        }

        composable<Screen.Summary> {
            OrderSummaryScreen(
                orderUiState = uiState,
                modifier = Modifier.fillMaxHeight(),
                onCancelButtonClicked = { cancelAndNavigateToStart(viewModel, navController) },
                onSendButtonClicked = { subject: String, summary: String ->
                    shareOrder(context, subject, summary)
                }
            )
        }
    }
}

private fun shareOrder(context: Context, subject: String, summary: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.new_cupcake_order)
        )
    )
}

private fun cancelAndNavigateToStart(
    viewModel: OrderViewModel,
    navController: NavHostController
) {
    viewModel.resetOrder()
    navController.popBackStack(
        route = Screen.Start,
        inclusive = false
    )
}
