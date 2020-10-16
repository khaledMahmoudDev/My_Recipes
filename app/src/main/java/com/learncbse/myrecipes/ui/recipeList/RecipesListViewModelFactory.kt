package com.learncbse.myrecipes.ui.recipeList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


// recipeList viewModel factory
class RecipesListViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipesListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RecipesListViewModel(app) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}