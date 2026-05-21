package com.timzowen.theandroidseries.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timzowen.theandroidseries.data.FundingSource
import com.timzowen.theandroidseries.data.SendMoneyUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SendPayViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SendMoneyUiState())
    val uiState: StateFlow<SendMoneyUiState> = _uiState.asStateFlow()

    fun updateRecipient(name: String) {
        _uiState.update {
            it.copy(recipientName = name)
        }
    }

    fun updatePhone(phone: String) {
        _uiState.update {
            it.copy(phoneNumber = phone)
        }
    }

    fun updateAmount(amount: String) {
        _uiState.update {
            it.copy(amount = amount)
        }
    }

    fun updateFundingSource(source: FundingSource) {
        _uiState.update {
            it.copy(fundingSource = source)
        }
    }

    fun calculateTransactionFee() {
        val amount = _uiState.value.amount.toDoubleOrNull() ?: 0.00
        val fee = if (amount > 0) 15.0 else 0.0
        val vat = if (amount > 0) 2.0 else 0.0
        val total = amount + fee + vat

        _uiState.update {
            it.copy(
                transactionFee = fee,
                vat = vat,
                total = total
            )
        }
    }

    fun authorizeTransaction() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            delay(2000)
            _uiState.update {
                it.copy(
                    isLoading = false,
                    transactionComplete = true
                )
            }
        }
    }

    fun resetState() {
        _uiState.value = SendMoneyUiState()
    }
}