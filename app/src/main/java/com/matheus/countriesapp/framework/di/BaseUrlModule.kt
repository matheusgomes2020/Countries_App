package com.matheus.countriesapp.framework.di

import com.matheus.countriesapp.BuildConfig
import com.matheus.countriesapp.framework.di.qualifier.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BaseUrlModule {

    @BaseUrl
    @Provides
    fun providesBaseurl(): String = BuildConfig.BASE_URL

}