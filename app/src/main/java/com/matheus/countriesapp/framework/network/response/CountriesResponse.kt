package com.matheus.countriesapp.framework.network.response

import com.google.gson.annotations.SerializedName
import com.matheus.core.domain.model.Country

data class CountriesResponse(
    @SerializedName("name")
    val name: String
)

fun CountriesResponse.toCountryModel(): Country {
    return Country(
        name = this.name
    )
}
