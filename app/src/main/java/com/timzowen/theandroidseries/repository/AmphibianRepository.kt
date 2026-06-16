package com.timzowen.theandroidseries.repository

import com.timzowen.theandroidseries.domain.Amphibian

interface AmphibianRepository {

    suspend fun fetchAmphibians(): List<Amphibian>
}