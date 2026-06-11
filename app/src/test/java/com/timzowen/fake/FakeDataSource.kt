package com.timzowen.fake

import com.timzowen.theandroidseries.network.MarsPhoto

object FakeDataSource {
    const val idOne = "img1"
    const val idTwo = "img2"
    const val img1 = "url.1"
    const val img2 = "url.2"

    val photoList = listOf(
        MarsPhoto(
            id = idOne,
            imgSrc = img1
        ),
        MarsPhoto(
            id = idTwo,
            imgSrc = img2
        )
    )
}