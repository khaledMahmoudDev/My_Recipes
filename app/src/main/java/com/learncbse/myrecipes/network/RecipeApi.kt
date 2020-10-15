package com.learncbse.myrecipes.network

import com.learncbse.myrecipes.data.RecipeModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RecipeApi {

    @GET("android-test/recipes.json")
    fun getRecipes(): Deferred<List<RecipeModel>>

}