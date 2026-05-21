package com.timzowen.theandroidseries.di

import com.timzowen.theandroidseries.ui.screens.SendPayViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SendPayViewModel() }
}