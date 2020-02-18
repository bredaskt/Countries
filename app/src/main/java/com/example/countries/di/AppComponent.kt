package com.example.countries.di

import com.example.countries.model.CountriesService
import com.example.countries.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(service: CountriesService)

    fun inject(viewModel: ListViewModel)

}