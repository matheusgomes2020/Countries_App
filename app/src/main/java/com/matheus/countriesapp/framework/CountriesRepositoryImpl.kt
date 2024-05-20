package com.matheus.countriesapp.framework

import com.matheus.core.data.repository.CountriesRemoteDataSource
import com.matheus.core.data.repository.CountriesRepository
import com.matheus.core.domain.model.Country
import javax.inject.Inject

class CountriesRepositoryImpl @Inject constructor(
    private val remoteDataSource: CountriesRemoteDataSource
): CountriesRepository{
    override suspend fun getAllCountries(): List<Country> {
        return remoteDataSource.fetchAllCountries()
    }
}