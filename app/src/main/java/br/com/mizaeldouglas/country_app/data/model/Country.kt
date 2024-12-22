package br.com.mizaeldouglas.country_app.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    @SerializedName("name") val name: CountryName,
    @SerializedName("capital") val capital: List<String>?,
    @SerializedName("region") val region: String,
    @SerializedName("subregion") val subregion: String?,
    @SerializedName("population") val population: Long,
    @SerializedName("flags") val flags: CountryFlags,
    @SerializedName("coatOfArms") val coatOfArms: CountryCoatOfArms?,
    @SerializedName("area") val area: Double
) : Parcelable
