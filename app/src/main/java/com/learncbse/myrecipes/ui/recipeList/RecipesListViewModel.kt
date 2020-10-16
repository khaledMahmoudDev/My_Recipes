package com.learncbse.myrecipes.ui.recipeList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.learncbse.myrecipes.database.RecipesDataBase.Companion.getInstance
import com.learncbse.myrecipes.repository.RecipesRepository
import kotlinx.coroutines.launch

class RecipesListViewModel(application: Application) : AndroidViewModel(application) {
    private val database = getInstance(application)
    private val recipesRepository = RecipesRepository(database)


    init {
        viewModelScope.launch {
            recipesRepository.refreshRecipes()
        }

    }


    val recipes = recipesRepository.recipes
    val query = MutableLiveData<String>("")


    fun setQuery(text: String) {
        query.value = text
    }


//    var result: LiveData<List<RecipeModel>> = Transformations.map(query) {
//
//        if (it.isNotEmpty()) {
//            recipes.value!!.filter { recipe ->
//                recipe.name.toLowerCase() == it.toLowerCase()
//            }
//        } else {
//            recipes.value
//        }
//    }


//    private fun filter(query: String): List<RecipeModel> {
//
//        return if (query.isNotEmpty()) {
//            recipes.value!!.filter {
//                it.name.toLowerCase() == query.toLowerCase()
//            }
//        } else {
//            recipesRepository.recipes.value
//        }
//    }


}