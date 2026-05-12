package com.timzowen.theandroidseries.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.timzowen.theandroidseries.R

data class Goal(
    val dayCount: Int,
    @StringRes val goalTitle: Int,
    @DrawableRes val goalImageResId: Int,
    @StringRes val goalDescResId: Int,
)

object Goals {
    val monthlyGoals = listOf(
        Goal(
            dayCount = 1,
            goalTitle = R.string.title_1,
            goalImageResId = R.drawable.image_1,
            goalDescResId = R.string.description_1
        ),
        Goal(
            dayCount = 2,
            goalTitle = R.string.title_2,
            goalImageResId = R.drawable.image_2,
            goalDescResId = R.string.description_2
        ),
        Goal(
            dayCount = 3,
            goalTitle = R.string.title_3,
            goalImageResId = R.drawable.image_3,
            goalDescResId = R.string.description_3
        ),
        Goal(
            dayCount = 4,
            goalTitle = R.string.title_4,
            goalImageResId = R.drawable.image_4,
            goalDescResId = R.string.description_4
        ),
        Goal(
            dayCount = 5,
            goalTitle = R.string.title_5,
            goalImageResId = R.drawable.image_5,
            goalDescResId = R.string.description_5
        ),
        Goal(
            dayCount = 6,
            goalTitle = R.string.title_6,
            goalImageResId = R.drawable.image_6,
            goalDescResId = R.string.description_6
        ),
        Goal(
            dayCount = 7,
            goalTitle = R.string.title_7,
            goalImageResId = R.drawable.image_7,
            goalDescResId = R.string.description_7
        ),
        Goal(
            dayCount = 8,
            goalTitle = R.string.title_8,
            goalImageResId = R.drawable.image_8,
            goalDescResId = R.string.description_8
        ),
        Goal(
            dayCount = 9,
            goalTitle = R.string.title_9,
            goalImageResId = R.drawable.image_9,
            goalDescResId = R.string.description_9
        ),
        Goal(
            dayCount = 10,
            goalTitle = R.string.title_10,
            goalImageResId = R.drawable.image_10,
            goalDescResId = R.string.description_10
        )
    )
}
