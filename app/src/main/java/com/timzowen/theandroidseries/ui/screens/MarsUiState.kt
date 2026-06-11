package com.timzowen.theandroidseries.ui.screens

import com.timzowen.theandroidseries.network.MarsPhoto

sealed interface MarsUiState {
    data class Error(val error: String) : MarsUiState
    object Loading : MarsUiState
    data class Success(val photos: MarsPhoto) : MarsUiState
}