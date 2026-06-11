package com.timzowen.theandroidseries.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timzowen.theandroidseries.data.MarsPhotoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException

class MarsViewModel(
    private val marsPhotoRepository: MarsPhotoRepository
) : ViewModel() {

    private val _marsUiState = MutableStateFlow<MarsUiState>(MarsUiState.Loading)
    val marsUiState: StateFlow<MarsUiState> = _marsUiState.asStateFlow()

    init {
        getMarsPhotos()
    }

    fun getMarsPhotos() {
        viewModelScope.launch {
            _marsUiState.update { MarsUiState.Loading }
            try {
                val photos = marsPhotoRepository.getPhotos()
                _marsUiState.update { MarsUiState.Success(photos) }
            } catch (e: IOException) {
                _marsUiState.update { MarsUiState.Error(e.toString()) }
            } catch (e: Exception) {
                _marsUiState.update { MarsUiState.Error(e.toString()) }
            }
        }
    }
}