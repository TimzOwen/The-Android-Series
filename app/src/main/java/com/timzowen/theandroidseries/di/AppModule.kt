package com.timzowen.theandroidseries.di

import com.timzowen.theandroidseries.data.repository.AmphibianRepositoryImpl
import com.timzowen.theandroidseries.repository.AmphibianRepository
import com.timzowen.theandroidseries.service.AmphibianService
import com.timzowen.theandroidseries.ui.screens.AmphibiansViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        HttpClient(OkHttp) {
            defaultRequest {
                url("https://android-kotlin-fun-mars-server.appspot.com/")
            }
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
            }
        }
    }

    single { AmphibianService(get()) }
    single<AmphibianRepository> { AmphibianRepositoryImpl(get()) }
    viewModel { AmphibiansViewModel(get()) }
}
