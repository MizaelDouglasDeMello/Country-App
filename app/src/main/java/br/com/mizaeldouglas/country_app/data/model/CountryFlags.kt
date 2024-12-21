package br.com.mizaeldouglas.country_app.data.model

import com.google.gson.annotations.SerializedName

data class CountryFlags(
    @SerializedName("png") val png: String,
    @SerializedName("svg") val svg: String
)
