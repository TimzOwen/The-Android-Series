package com.timzowen.theandroidseries.ui.screens.amount

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.timzowen.theandroidseries.data.FundingSource
import com.timzowen.theandroidseries.ui.screens.SendPayViewModel

@Composable
fun AmountScreen(
    viewModel: SendPayViewModel,
    onNext: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val radioOptions = FundingSource.entries

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Enter Amount", style = MaterialTheme.typography.headlineSmall)

        OutlinedTextField(
            value = uiState.amount,
            onValueChange = { viewModel.updateAmount(it) },
            label = { Text("Amount") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Select Funding Source", style = MaterialTheme.typography.titleMedium)

        Column(Modifier.selectableGroup()) {
            radioOptions.forEach { source ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .selectable(
                            selected = (source == uiState.fundingSource),
                            onClick = { viewModel.updateFundingSource(source) },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (source == uiState.fundingSource),
                        onClick = null
                    )
                    Text(
                        text = source.name,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                viewModel.calculateTransactionFee()
                onNext()
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = uiState.amount.toDoubleOrNull() != null && uiState.amount.toDouble() > 0
        ) {
            Text("Review")
        }
    }
}
