package com.example.countries.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countries.model.CountriesServices
import com.example.countries.model.Country
import io.reactivex.disposables.CompositeDisposable

class ListViewModel : ViewModel() {

    private val countriesService = CountriesServices()
    private val disposable = CompositeDisposable()

    val countries = MutableLiveData<List<Country>>()
    val countriesLoadingError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchCountries()
    }

    private fun fetchCountries() {
//        loading.value = true
//        disposable.add(
//            countriesService.getCountries()
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(object: DisposableSingleObserver<List<Country>>() {
//                    override fun onSuccess(value: List<Country>) {
//                        countries.value = value
//                        countriesLoadingError.value = false
//                        loading.value = false
//                    }
//
//                    override fun onError(e: Throwable) {
//                        countriesLoadingError.value = true
//                        loading.value = true
//                    }
//                })
//        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}