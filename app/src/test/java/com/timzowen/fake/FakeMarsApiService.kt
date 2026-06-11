package com.timzowen.fake

import com.timzowen.theandroidseries.network.MarsApiService
import com.timzowen.theandroidseries.model.MarsPhoto

class FakeMarsApiService : MarsApiService {
    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photoList
    }
}