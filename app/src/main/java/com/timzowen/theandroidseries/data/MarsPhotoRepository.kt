package com.timzowen.theandroidseries.data

import com.timzowen.theandroidseries.network.MarsApiService
import com.timzowen.theandroidseries.model.MarsPhoto

interface MarsPhotoRepository {

    suspend fun getPhotos(): List<MarsPhoto>

}

class NetworkMarsPhotoRepository(
    private val marsApiService: MarsApiService
) : MarsPhotoRepository {
    override suspend fun getPhotos(): List<MarsPhoto> = marsApiService.getPhotos()

}