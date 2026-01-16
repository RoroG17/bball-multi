package org.example.bballmulti.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Season (
    @SerialName("Id_Saison") val id : Int,
    @SerialName("annee_debut") val startYear : Int,
    @SerialName("annee_fin") val endYear : Int,
    @SerialName("championnat") val league : String,
    @SerialName("categorie") val category : String
    ) {

    fun getText() : String {
        return "$startYear - $endYear"
    }
}