package com.example.countries.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.R
import com.example.countries.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : ListViewModel
    private val countriesAdapter = CountryListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()

        rvCountriesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countriesAdapter
        }

        swipeRefreshLayoutMain.setOnClickListener {
            swipeRefreshLayoutMain.isRefreshing = false
            viewModel.refresh()
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.countries.observe(this, Observer { countries ->
            countries?.let {
                rvCountriesList.visibility = View.VISIBLE
                countriesAdapter.updateCountries(it)}
        })

        viewModel.countriesLoadingError.observe(this, Observer { isError ->
            isError?.let { listError.visibility = if (it) View.VISIBLE else View.GONE }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let { loadingRvCountries.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                     listError.visibility = View.GONE
                     rvCountriesList.visibility = View.GONE
                }
            }
        })
    }
}