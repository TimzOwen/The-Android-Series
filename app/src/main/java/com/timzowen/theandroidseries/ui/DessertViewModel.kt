package com.timzowen.theandroidseries.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.timzowen.theandroidseries.data.DataSource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    fun onDessertClicked() {
        _uiState.update { cupcakeUiState ->
            val dessertSold = cupcakeUiState.dessertSold + 1
            val nextDessertIndex = determineDessertIndex(dessertSold)
            cupcakeUiState.copy(
                currentDessertIndex = nextDessertIndex,
                revenue = cupcakeUiState.revenue + cupcakeUiState.currentDessertPrice,
                dessertSold = dessertSold,
                currentDessertImage = dessertList[nextDessertIndex].imageId,
                currentDessertPrice = dessertList[nextDessertIndex].price
            )
        }
    }

    private fun determineDessertIndex(dessertSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                break
            }
        }
        return dessertIndex
    }
}