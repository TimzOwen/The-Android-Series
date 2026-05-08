package com.timzowen.theandroidseries.grid

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Course(
    @StringRes val titleResourceId: Int,
    val courseNumber: Int,
    @DrawableRes val imageResourceId: Int

)