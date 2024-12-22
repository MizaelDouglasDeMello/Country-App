package br.com.mizaeldouglas.country_app.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryCoatOfArms(
    @SerializedName("png") val png: String?,
    @SerializedName("svg") val svg: String?
): Parcelable