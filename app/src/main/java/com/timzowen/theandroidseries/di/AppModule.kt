package com.timzowen.theandroidseries.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.timzowen.theandroidseries.data.MarsPhotoRepository
import com.timzowen.theandroidseries.data.NetworkMarsPhotoRepository
import com.timzowen.theandroidseries.network.MarsApiService
import com.timzowen.theandroidseries.ui.screens.MarsViewModel
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    single {
        Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
    }

    single {
        val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"
        Retrofit.Builder()
            .addConverterFactory(
                get<Json>().asConverterFactory("application/json".toMediaType())
            )
            .baseUrl(BASE_URL)
            .build()
    }

    single {
        get<Retrofit>().create(MarsApiService::class.java)
    }

    single<MarsPhotoRepository> {
        NetworkMarsPhotoRepository(get())
    }

    viewModel {
        MarsViewModel(get())
    }
}
