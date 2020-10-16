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


    val sortNum = MutableLiveData<Int>(0)
    fun setSortNum(num: Int) {
        sortNum.value = num
    }


}