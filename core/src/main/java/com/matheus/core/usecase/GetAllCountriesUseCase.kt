package com.matheus.core.usecase

import com.matheus.core.data.repository.CountriesRepository
import com.matheus.core.domain.model.Country
import com.matheus.core.usecase.base.CoroutinesDispatchers
import com.matheus.core.usecase.base.ResultStatus
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetAllCountriesUseCase {

    operator fun invoke(params: GetParams): Flow<ResultStatus<List<Country>>>

    data class GetParams(val param: String)

}

class GetAllCountriesUseCaseImpl @Inject constructor(
    private val repository: CountriesRepository,
    private val dispatchers: CoroutinesDispatchers
) : GetAllCountriesUseCase,
        UseCase<GetAllCountriesUseCase.GetParams, List<Country>>() {

    override suspend fun doWork(
        params: GetAllCountriesUseCase.GetParams
    ): ResultStatus<List<Country>> {
        return withContext(dispatchers.io()) {
            val countriesDeferred = async { repository.getAllCountries() }

            val countries = countriesDeferred.await()

            ResultStatus.Success(countries)
        }
    }
}