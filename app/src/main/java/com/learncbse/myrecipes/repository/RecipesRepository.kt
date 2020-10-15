package com.learncbse.myrecipes.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.learncbse.myrecipes.database.RecipesDataBase
import com.learncbse.myrecipes.datamodel.RecipeModel
import com.learncbse.myrecipes.datamodel.asDataBaseRecipeModel
import com.learncbse.myrecipes.datamodel.asRecipeModel
import com.learncbse.myrecipes.network.RecipesClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipesRepository(private val database: RecipesDataBase) {


    val recipes: LiveData<List<RecipeModel>> =
        Transformations.map(database.recipesDAO.getAllRecipes()) {
            it.asRecipeModel()
        }

    suspend fun refreshRecipes() {
        withContext(Dispatchers.IO) {
            val recipeList = RecipesClient.allRecipes.getRecipes().await()

            database.recipesDAO.insertAllRecipes(*recipeList.asDataBaseRecipeModel())
        }
    }
}