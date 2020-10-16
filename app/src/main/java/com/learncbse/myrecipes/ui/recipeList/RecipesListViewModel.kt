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

    // recipes list from databse
    val recipes = recipesRepository.recipes

// search query
    val query = MutableLiveData<String>("")

    fun setQuery(text: String) {
        query.value = text
    }

//sort num
    val sortNum = MutableLiveData<Int>(0)
    fun setSortNum(num: Int) {
        sortNum.value = num
    }


}