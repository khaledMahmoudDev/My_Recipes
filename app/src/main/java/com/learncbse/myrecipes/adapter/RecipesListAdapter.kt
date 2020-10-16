package com.learncbse.myrecipes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.learncbse.myrecipes.databinding.RecipyRowElementBinding
import com.learncbse.myrecipes.datamodel.RecipeModel


// main Adapter for recipes using List adapter
class RecipesListAdapter(private val recipesListItemClickListener: RecipesListItemClickListener) :
    ListAdapter<RecipeModel, RecipesListAdapter.RecipesListViewHolder>(RecipesListDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesListViewHolder {
        return RecipesListViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecipesListViewHolder, position: Int) {
        holder.bind(getItem(position), recipesListItemClickListener)
    }


    //class RecipesListViewHolder as a view holder for the adapter
    class RecipesListViewHolder private constructor(val binding: RecipyRowElementBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: RecipeModel, clickListener: RecipesListItemClickListener) {
            binding.recipe = recipe
            binding.clickListener = clickListener
        }

        companion object {

            //fun to bind each view holder
            fun from(parent: ViewGroup): RecipesListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipyRowElementBinding.inflate(layoutInflater, parent, false)
                return RecipesListViewHolder(binding)
            }
        }

    }


}


// listener for each item click
class RecipesListItemClickListener(val clickListener: (recipe: RecipeModel) -> Unit) {
    fun onRecipeItemClick(recipe: RecipeModel) = clickListener(recipe)
}


// diffutil class to be used by the adapter
class RecipesListDiffUtil : DiffUtil.ItemCallback<RecipeModel>() {
    override fun areItemsTheSame(oldItem: RecipeModel, newItem: RecipeModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: RecipeModel, newItem: RecipeModel): Boolean {
        return oldItem.id == newItem.id
    }

}

