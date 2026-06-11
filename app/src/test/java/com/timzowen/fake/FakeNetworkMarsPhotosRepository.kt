package com.timzowen.fake

import com.timzowen.theandroidseries.network.MarsPhoto
import com.timzowen.theandroidseries.repository.MarsPhotoRepository

class FakeNetworkMarsPhotosRepository : MarsPhotoRepository {

    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photoList
    }

}