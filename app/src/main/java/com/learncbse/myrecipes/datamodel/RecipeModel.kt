package com.learncbse.myrecipes.datamodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


// default Recipe Model
@Parcelize
data class RecipeModel(
    val id: String = "",
    val calories: String = "",
    val carbos: String = "",
    val description: String = "",
    val difficulty: Int = 0,
    val fats: String = "",
    val headline: String = "",
    val image: String = "",
    val name: String = "",
    val proteins: String = "",
    val thumb: String = "",
    val time: String = ""
) : Parcelable