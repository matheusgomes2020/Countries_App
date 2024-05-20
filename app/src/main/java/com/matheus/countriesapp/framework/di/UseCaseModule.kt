package com.matheus.countriesapp.framework.di

import com.matheus.core.usecase.GetAllCountriesUseCase
import com.matheus.core.usecase.GetAllCountriesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetAllCountriesUseCase(useCase: GetAllCountriesUseCaseImpl
    ): GetAllCountriesUseCase

}