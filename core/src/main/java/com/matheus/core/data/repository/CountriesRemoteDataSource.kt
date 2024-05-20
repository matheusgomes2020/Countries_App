package com.matheus.core.data.repository

import com.matheus.core.domain.model.Country

interface CountriesRemoteDataSource {

    suspend fun  fetchAllCountries(): List<Country>

}