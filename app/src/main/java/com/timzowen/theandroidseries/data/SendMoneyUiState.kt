package com.timzowen.theandroidseries.data

data class SendMoneyUiState(
    val recipientName: String = "",
    val phoneNumber: String = "",
    val amount: String = "",
    val fundingSource: FundingSource = FundingSource.WALLET,
    val transactionFee: Double = 0.0,
    val vat: Double = 0.0,
    val total: Double = 0.0,
    val pin: String = "",
    val errorMessage: String = "",
    val isLoading: Boolean = false,
    val transactionComplete: Boolean = false
)

enum class FundingSource {
    WALLET,
    BANK,
    CARD
}