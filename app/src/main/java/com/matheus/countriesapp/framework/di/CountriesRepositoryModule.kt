package com.matheus.countriesapp.framework.di

import com.matheus.core.data.repository.CountriesRemoteDataSource
import com.matheus.core.data.repository.CountriesRepository
import com.matheus.countriesapp.framework.CountriesRepositoryImpl
import com.matheus.countriesapp.framework.remote.RetrofitCountriesDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CountriesRepositoryModule {

    @Binds
    fun bindCountryRepository(repositoryImpl: CountriesRepositoryImpl): CountriesRepository

    @Binds
    fun bindRemoteDataSource(
        dataSource: RetrofitCountriesDataSource
    ): CountriesRemoteDataSource

}