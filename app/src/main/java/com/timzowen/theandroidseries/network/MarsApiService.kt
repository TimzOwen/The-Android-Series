package com.timzowen.theandroidseries.network

import com.timzowen.theandroidseries.model.MarsPhoto
import retrofit2.http.GET

interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}
