package com.timzowen.theandroidseries.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

// create our api client
private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// Api end points - show all available end points
interface MarsApiService {
    @GET("photos")
    suspend fun getPhotos(): String
}

// create API object
object MarsApi {
    val retrofitService: MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }
}