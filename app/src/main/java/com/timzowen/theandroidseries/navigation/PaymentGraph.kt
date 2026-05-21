package com.timzowen.theandroidseries.navigation

import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.timzowen.theandroidseries.ui.screens.SendPayViewModel
import com.timzowen.theandroidseries.ui.screens.amount.AmountScreen
import com.timzowen.theandroidseries.ui.screens.pin.PinScreen
import com.timzowen.theandroidseries.ui.screens.recipient.RecipientScreen
import com.timzowen.theandroidseries.ui.screens.review.ReviewScreen
import com.timzowen.theandroidseries.ui.screens.success.SuccessScreen

fun NavGraphBuilder.paymentGraph(navController: NavController) {
    navigation(
        startDestination = Routes.Recipient.routes,
        route = "payment_graph"
    ) {
        composable(Routes.Recipient.routes) { entry ->
            val viewModel = entry.sharedViewModel<SendPayViewModel>(navController)
            RecipientScreen(
                viewModel = viewModel,
                onNext = { navController.navigate(Routes.Amount.routes) }
            )
        }
        composable(Routes.Amount.routes) { entry ->
            val viewModel = entry.sharedViewModel<SendPayViewModel>(navController)
            AmountScreen(
                viewModel = viewModel,
                onNext = { navController.navigate(Routes.Confirmation.routes) }
            )
        }
        composable(Routes.Confirmation.routes) { entry ->
            val viewModel = entry.sharedViewModel<SendPayViewModel>(navController)
            ReviewScreen(
                viewModel = viewModel,
                onConfirm = { navController.navigate(Routes.Pin.routes) },
                onCancel = { navController.popBackStack(Routes.Home.routes, inclusive = false) }
            )
        }
        composable(Routes.Pin.routes) { entry ->
            val viewModel = entry.sharedViewModel<SendPayViewModel>(navController)
            PinScreen(
                viewModel = viewModel,
                onSuccess = {
                    navController.navigate(Routes.Success.routes) {
                        popUpTo(Routes.Recipient.routes) { inclusive = true }
                    }
                }
            )
        }
        composable(Routes.Success.routes) { entry ->
            val viewModel = entry.sharedViewModel<SendPayViewModel>(navController)
            SuccessScreen(
                viewModel = viewModel,
                onDone = { navController.popBackStack(Routes.Home.routes, inclusive = false) }
            )
        }
    }
}

@androidx.compose.runtime.Composable
inline fun <reified T : androidx.lifecycle.ViewModel> androidx.navigation.NavBackStackEntry.sharedViewModel(
    navController: NavController
): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}