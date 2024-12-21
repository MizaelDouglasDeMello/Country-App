package br.com.mizaeldouglas.country_app.data.api

import br.com.mizaeldouglas.country_app.data.model.Country
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryApi {

    @GET("all")
    suspend fun getAllCountries(): Response<List<Country>>

    @GET("name/{name}")
    suspend fun getCountriesByName(@Path("name") name: String): Response<List<Country>>
}