package com.timzowen.theandroidseries.navigation

import com.timzowen.theandroidseries.R
import kotlinx.serialization.Serializable

sealed interface Screen {
    val title: Int

    @Serializable
    data object Start : Screen {
        override val title: Int = R.string.app_name
    }

    @Serializable
    data object Entree : Screen {
        override val title: Int = R.string.choose_entree
    }

    @Serializable
    data object SideDish : Screen {
        override val title: Int = R.string.choose_side_dish
    }

    @Serializable
    data object Accompaniment : Screen {
        override val title: Int = R.string.choose_accompaniment
    }

    @Serializable
    data object Checkout : Screen {
        override val title: Int = R.string.order_checkout
    }
}
