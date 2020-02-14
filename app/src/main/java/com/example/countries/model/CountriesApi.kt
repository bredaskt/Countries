package com.example.countries.model

import retrofit2.http.GET
import rx.Single

interface CountriesApi {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries() : Single<List<Country>>


}