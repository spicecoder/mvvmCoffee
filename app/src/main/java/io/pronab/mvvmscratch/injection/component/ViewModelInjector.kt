package io.pronab.mvvmscratch.injection.component

import dagger.Component
import io.pronab.mvvmscratch.injection.module.NetworkModule
import io.pronab.mvvmscratch.ui.business.BusinessListViewModel
import javax.inject.Singleton

/**
 * Component providing inject() methods for View Model
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified BusinessListViewModel.
     * @param businessListViewModel  in which to inject the dependencies
     */
    fun inject(businessListViewModel: BusinessListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}