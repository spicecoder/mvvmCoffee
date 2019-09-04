package io.pronab.mvvmscratch.base

import androidx.lifecycle.ViewModel
import io.pronab.mvvmscratch.injection.component.DaggerViewModelInjector
import io.pronab.mvvmscratch.injection.component.ViewModelInjector
import io.pronab.mvvmscratch.injection.module.NetworkModule
import io.pronab.mvvmscratch.ui.business.BusinessListViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Dagger 2 Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is BusinessListViewModel -> injector.inject(this)
        }
    }
}