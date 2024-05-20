package com.matheus.countriesapp.framework.remote

import com.matheus.core.data.repository.CountriesRemoteDataSource
import com.matheus.core.domain.model.Country
import com.matheus.countriesapp.framework.network.CountriesApi
import com.matheus.countriesapp.framework.network.response.toCountryModel
import javax.inject.Inject

class RetrofitCountriesDataSource @Inject constructor(
    private val countriesApi: CountriesApi
) : CountriesRemoteDataSource {
    override suspend fun fetchAllCountries(): List<Country> {
        return countriesApi.getCountries().data.map {
            it.toCountryModel()
        }
    }

}