package com.timzowen.fake

import com.timzowen.theandroidseries.model.MarsPhoto
import com.timzowen.theandroidseries.data.MarsPhotoRepository

class FakeNetworkMarsPhotosRepository : MarsPhotoRepository {

    override suspend fun getPhotos(): List<MarsPhoto> {
        return FakeDataSource.photoList
    }

}