package com.timzowen.theandroidseries.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

// create our api client
private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(
        Json.asConverterFactory("application/json".toMediaType())
    )
    .baseUrl(BASE_URL)
    .build()

// Api end points - show all available end points
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): List<MarsPhoto>
}

// create API object
object MarsApi {
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}