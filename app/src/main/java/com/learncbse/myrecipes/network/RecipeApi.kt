package com.learncbse.myrecipes.network

import com.learncbse.myrecipes.datamodel.NetworkRecipeModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


// network Interface
interface RecipeApi {


    //return all recipes from api as liveData
    @GET("android-test/recipes.json")
    fun getRecipes(): Deferred<List<NetworkRecipeModel>>

}