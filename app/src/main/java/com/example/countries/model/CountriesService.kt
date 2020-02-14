package com.example.countries.model

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Single
import javax.inject.Inject

class CountriesService {

    @Inject
    var api : CountriesApi

    private val BASE_URL = "https://raw.githubusercontent.com"
    
    init {
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
            .create(CountriesApi::class.java)
    }

    fun getCountries() : Single<List<Country>> {
        return api.getCountries()
    }

}
