package com.learncbse.myrecipes.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.learncbse.myrecipes.database.RecipesDataBase
import com.learncbse.myrecipes.datamodel.RecipeModel
import com.learncbse.myrecipes.datamodel.asDataBaseRecipeModel
import com.learncbse.myrecipes.datamodel.asRecipeModel
import com.learncbse.myrecipes.network.RecipesClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


// main repository
// at first data arrives from network then stored on the database and each time we need to use it we get it from Database
class RecipesRepository(private val database: RecipesDataBase) {

// get all recipes from database
    val recipes: LiveData<List<RecipeModel>> =
        Transformations.map(database.recipesDAO.getAllRecipes()) {
            it.asRecipeModel()
        }


    // get all recipes from network the store them on the database for later usage
    suspend fun refreshRecipes() {
        withContext(Dispatchers.IO) {
            try {

                val recipeList = RecipesClient.allRecipes.getRecipes().await()
                database.recipesDAO.insertAllRecipes(*recipeList.asDataBaseRecipeModel())
            } catch (e: Exception) {
                Log.e("repository", "${e.message}")
            }


        }
    }
}