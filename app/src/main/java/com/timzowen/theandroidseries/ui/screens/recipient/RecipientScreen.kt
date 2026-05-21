package com.timzowen.theandroidseries.ui.screens.recipient

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
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
            modifier = Modifier.fillMaxWidth(),
            isError = uiState.recipientNameError != null,
            supportingText = { uiState.recipientNameError?.let { Text(it) } },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                keyboardType = KeyboardType.Text
            ),
            singleLine = true
        )

        OutlinedTextField(
            value = uiState.phoneNumber,
            onValueChange = { viewModel.updatePhone(it) },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth(),
            isError = uiState.phoneNumberError != null,
            supportingText = { uiState.phoneNumberError?.let { Text(it) } },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            singleLine = true
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onNext,
            modifier = Modifier.fillMaxWidth(),
            enabled = uiState.recipientName.isNotBlank() && 
                    uiState.phoneNumber.isNotBlank() &&
                    uiState.recipientNameError == null &&
                    uiState.phoneNumberError == null
        ) {
            Text("Next")
        }
    }
}
