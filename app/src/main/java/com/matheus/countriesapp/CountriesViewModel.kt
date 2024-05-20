package com.matheus.countriesapp

import androidx.lifecycle.ViewModel
import com.matheus.core.usecase.GetAllCountriesUseCase
import com.matheus.core.usecase.base.CoroutinesDispatchers
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase,
    coroutinesDispatchers: CoroutinesDispatchers
): ViewModel() {

    val countries = UiStateLiveData(
        coroutinesDispatchers.main(),
        getAllCountriesUseCase
    )


}