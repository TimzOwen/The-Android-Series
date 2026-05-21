package com.timzowen.theandroidseries.ui.screens.recipient

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.timzowen.theandroidseries.ui.screens.SendPayViewModel

@Composable
fun RecipientScreen(
    viewModel: SendPayViewModel,
    onNext: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Recipient Details", style = MaterialTheme.typography.headlineSmall)
        
        OutlinedTextField(
            value = uiState.recipientName,
            onValueChange = { viewModel.updateRecipient(it) },
            label = { Text("Recipient Name") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = uiState.phoneNumber,
            onValueChange = { viewModel.updatePhone(it) },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onNext,
            modifier = Modifier.fillMaxWidth(),
            enabled = uiState.recipientName.isNotBlank() && uiState.phoneNumber.isNotBlank()
        ) {
            Text("Next")
        }
    }
}
