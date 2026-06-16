package com.timzowen.theandroidseries.service

import com.timzowen.theandroidseries.data.network.AmphibianDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.json.Json

class AmphibianService(private val client: HttpClient) {

    suspend fun getAmphibians(): List<AmphibianDto> {
        val response = client.get("amphibians")
        val responseBody = response.body<String>()
        return Json.decodeFromString<List<AmphibianDto>>(responseBody)
    }
}