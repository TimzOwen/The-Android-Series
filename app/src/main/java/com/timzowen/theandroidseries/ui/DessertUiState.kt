package com.timzowen.theandroidseries.ui

import androidx.annotation.DrawableRes
import com.timzowen.theandroidseries.data.DataSource.dessertList

data class DessertUiState(
    val currentDessertIndex: Int = 0,
    val dessertSold: Int = 0,
    val revenue: Int = 0,
    val currentDessertPrice: Int = dessertList[currentDessertIndex].price,
    val currentDessertImage: Int = dessertList[currentDessertIndex].imageId
)
