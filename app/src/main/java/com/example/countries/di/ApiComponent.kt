package com.example.countries.di

import com.example.countries.model.CountriesService
import com.example.countries.viewmodel.ListViewModel

//@Component(modules = [ApiModule::class.java])
interface ApiComponent {

    fun inject(service: CountriesService)

    fun inject(viewModel: ListViewModel)

}