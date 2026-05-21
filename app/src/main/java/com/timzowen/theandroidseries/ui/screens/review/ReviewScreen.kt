package com.timzowen.theandroidseries.ui.screens.review

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.timzowen.theandroidseries.ui.screens.SendPayViewModel

@Composable
fun ReviewScreen(
    viewModel: SendPayViewModel,
    onConfirm: () -> Unit,
    onCancel: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Review Transaction", style = MaterialTheme.typography.headlineSmall)
        
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                ReviewItem("Recipient", uiState.recipientName)
                ReviewItem("Phone", uiState.phoneNumber)
                ReviewItem("Amount", "KES ${uiState.amount}")
                ReviewItem("Fee", "KES ${uiState.transactionFee}")
                ReviewItem("VAT", "KES ${uiState.vat}")
                HorizontalDivider()
                ReviewItem("Total Deduction", "KES ${uiState.total}", isTotal = true)
                ReviewItem("Funding Source", uiState.fundingSource.displayName)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onConfirm,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Confirm & Pay")
        }

        OutlinedButton(
            onClick = onCancel,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cancel")
        }
    }
}

@Composable
fun ReviewItem(label: String, value: String, isTotal: Boolean = false) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = if (isTotal) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyMedium)
        Text(text = value, style = if (isTotal) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyLarge)
    }
}
