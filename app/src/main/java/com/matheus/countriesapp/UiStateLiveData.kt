package com.matheus.countriesapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.matheus.core.domain.model.Country
import com.matheus.core.usecase.GetAllCountriesUseCase
import kotlin.coroutines.CoroutineContext

class UiStateLiveData(
    private  val coroutineContext: CoroutineContext,
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) {

    private val action = MutableLiveData<Action>()
    val state: LiveData<UiState> = action.switchMap {
        liveData(coroutineContext) {
            when (it) {
                is Action.Load -> {
                    getAllCountriesUseCase.invoke(
                        GetAllCountriesUseCase.GetParams("")
                    ).watchStatus(
                        loading = {
                            emit(UiState.Loading)
                        },
                        success = { data ->
                            val list = mutableListOf<Country>()

                            val countries = data
                            if (countries.isNotEmpty()) {
                                countries.map {
                                    Country(it.name)
                                }
                            }


                            if (list.isNotEmpty()) {
                                emit(UiState.Success(list))
                            } else emit(UiState.Empty)
                        },
                        error = {
                            emit(UiState.Error)
                        }
                    )
                }
            }
        }
    }

    sealed class UiState {
        object Loading : UiState()
        data class Success(val list: List<Country>) : UiState()
        object Error : UiState()
        object Empty : UiState()
    }

    sealed class Action {
        data class Load(val param: String) : Action()
    }
}

