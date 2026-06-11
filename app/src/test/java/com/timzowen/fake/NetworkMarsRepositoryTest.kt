package com.timzowen.fake

import com.timzowen.theandroidseries.data.NetworkMarsPhotoRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test


class NetworkMarsRepositoryTest {

    @Test
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList() =
        runTest {
            val repository = NetworkMarsPhotoRepository(
                marsApiService = FakeMarsApiService()
            )
            assertEquals(FakeDataSource.photoList, repository.getPhotos())
        }

}