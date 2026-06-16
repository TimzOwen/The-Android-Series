package com.timzowen.theandroidseries.ui.screens

import com.timzowen.theandroidseries.domain.Amphibian

sealed interface AmphibianUIState {
    object Loading : AmphibianUIState
    data class Success(val amphibians: List<Amphibian>) : AmphibianUIState
    data class Error(val errorMessage: String) : AmphibianUIState
}