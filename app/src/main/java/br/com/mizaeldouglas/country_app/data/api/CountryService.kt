package br.com.mizaeldouglas.country_app.data.api

import javax.inject.Inject

class CountryService @Inject constructor(private val countryApi: CountryApi) {

    suspend fun getAllCountries() = countryApi.getAllCountries()
    suspend fun getCountriesByName(name: String) = countryApi.getCountriesByName(name)
}