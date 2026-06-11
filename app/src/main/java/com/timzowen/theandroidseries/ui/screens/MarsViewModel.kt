package com.timzowen.theandroidseries.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.timzowen.theandroidseries.MarsPhotoApplication
import com.timzowen.theandroidseries.data.MarsPhotoRepository
import kotlinx.coroutines.launch
import java.io.IOException

class MarsViewModel(
    private val marsPhotoRepository: MarsPhotoRepository
) : ViewModel() {
    var marsUiState: MarsUiState by mutableStateOf(MarsUiState.Loading)
        private set

    init {
        getMarsPhotos()
    }

    fun getMarsPhotos() {
        viewModelScope.launch {
            marsUiState = try {
                MarsUiState.Success(marsPhotoRepository.getPhotos())
            } catch (e: IOException) {
                MarsUiState.Error(e.toString())
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MarsPhotoApplication)
                val marsPhotoRepository = application.container.marsPhotoRepository
                MarsViewModel(marsPhotoRepository = marsPhotoRepository)
            }
        }
    }

}