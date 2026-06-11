package com.timzowen.theandroidseries.ui.screens

import com.timzowen.theandroidseries.model.MarsPhoto

sealed interface MarsUiState {
    data class Error(val error: String) : MarsUiState
    object Loading : MarsUiState
    data class Success(val photos: List<MarsPhoto>) : MarsUiState
}