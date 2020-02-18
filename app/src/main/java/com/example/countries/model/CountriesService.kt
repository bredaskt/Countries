package com.example.countries.model

import com.example.countries.di.DaggerAppComponent
import io.reactivex.Single
import javax.inject.Inject

class CountriesService {

    @Inject
    lateinit var api : CountriesApi

    init {
        DaggerAppComponent.create().inject(this)
    }

    fun getCountries() : Single<List<Country>> {
        return api.getCountries()
    }

}
