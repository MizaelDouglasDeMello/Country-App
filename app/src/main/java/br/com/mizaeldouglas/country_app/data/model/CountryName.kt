package br.com.mizaeldouglas.country_app.data.model

import com.google.gson.annotations.SerializedName

data class CountryName(
    @SerializedName("common") val common: String,
    @SerializedName("official") val official: String
)
