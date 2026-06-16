package com.timzowen.theandroidseries.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timzowen.theandroidseries.repository.AmphibianRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AmphibiansViewModel(
    private val amphibianRepository: AmphibianRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<AmphibianUIState>(AmphibianUIState.Loading)
    val uiState: StateFlow<AmphibianUIState> = _uiState.asStateFlow()

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            _uiState.value = AmphibianUIState.Loading
            try {
                val amphibians = amphibianRepository.fetchAmphibians()
                _uiState.value = AmphibianUIState.Success(amphibians)
            } catch (e: Exception) {
                _uiState.value = AmphibianUIState.Error(e.message ?: "Unknown Error")
            }
        }
    }
}