package com.timzowen.fake

import com.timzowen.rules.TestDispatcherRule
import com.timzowen.theandroidseries.ui.screens.MarsUiState
import com.timzowen.theandroidseries.ui.screens.MarsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class MarsViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() =
        runTest {
            val marsViewModel = MarsViewModel(
                marsPhotoRepository = FakeNetworkMarsPhotosRepository()
            )
            assertEquals(
                MarsUiState.Success(FakeDataSource.photoList),
                marsViewModel.marsUiState
            )
        }
}