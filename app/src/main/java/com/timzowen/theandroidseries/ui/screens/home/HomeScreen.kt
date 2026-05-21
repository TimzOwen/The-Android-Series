package com.timzowen.theandroidseries.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.timzowen.theandroidseries.ui.screens.SendPayViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    onSendMoneyClick: () -> Unit,
    viewModel: SendPayViewModel = viewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Wallet Balance", style = MaterialTheme.typography.titleMedium)
        Text(text = "KES 50,000.00", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                viewModel.resetState()
                onSendMoneyClick()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send Money")
        }
    }
}
