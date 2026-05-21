package com.timzowen.theandroidseries.ui.screens.success

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.timzowen.theandroidseries.ui.screens.SendPayViewModel
import java.util.UUID

@Composable
fun SuccessScreen(
    viewModel: SendPayViewModel,
    onDone: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val transactionId = remember { UUID.randomUUID().toString().take(8).uppercase() }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("✅", style = MaterialTheme.typography.displayLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Transaction Successful!", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(32.dp))
        
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                SuccessItem("Transaction ID", transactionId)
                SuccessItem("Recipient", uiState.recipientName)
                SuccessItem("Amount Sent", "KES ${uiState.amount}")
                SuccessItem("Total Charged", "KES ${uiState.total}")
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                viewModel.resetState()
                onDone()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Done")
        }
    }
}

@Composable
fun SuccessItem(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyMedium)
        Text(text = value, style = MaterialTheme.typography.bodyLarge)
    }
}
