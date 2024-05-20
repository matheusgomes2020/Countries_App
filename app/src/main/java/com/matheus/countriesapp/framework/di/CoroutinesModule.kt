package com.matheus.countriesapp.framework.di

import com.matheus.core.usecase.base.AppCoroutinesDispatchers
import com.matheus.core.usecase.base.CoroutinesDispatchers
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface CoroutinesModule {

    @Binds
    fun bindDispatchers(dispatchers: AppCoroutinesDispatchers) : CoroutinesDispatchers

}