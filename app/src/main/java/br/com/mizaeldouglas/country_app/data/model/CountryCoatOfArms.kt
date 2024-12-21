package br.com.mizaeldouglas.country_app.data.model

import com.google.gson.annotations.SerializedName

data class CountryCoatOfArms(
    @SerializedName("png") val png: String?,
    @SerializedName("svg") val svg: String?
)