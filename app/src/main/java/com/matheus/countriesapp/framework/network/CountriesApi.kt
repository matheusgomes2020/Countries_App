package com.matheus.countriesapp.framework.network

import com.matheus.countriesapp.framework.network.response.CountriesResponse
import com.matheus.countriesapp.framework.network.response.DataWrapperResponse
import retrofit2.http.GET

interface CountriesApi {

    @GET("all")
    suspend fun getCountries() : DataWrapperResponse<CountriesResponse>

}