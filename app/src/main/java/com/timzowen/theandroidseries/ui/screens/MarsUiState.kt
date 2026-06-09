package com.timzowen.theandroidseries.ui.screens

sealed interface MarsUiState {
    data class Error(val error: String) : MarsUiState
    object Loading : MarsUiState
    data class Success(val photos: String) : MarsUiState
}