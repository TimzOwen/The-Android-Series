package com.timzowen.theandroidseries.data.repository

import com.timzowen.theandroidseries.domain.Amphibian
import com.timzowen.theandroidseries.repository.AmphibianRepository
import com.timzowen.theandroidseries.service.AmphibianService

class AmphibianRepositoryImpl(
    private val amphibianService: AmphibianService
) : AmphibianRepository {

    override suspend fun fetchAmphibians(): List<Amphibian> {
        return amphibianService.getAmphibians().map { dto ->
            Amphibian(
                name = dto.name,
                imageUrl = dto.imgSrc,
                description = dto.description
            )
        }
    }
}
