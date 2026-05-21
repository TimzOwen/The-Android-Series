package com.timzowen.theandroidseries.data

data class SendMoneyUiState(
    val recipientName: String = "",
    val recipientNameError: String? = null,
    val phoneNumber: String = "",
    val phoneNumberError: String? = null,
    val amount: String = "",
    val amountError: String? = null,
    val fundingSource: FundingSource = FundingSource.WALLET,
    val transactionFee: Double = 0.0,
    val vat: Double = 0.0,
    val total: Double = 0.0,
    val pin: String = "",
    val errorMessage: String = "",
    val isLoading: Boolean = false,
    val transactionComplete: Boolean = false
)

enum class FundingSource(val displayName: String) {
    WALLET("My Wallet"),
    BANK("Bank Account"),
    CARD("Credit/Debit Card")
}