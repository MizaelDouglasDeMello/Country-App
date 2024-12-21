package br.com.mizaeldouglas.country_app.data.repository

import br.com.mizaeldouglas.country_app.data.api.CountryService
import br.com.mizaeldouglas.country_app.data.model.Country
import retrofit2.Response
import javax.inject.Inject

class CountryRepository @Inject constructor(private val countryService: CountryService) {

    suspend fun getAllCountries(): Response<List<Country>>{
        return countryService.getAllCountries()
    }

    suspend fun getCountriesByName(name: String): Response<List<Country>>{
        return countryService.getCountriesByName(name)
    }

}