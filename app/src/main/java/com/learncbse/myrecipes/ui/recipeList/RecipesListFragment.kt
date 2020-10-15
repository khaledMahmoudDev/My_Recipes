package com.learncbse.myrecipes.ui.recipeList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.learncbse.myrecipes.databinding.RecipesListFragmentBinding

class RecipesListFragment : Fragment() {

    companion object {
        fun newInstance() =
            RecipesListFragment()
    }

    private val viewModel: RecipesListViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onViewCreated()"
        }
        ViewModelProvider(this, RecipesListViewModelFactory(activity.application)).get(
            RecipesListViewModel::class.java
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = RecipesListFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = this



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.recipes.observe(viewLifecycleOwner, Observer {
            Log.d("recipessss", "${it.size}")
        })
    }

}