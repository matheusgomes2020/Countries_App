package com.matheus.core.data.repository

import com.matheus.core.domain.model.Country

interface CountriesRepository {

    fun getAllCountries(): List<Country>

}