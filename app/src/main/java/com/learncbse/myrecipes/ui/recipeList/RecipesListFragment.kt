package com.learncbse.myrecipes.ui.recipeList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learncbse.myrecipes.R

class RecipesListFragment : Fragment() {

    companion object {
        fun newInstance() =
            RecipesListFragment()
    }

    private lateinit var viewModel: RecipesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recipes_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecipesListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}