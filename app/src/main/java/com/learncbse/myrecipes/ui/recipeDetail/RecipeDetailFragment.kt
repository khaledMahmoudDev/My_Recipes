package com.learncbse.myrecipes.ui.recipeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.learncbse.myrecipes.databinding.RecipeDetailFragmentBinding
import kotlinx.android.synthetic.main.activity_main.*

class RecipeDetailFragment : Fragment() {

    companion object {
        fun newInstance() = RecipeDetailFragment()
    }

    private lateinit var viewModel: RecipeDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = RecipeDetailFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val navArgs: RecipeDetailFragmentArgs by navArgs()

        val selectedRecipe = navArgs.selectedRecipe


        binding.recipe = selectedRecipe

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RecipeDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}