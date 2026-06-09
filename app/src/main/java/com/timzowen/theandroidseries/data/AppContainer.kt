package com.timzowen.theandroidseries.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.timzowen.theandroidseries.network.MarsApiService
import com.timzowen.theandroidseries.repository.MarsPhotoRepository
import com.timzowen.theandroidseries.repository.NetworkMarsPhotoRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val marsPhotoRepository: MarsPhotoRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

    override val marsPhotoRepository: MarsPhotoRepository by lazy {
        NetworkMarsPhotoRepository(retrofitService)
    }
    private val retrofit = Retrofit
        .Builder().addConverterFactory(
            Json.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

}