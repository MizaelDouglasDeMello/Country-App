package br.com.mizaeldouglas.country_app.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryName(
    @SerializedName("common") val common: String,
    @SerializedName("official") val official: String
): Parcelable
